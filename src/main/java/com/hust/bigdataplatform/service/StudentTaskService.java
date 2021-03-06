package com.hust.bigdataplatform.service;

import java.util.List;
import java.util.Map;

import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentTask;

public interface StudentTaskService {

	public StudentTask findByStuIdAndTaskId(String stuId, String taskId);
	
	public List<StudentTask> findByStudentId(String stuId);
	
	public int add(StudentTask studentTask);
	
	public int addForStudentTask(String courseId, String chapter);
	
	public int addForStudentTask(String courseId, List<Student> students);
	
	public float getAvgTaskScore(String stuId, String courseId);
	
	public List<Map<String, String>> ShowUsualScore(String courseId);
}
