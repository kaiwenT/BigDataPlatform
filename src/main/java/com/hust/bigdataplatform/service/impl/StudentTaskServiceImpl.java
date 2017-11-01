package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.StudentTaskDao;
import com.hust.bigdataplatform.model.CourseTask;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentTask;
import com.hust.bigdataplatform.service.CourseTaskService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentTaskService;
@Service
public class StudentTaskServiceImpl implements StudentTaskService {

	@Autowired
	private StudentTaskDao studentTaskDao;
	@Autowired
	private CourseTaskService courseTaskService;
	@Autowired 
	private StudentCourseService studentCourseService;
	
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
		List<CourseTask> courseTasks = courseTaskService.findByCourseId(courseId);
		float score=0;
		for (CourseTask courseTask : courseTasks) {
			if (courseTask==null) {
				continue;
			}
			else {
				StudentTask studentTask = studentTaskDao.findByStuIdAndTaskId(stuId, courseTask.getTaskId());
				if (studentTask==null) {
					score = score;
				}
				else {
					score=score+studentTask.getTaskScore();
				}
			}
		}
		score = score/courseTasks.size();
		return score;
	}
	
	/**
	 * //显示平时成绩： 考勤成绩、作业一、作业二.... 平时总成绩
	 */
	@Override
	public List<Map<String, String>> ShowUsualScore(String courseId) {
		List<Student> students = studentCourseService.findBycourseId(courseId);
		//作业数目
		int tasknum = courseTaskService.findByCourseId(courseId).size();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Student student : students) {
			Map<String, String> map = new HashMap<>();
			map.put("studentId", student.getStudentId());  //学号
			map.put("studentname", student.getStudentName());  //姓名
			map.put("tasknum", tasknum+"");  //作业个数
			//该课程的作业列表
			List<CourseTask> courseTasks = courseTaskService.findByCourseId(courseId);
			for (CourseTask courseTask : courseTasks) {
				StudentTask studentTask = studentTaskDao.findByStuIdAndTaskId(student.getStudentId(), courseTask.getTaskId());
				String s;
				if (studentTask==null) {  //查找的记录不存在，则默认成绩为0；
					String i = "0";
					map.put(courseTask.getTaskId(), i);  //作业成绩
				}
				else {
					map.put(courseTask.getTaskId(), String.valueOf(studentTask.getTaskScore()));  //作业成绩
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

}
