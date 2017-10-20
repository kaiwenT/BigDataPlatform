package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.CourseChapter;

public interface CourseChapterService {

	/**
	 * 增加章
	 */
	public int insertChapter(CourseChapter courseChapter);
	/**
	 * 删除章
	 */
	int deleteByChapterId(String ChapterId, String courseId);
	/**
	 * 根据课程ID查找章
	 */
	public List<CourseChapter> selectByCourseID(String CourseId);
	
	public CourseChapter selectById(String chapterId, String courseId);
	/**
	 * 修改章
	 */
	public int update(CourseChapter courseChapter);
	
}
