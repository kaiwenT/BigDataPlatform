package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.dao.ChapterSectionDao;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.FileService;
import com.hust.bigdataplatform.util.fileUtil;
@Service
public class ChapterSectionServiceImpl implements ChapterSectionService {
	@Autowired
	private ChapterSectionDao chapterSectionDao;

	/**
	 * 插入，若返回2则提示节的名字不能为空，1为成功，0为失败
	 */
	@Override
	public int insertSection(ChapterSection chapterSection) {
		if (chapterSection.getSectionname()==null) {
			return 2 ;
		}
		return chapterSectionDao.insert(chapterSection);
	}
	/**
	 * 删除节
	 */
	@Override
	public int deleteSection(String chapterSectionId) {
		if (chapterSectionId==null) {
			return 0;
		}
		return chapterSectionDao.deleteById(chapterSectionId);
	}

	@Override
	public List<ChapterSection> selectByChapterId(String chapterId) {
		if (chapterId.equals(null)) {
			return null;
		}
		return chapterSectionDao.selectByChapterId(chapterId);
	}

	@Override
	public int Update(ChapterSection chapterSection) {
		if (chapterSection.getSectionname()==null) {
			return 2;
		}
		return chapterSectionDao.update(chapterSection);
	}
	@Override
	public ChapterSection selectBySectionId(String sectionId) {
		if (sectionId.equals(null)) {
			return null;
		}
		return chapterSectionDao.selectById(sectionId);
	}

}
