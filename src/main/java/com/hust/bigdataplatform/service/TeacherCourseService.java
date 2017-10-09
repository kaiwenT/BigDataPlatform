package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.TeacherCourse;

public interface TeacherCourseService {
	
	/**
	 * 查找教师所教授的课程
	 * @param teacherid
	 * @return
	 */
	public List<TeacherCourse> selectByTeacherid(String teacherid);

}
