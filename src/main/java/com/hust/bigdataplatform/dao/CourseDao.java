package com.hust.bigdataplatform.dao;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.CourseMapper;
import com.hust.bigdataplatform.model.Course;
/**
 * 该类主要实现对课程表的 增删查改
 * @author niannian
 *
 */
@Repository
public class CourseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Course.class);
	@Autowired
	private CourseMapper courseMapper;
	
	//为course表中增加课程，参数为实体类course
	public int insert(Course course)
	{
		return courseMapper.insertSelective(course);
	}
	//根据课程ID从表中删除对应的记录
	public int deleteById(String courseId)
	{
		return courseMapper.deleteByPrimaryKey(courseId);
	}
	//根据课程ID查找课程
	public Course findById(String courseId)
	{
		 return courseMapper.selectByPrimaryKey(courseId);
	}
	
	//根据课程ID,修改课程信息
	public int updateByCourseId(Course course)
	{
		return courseMapper.updateByPrimaryKey(course);
	}

}
