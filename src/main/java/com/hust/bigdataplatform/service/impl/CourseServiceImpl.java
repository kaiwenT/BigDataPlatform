package com.hust.bigdataplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseDao;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	@Override
	public Course findCourseById(String courseId) {
		// TODO Auto-generated method stub
		return courseDao.findById(courseId);
	}
	@Override
	public int addCourse(Course course) {
		if(course == null){
			return 0;
		}
		return courseDao.insert(course);
	}
	@Override
	public int updateCourse(Course course) {
		if(course == null){
			return 0;
		}
		return courseDao.updateByCourseId(course);
	}
	@Override
	public int deleteCourse(String courseId) {
		if(courseId == null){
			return 0;
		}
		return courseDao.deleteById(courseId);
	}
	
}
