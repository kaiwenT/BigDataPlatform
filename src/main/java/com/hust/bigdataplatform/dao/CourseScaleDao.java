package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.CourseMapper;
import com.hust.bigdataplatform.dao.mapper.CourseScaleMapper;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseScale;
import com.hust.bigdataplatform.model.CourseScaleExample;
import com.hust.bigdataplatform.model.CourseScaleExample.Criteria;
/**
 * 对course_scale课程评分标准表增删改查
 * @author tankai
 *
 */
@Repository
public class CourseScaleDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseScaleDao.class);
	@Autowired
	private CourseScaleMapper courseScaleMapper;
	
	//为course表中增加课程，参数为实体类course
	public int insert(CourseScale record){
		return courseScaleMapper.insertSelective(record);
	}
	//根据课程ID从表中删除对应的记录
	public int deleteByCourseId(String courseId){
		CourseScaleExample example = new CourseScaleExample();
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		return courseScaleMapper.deleteByExample(example);
	}
	
	//根据课程ID查找课程的评分标准
	public CourseScale findByCourseId(String courseId){
		return courseScaleMapper.selectByPrimaryKey(courseId);
	}
	
	//根据课程ID,修改课程的评分标准
	public int updateByCourseId(CourseScale record){
		return courseScaleMapper.updateByPrimaryKeySelective(record);
	}

}
