package com.hust.bigdataplatform.dao;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.CourseChapterMapper;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.CourseChapterExample;
import com.hust.bigdataplatform.model.CourseChapterExample.Criteria;

/**
 * 章节相关操作
 * @author Administrator
 *
 */
@Repository
public class CourseChapterDao {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseChapterDao.class);
	@Autowired
	private CourseChapterMapper courseChapterMapper;
	/**
	 * 为课程添加章节
	 * @return
	 */
	public int insert(CourseChapter courseChapter) {
		return courseChapterMapper.insertSelective(courseChapter);
		
	}
	/**
	 * 根据chapterid 和courseID来删除记录
	 * @param chapterId
	 * @return
	 */
	public int deleteById(String chapterId, String courseId)
	{
		return courseChapterMapper.deleteByPrimaryKey(chapterId, courseId);
	}
	/**
	 * 根据课程号寻找该课程下所有的章节信息
	 * @param courseId
	 * @return
	 */
	public List<CourseChapter> selectByCourseId(String courseId)
	{
		CourseChapterExample example = new CourseChapterExample();
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(courseId);
		return courseChapterMapper.selectByExample(example);
	}
	
	public int update(CourseChapter courseChapter)
	{
		return courseChapterMapper.updateByPrimaryKeySelective(courseChapter);
	}

}
