package com.hust.bigdataplatform.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.StudentScoreMapper;
import com.hust.bigdataplatform.model.StudentScore;

@Repository
public class StudentScoreDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentScoreDao.class);
	@Autowired 
	private StudentScoreMapper studentScoreMapper;
	/**
	 * 根据学号和课程号，查找学生的各种成绩
	 * @param stuId
	 * @param courseId
	 * @return
	 */
	public StudentScore findByStuIdAndCourseId(String stuId, String courseId){
		return null;
		
	}
}
