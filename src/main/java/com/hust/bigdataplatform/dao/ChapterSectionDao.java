package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.ChapterSectionMapper;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.ChapterSectionExample;
import com.hust.bigdataplatform.model.ChapterSectionExample.Criteria;

@Repository
public class ChapterSectionDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ChapterSectionDao.class);
	@Autowired
	private ChapterSectionMapper chapterSectionMapper;
	
	public int insert(ChapterSection chapterSection) {
		return chapterSectionMapper.insert(chapterSection);
	}
	
	public int deleteById(String chapterSectionId)
	{
		return chapterSectionMapper.deleteByPrimaryKey(chapterSectionId);
	}
	/**
	 * 根据章节id查找节信息
	 * @param chapterId
	 * @return
	 */
	public List<ChapterSection> selectByChapterId(String chapterId)
	{
		ChapterSectionExample example = new ChapterSectionExample();
		Criteria criteria = example.createCriteria();
		criteria.andChapterIdEqualTo(chapterId);
		return chapterSectionMapper.selectByExample(example);
	}
	/**
	 * 根据节id查找节信息
	 * @param sectionId
	 * @return
	 */
	public ChapterSection selectById(String sectionId)
	{
		return chapterSectionMapper.selectByPrimaryKey(sectionId);
	}
	public int update(ChapterSection chapterSection)
	{
		return chapterSectionMapper.updateByPrimaryKeySelective(chapterSection);
	}
	
}
