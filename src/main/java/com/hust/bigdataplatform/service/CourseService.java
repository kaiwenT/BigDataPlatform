package com.hust.bigdataplatform.service;



import com.hust.bigdataplatform.model.Course;

public interface CourseService {

	/**
	 * 查找课程
	 * @param courseId 课程id
	 * @return
	 */
	public Course findCourseById(String courseId);
	
}
