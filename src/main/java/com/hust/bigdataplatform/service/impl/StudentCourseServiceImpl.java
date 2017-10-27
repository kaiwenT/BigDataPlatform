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
import com.hust.bigdataplatform.model.StudentCourseExample;
import com.hust.bigdataplatform.model.StudentCourseExample.Criteria;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentService;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {
	private static final Logger logger = LoggerFactory.getLogger(StudentCourseServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentCourseDao studentCourseDao;
	@Autowired
	private CourseDao courseDao;
	
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
	

}
