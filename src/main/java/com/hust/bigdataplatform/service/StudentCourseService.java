package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentCourse;


public interface StudentCourseService {
	
	/**
	 * 查找学生所选课程
	 * @param studentId
	 * @return
	 */
	public List<Course> selectCoursesByStudent(String studentId);
	
	/**
	 * 查找学生所选所有课程 及成绩
	 * @param studentId
	 * @return
	 */
	public List<StudentCourse> findStudentCourseByStuId(String studentId);
	
	/**
	 * 查找学生某门课程成绩
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public StudentCourse findStudentCourseByStuId(String studentId, String courseId);
}
