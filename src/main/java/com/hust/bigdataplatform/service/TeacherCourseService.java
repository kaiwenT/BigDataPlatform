package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Teacher;

public interface TeacherCourseService {
	
	/**
	 * 查找教师所教授的课程
	 * @param teacherid
	 * @return
	 */
	public List<Course> getCourseByTeacherid(String teacherid);
	/**
	 * 查找课程对应的老师
	 * @param courseid
	 * @return
	 */
	public Teacher getTeacherByCourseid(String courseid);

}
