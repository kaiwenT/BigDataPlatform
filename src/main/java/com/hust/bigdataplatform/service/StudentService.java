package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;


public interface StudentService {
	/**
	 * 查找所有学生
	 * @param start
	 * @param limit
	 * @return
	 */
	public List<Student> selectAllStudents(int start, int limit);
	/**
	 * 学生登录
	 * @param id 学号
	 * @param pwd 密码
	 * @return 1 登录成功 0登录失败
	 */
	public int login(String id, String pwd);
	
	/**
	 * 根据学号查找学生
	 * @param studentId
	 * @return
	 */
	public Student selectStudentById(String studentId);
	
	public int add(List<Student> student);
	
}
