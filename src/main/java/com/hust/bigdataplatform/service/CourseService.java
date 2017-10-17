package com.hust.bigdataplatform.service;

import com.hust.bigdataplatform.model.Course;

public interface CourseService {

	/**
	 * 查找课程
	 * @param courseId 课程id
	 * @return
	 */
	public Course findCourseById(String courseId);
	/**
	 * 添加课程记录
	 * @param course
	 * @return
	 */
	public int addCourse(Course course);
	/**
	 * 更新课程
	 * @param course
	 * @return
	 */
	public int updateCourse(Course course);
	/**
	 * 删除课程
	 * @param courseId
	 * @return
	 */
	public int deleteCourse(String courseId);
}
