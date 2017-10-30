package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.CourseTaskMapper;
import com.hust.bigdataplatform.model.CourseTask;
import com.hust.bigdataplatform.model.CourseTaskExample;
import com.hust.bigdataplatform.model.CourseTaskExample.Criteria;

@Repository
public class CourseTaskDao {
	private static final Logger logger = LoggerFactory.getLogger(CourseTaskDao.class);
	@Autowired
	private CourseTaskMapper courseTaskMapper;
	/**
	 * 根据课程ID查找，该课程下的作业
	 * @param courseId
	 * @return
	 */
	public List<CourseTask> findByCourseId(String courseId)
	{
		CourseTaskExample example =  new CourseTaskExample();
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		return courseTaskMapper.selectByExample(example);
	}
}
