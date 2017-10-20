package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseChapterDao;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.CourseChapterService;
@Service 
public class CourseChapterServiceImpl implements CourseChapterService {
	@Autowired
	private CourseChapterDao courseChapterDao;

	/**
	 * 插入， 返回2提示章的名字为空 
	 */
	@Override
	public int insertChapter(CourseChapter courseChapter) {
		if (courseChapter.getChapterName()==null) {
			return 2;
		}
		return courseChapterDao.insert(courseChapter);
	}
	
	@Override
	public int deleteByChapterId(String chapterId, String courseId) {
		if (chapterId.equals(null) || courseId.equals(null)) {
			return 0;
		}
		return courseChapterDao.deleteById(chapterId, courseId);
	}

	@Override
	public List<CourseChapter> selectByCourseID(String CourseId) {
		if (CourseId.equals(null)) {
			return null;
		}
		return courseChapterDao.selectByCourseId(CourseId);
	}

	@Override
	public int update(CourseChapter courseChapter) {
		if (courseChapter.getChapterName()==null) {
			return 2;
		}
		return courseChapterDao.update(courseChapter);
	}

	@Override
	public CourseChapter selectById(String chapterId, String courseId) {
		if (chapterId.equals(null) || courseId.equals(null)) {
			return null;
		}
		return courseChapterDao.selectById(courseId, chapterId);
	}

}
