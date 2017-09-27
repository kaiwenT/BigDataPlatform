package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.TeacherMapper;
import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.model.TeacherExample;
/**
 * 该类主要实现对teacher的增删查改
 * @author 秦念念
 *
 */
@Repository
public class TeacherDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Teacher.class);
	@Autowired
	private TeacherMapper teacherMapper;
	
	//为teacher表中增加教师，参数为实体类Teacher
	public int insert(Teacher teacher)
	{
		return teacherMapper.insert(teacher);
	}
	//根据教师ID从表中删除对应的记录
	public int deleteById(String teacherId)
	{
		return teacherMapper.deleteByPrimaryKey(teacherId);
	}
	//根据教师ID查找教师
	public Teacher findById(String teacherId)
	{
		 return teacherMapper.selectByPrimaryKey(teacherId);
	}
	
	

}
