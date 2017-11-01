package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseDao;
import com.hust.bigdataplatform.dao.StudentCourseDao;
import com.hust.bigdataplatform.dao.StudentDao;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentCourse;
import com.hust.bigdataplatform.model.params.StudentAndGroup;
import com.hust.bigdataplatform.service.CourseScaleService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.service.StudentTaskService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	private static final Logger logger = LoggerFactory.getLogger(StudentCourseServiceImpl.class);
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentCourseDao studentCourseDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private CourseScaleService courseScaleService;
	@Autowired
	private StudentTaskService studentTaskService;
	@Autowired
	private StudentService studentService;
	
	@Override
	public List<Course> selectCoursesByStudent(String studentId) {
		List<StudentCourse> studentCourses = studentCourseDao.findCourseByStudentId(studentId);
		if(studentCourses.isEmpty()){
			return null;
		}
		List<Course> courses = new ArrayList<>();
		for(StudentCourse sc : studentCourses){
			Course c = courseDao.findById(sc.getCourseId());
			if(c != null){
				courses.add(c);
			}
		}
		return courses;
	}

	@Override
	public List<StudentCourse> findStudentCourseByStuId(String studentId) {
		
		return studentCourseDao.findCourseByStudentId(studentId);
	}

	@Override
	public StudentCourse findStudentCourseByStuId(String studentId, String courseId) {
		
		return studentCourseDao.findByPrimaryKey(studentId, courseId);
	}
    /**
     * 计算某个学生的平时总成绩，计算公式为 考勤成绩*%+作业平均成绩*%
     */
	@Override
	public int getFinalUsualScore(String studentId, String courseId) {
		if (studentId==null||studentId.equals("")) {
			return 0;
		}
		//平时成绩作业占比
		float exercise_rate = courseScaleService.findByCourseId(courseId).getExerciseRate();
		int attendancescore = studentCourseDao.findByPrimaryKey(studentId, courseId).getAttendancerate();
		int score = (int) (attendancescore*(1-exercise_rate)+(studentTaskService.getAvgTaskScore(studentId, courseId))*exercise_rate);
		return score;
	}

	@Override
	public List<Student> findBycourseId(String courseId) {
		if (courseId==null||courseId.equals("")) {
			return null;
		}
		List<Student> students = new ArrayList<Student>();
		List<StudentCourse> studentCourses = studentCourseDao.findStudentByCourseId(courseId);
		for (StudentCourse studentCourse : studentCourses) {
			Student student = studentService.selectStudentById(studentCourse.getStudentId());
			if (student!=null) {
				students.add(student);
			}
		}
		return students;
	}

	@Override
	public int insert(List<StudentAndGroup> StudentAndGroups, String courseId) {
		if (StudentAndGroups.size()==0||StudentAndGroups==null) {
			return 0;
		}
		for (StudentAndGroup studentAndGroup : StudentAndGroups) {
			StudentCourse sCourse = new StudentCourse();
			sCourse = studentCourseDao.findByPrimaryKey(studentAndGroup.getStudentId(), courseId);
			if (sCourse==null) {
				StudentCourse studentCourse = new StudentCourse();
				studentCourse.setCourseId(courseId);
				String string = studentAndGroup.getStudentId();
				studentCourse.setStudentId(string);
				studentCourse.setStudentGroupid(studentAndGroup.getGroupId());
				int s= studentCourseDao.insertSelective(studentCourse);
				if (s==0) {
					return 0;
				}
			}
		}
		return 1;
	}
	
	
}
