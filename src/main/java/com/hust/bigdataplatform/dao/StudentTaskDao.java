package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.StudentTaskMapper;
import com.hust.bigdataplatform.model.StudentTask;
import com.hust.bigdataplatform.model.StudentTaskExample;
import com.hust.bigdataplatform.model.StudentTaskExample.Criteria;

@Repository
public class StudentTaskDao {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentTaskDao.class);
	@Autowired
	private StudentTaskMapper studentTaskMapper;
	/**
	 * 根据学号和作业号，查找该同学的本次作业成绩
	 * @param stuId
	 * @param taskId
	 * @return
	 */
	public StudentTask findByStuIdAndTaskId(String stuId, String taskId)
	{
		return studentTaskMapper.selectByPrimaryKey(stuId, taskId);
		
	}
	/**
	 * 根据学号查找该学生的所有成绩
	 * @param stuId
	 * @return
	 */
	public List<StudentTask> findByStudentId(String stuId)
	{
		StudentTaskExample example = new StudentTaskExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(stuId);
		return studentTaskMapper.selectByExample(example);
		
	}
	
	public int add(StudentTask studentTask)
	{
		return studentTaskMapper.insertSelective(studentTask);
	}
}
