package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.CourseTask;

public interface CourseTaskService {
	
	public List<CourseTask> findByCourseId(String courseId);

}
