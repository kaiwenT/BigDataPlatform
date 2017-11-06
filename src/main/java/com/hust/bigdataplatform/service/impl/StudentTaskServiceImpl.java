package com.hust.bigdataplatform.service.impl;

import java.nio.charset.spi.CharsetProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.StudentTaskDao;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentTask;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentTaskService;
@Service
public class StudentTaskServiceImpl implements StudentTaskService {

	@Autowired
	private StudentTaskDao studentTaskDao;
	@Autowired 
	private StudentCourseService studentCourseService;
	
	@Autowired
	private CourseChapterService courseChapterService;
	
	@Override
	public StudentTask findByStuIdAndTaskId(String stuId, String taskId) {
		if (stuId==null||stuId.equals("")||taskId==null||taskId.equals("")) {
			return null;
		}
		return studentTaskDao.findByStuIdAndTaskId(stuId, taskId);
	}

	@Override
	public List<StudentTask> findByStudentId(String stuId) {
		if (stuId==null||stuId.equals("")) {
			return null;
		}
		return findByStudentId(stuId);
	}

	@Override
	public int add(StudentTask studentTask) {
		if (studentTask==null) {
			return 0;
		}
		return studentTaskDao.add(studentTask);
	}

	/**
	 * 根据学号和课程号得出得出学生本门课程的 作业平均成绩
	 */
	@Override
	public float getAvgTaskScore(String stuId, String courseId) {

		//首先是根据course找出taskID
		List<CourseChapter> courseChapters = courseChapterService.selectByCourseID(courseId);
		float score=0;
		for (CourseChapter c : courseChapters) {
			if (c==null) {
				continue;
			}
			else {
				StudentTask studentTask = studentTaskDao.findByStuIdAndTaskId(stuId, c.getChapterId());
				if (studentTask==null) {
					score = score;
				}
				else {
					score=score+studentTask.getTaskScore();
				}
			}
		}
		score = score/courseChapters.size();
		return score;
	}
	
	/**
	 * //显示平时成绩： 考勤成绩、作业一、作业二.... 平时总成绩, 其中作业ID
	 */
	@Override
	public List<Map<String, String>> ShowUsualScore(String courseId) {
		List<Student> students = studentCourseService.findBycourseId(courseId);
		//作业数目
		int tasknum = courseChapterService.selectByCourseID(courseId).size();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Student student : students) {
			Map<String, String> map = new HashMap<>();
			map.put("studentId", student.getStudentId());  //学号
			map.put("studentname", student.getStudentName());  //姓名
			map.put("tasknum", tasknum+"");  //作业个数
			//该课程的作业列表
			List<CourseChapter> courseChapters = courseChapterService.selectByCourseID(courseId);
			for (CourseChapter c : courseChapters) {
				StudentTask studentTask = studentTaskDao.findByStuIdAndTaskId(student.getStudentId(), c.getChapterId());
				String s;
				if (studentTask==null) {  //查找的记录不存在，则默认成绩为0；
					String i = "0";
					map.put(c.getChapterName(), i);  //作业成绩
				}
				else {
					map.put(c.getChapterName(), String.valueOf(studentTask.getTaskScore()));  //作业成绩
				}
			}
			int attendenceScore = studentCourseService.findStudentCourseByStuId(student.getStudentId(), courseId).getAttendancerate();
			map.put("attendenceScore", String.valueOf(attendenceScore));  //考勤成绩
			int finalUsualScore = studentCourseService.getFinalUsualScore(student.getStudentId(), courseId);
			map.put("finalUsualScore", String.valueOf(finalUsualScore));  //总成绩
			list.add(map);
		}
		return list;
	}
	/**
	 * 添加章节时，初始化studentTask表
	 */
	@Override
	public int addForStudentTask(String courseId, String chapter) {
		List<Student> students = studentCourseService.findBycourseId(courseId);
		if (students==null||students.size()==0) {
			return 2;
		}
		for (Student student : students) {
			StudentTask sTask = studentTaskDao.findByStuIdAndTaskId(student.getStudentId(), chapter);
			if (sTask==null) {
				StudentTask studentTask = new StudentTask();
				studentTask.setStudentId(student.getStudentId());
				studentTask.setTaskId(chapter);
				int i = 0;
				studentTask.setTaskScore(i);
				int status = studentTaskDao.add(studentTask);
				if (status==0) {
					return 0;
				}
			}
		}
		return 1;
	}
	/**
	 * 添加学生名单成功后，初始化学生作业表
	 */
	@Override
	public int addForStudentTask(String courseId, List<Student> students) {
		if (students.size()==0||students==null) {
			return 0;
		}
		List<CourseChapter> courseChapters = courseChapterService.selectByCourseID(courseId);
		if (courseChapters.size()==0||courseChapters==null) {
			return 2;
		}
		for (CourseChapter courseChapter : courseChapters) {
			String chapid=courseChapter.getChapterId();
			if (chapid!=null&&chapid!="") {
				for (Student student : students) {
					String stuId = student.getStudentId();
					if (stuId!=null&&stuId!="") {
						StudentTask sTask = studentTaskDao.findByStuIdAndTaskId(student.getStudentId(), chapid);
						if (sTask==null) {
							StudentTask studentTask = new StudentTask();
							studentTask.setStudentId(student.getStudentId());
							studentTask.setTaskId(chapid);
							int i = 0;
							studentTask.setTaskScore(i);
							int s=studentTaskDao.add(studentTask);
							if (s==0) {
								return 0;
							}
						}
					}
				}
			}
		}
		return 1;
	}

}
