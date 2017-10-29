package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.dao.CourseChapterDao;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.FileService;
import com.hust.bigdataplatform.util.fileUtil;
@Service 
public class CourseChapterServiceImpl implements CourseChapterService {
	@Autowired
	private CourseChapterDao courseChapterDao;
	
	@Autowired
	private ChapterSectionService chapterSectionService;
	@Autowired
	private FileService fileservice;

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

	@Override
	public CourseChapter selectByChapterId(String chapterId) {
		
		return courseChapterDao.selectByChapterId(chapterId);
	}

	@Override
	public void deleteSectionfile(String sectionId) {
		ChapterSection chapterSection = chapterSectionService.selectBySectionId(sectionId);
	    String road = Constant.DIRECTORY.COURSEWARE+chapterSection.getChapterId()+"/"+chapterSection.getSectionid();
	    //删除file中的记录
	    List<String> list = fileUtil.getFileName(road);
	    if (list!= null) {
	    	for (String string : list) {
				fileservice.delete(string.substring(0, string.indexOf(".")));
			}
			//从磁盘中删除文件
			fileUtil.deleteSection(road);
		}
		String road1 = Constant.DIRECTORY.COURSE_VIDEO+chapterSection.getChapterId()+"/"+chapterSection.getSectionid();
		 //删除file中的记录
	    List<String> list1 = fileUtil.getFileName(road1);
	    if (list1!= null) {
	    	 for (String string : list1) {
	 			fileservice.delete(string.substring(0, string.indexOf(".")));
	 		}
	 		//从磁盘中删除文件
	 		fileUtil.deleteSection(road1);
		}
	}
}
