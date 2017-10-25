package com.hust.bigdataplatform.service;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.hust.bigdataplatform.model.ChapterSection;

public interface ChapterSectionService {
	
	/**
	 * 增加节
	 */
	public int insertSection(ChapterSection chapterSection);
	
	/**
	 * 删除节
	 */
	public int deleteSection(String chapterSectionId);
	/**
	 * 根据章ID查找节
	 */
	public List<ChapterSection> selectByChapterId(String chapterId);
	
	public ChapterSection selectBySectionId(String sectionId);
	/**
	 * 修改节
	 */
	public int Update(ChapterSection chapterSection);
	

}
