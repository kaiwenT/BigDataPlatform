package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;


public interface StudentCourseService {
	
	/**
	 * 查找学生所选课程
	 * @param studentId
	 * @return
	 */
	public List<Course> selectCoursesByStudent(String studentId);
	
	
}
