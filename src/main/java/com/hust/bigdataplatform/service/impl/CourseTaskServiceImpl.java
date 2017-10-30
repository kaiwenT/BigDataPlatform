package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseTaskDao;
import com.hust.bigdataplatform.model.CourseTask;
import com.hust.bigdataplatform.service.CourseTaskService;
@Service
public class CourseTaskServiceImpl implements CourseTaskService {

	@Autowired
	private CourseTaskDao courseTaskDao;
	
	@Override
	public List<CourseTask> findByCourseId(String courseId) {
		if (courseId==null||courseId.equals("")) {
			return null;
		}
		return courseTaskDao.findByCourseId(courseId);
	}

}
