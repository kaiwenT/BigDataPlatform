package com.hust.bigdataplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseScaleDao;
import com.hust.bigdataplatform.model.CourseScale;
import com.hust.bigdataplatform.service.CourseScaleService;
@Service
public class CourseScaleServiceImpl implements CourseScaleService {
	@Autowired
	private CourseScaleDao courseScaleDao;
	
	@Override
	public CourseScale findByCourseId(String courseId) {
		if(courseId == null || "".equals(courseId)){
			return null;
		}
		return courseScaleDao.findByCourseId(courseId);
	}

	@Override
	public int delete(String courseId) {
		if(courseId == null || "".equals(courseId)){
			return 0;
		}
		return courseScaleDao.deleteByCourseId(courseId);
	}

	@Override
	public int update(CourseScale record) {
		if(record == null){
			return 0;
		}
		return courseScaleDao.updateByCourseId(record);
	}

	@Override
	public int add(CourseScale record) {
		if(record == null){
			return 0;
		}
		return courseScaleDao.insert(record);
	}

}
