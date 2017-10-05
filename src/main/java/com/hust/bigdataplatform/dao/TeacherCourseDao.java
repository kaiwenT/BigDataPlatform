package com.hust.bigdataplatform.dao;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.TeacherCourseMapper;
import com.hust.bigdataplatform.model.TeacherCourse;
import com.hust.bigdataplatform.model.TeacherCourseExample;
import com.hust.bigdataplatform.model.TeacherCourseExample.Criteria;

/**
 * 该类主要实现 教师-课程表的 增删查改工作
 * @author niannian
 *
 */
@Repository
public class TeacherCourseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherCourse.class);
	@Autowired
	private TeacherCourseMapper teacherCourseMapper;
	
	/**
	 * 添加教师授课的记录
	 * @param teacherCourse
	 * @return
	 */
	public int insert(TeacherCourse teacherCourse)
	{
		return teacherCourseMapper.insertSelective(teacherCourse);
		
	}

	/**
	 * 根据教师ID和课程ID删除记录
	 * @param teacherId
	 * @param courseId
	 * @return
	 */
	public int deleteByTeacherId(String teacherId, String courseId)
	{
		return teacherCourseMapper.deleteByPrimaryKey(teacherId, courseId);
	}
	/**
	 * 根据教师ID，寻找该教师授课的所有课程
	 * @param teacherId
	 * @return
	 */
	public List<TeacherCourse> selectByTeacherID(String teacherId)
	{
		TeacherCourseExample example = new TeacherCourseExample();
		Criteria criteria  = example.createCriteria();
		criteria.andTeacherIdEqualTo(teacherId);
		List<TeacherCourse> list = teacherCourseMapper.selectByExample(example);
		return list;
		
	}
	
	/**
	 * 根据课程ID，寻找该课程对应的授课老师
	 * @param courseId
	 * @return
	 */
	public List<TeacherCourse> selectByCourseId(String courseId)
	{
		TeacherCourseExample example = new TeacherCourseExample();
		Criteria criteria  = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		List<TeacherCourse> list = teacherCourseMapper.selectByExample(example);
		return list;
	}
	
	
}
