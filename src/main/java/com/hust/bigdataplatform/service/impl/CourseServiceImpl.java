package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.mapper.CourseMapper;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.service.CourseService;
@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseMapper courseMapper;
	@Override
	public Course findCourseById(String courseId) {
		// TODO Auto-generated method stub
		return courseMapper.selectByPrimaryKey(courseId);
	}
	
}
