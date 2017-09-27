package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.StudentMapper;
import com.hust.bigdataplatform.model.StudentExample.Criteria;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentExample;

@Repository
public class StudentDao {
	private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);
	
	@Autowired
	private StudentMapper studentMapper;
	
	public List<Student> selectStudents(int start, int limit){
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdIsNotNull();
	//	example.setStart(start);
	//	example.setLimit(limit);
		List<Student> students = studentMapper.selectByExample(example);
		return students;
	}
}
