package com.hust.bigdataplatform.service;

import java.util.List;
import java.util.Map;

import com.hust.bigdataplatform.model.StudentScore;

public interface StudentScoreService {
	
	public StudentScore findByStuIdAndCourseId(String stuId, String courseId);
	
	public int add(StudentScore studentScore);
	
	public int update(StudentScore studentScore);
	
	public int addByStuIdAndCourseId(String stuId, String courseId);
	
	public List<Map<String, String>> ShowStudentFinalScore(String courseId);

}
