package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.SectionFileMapper;
import com.hust.bigdataplatform.model.SectionFile;

@Repository
public class SectionFileDao {

	private static final Logger logger=LoggerFactory.getLogger(SectionFileDao.class);
	@Autowired
	private SectionFileMapper sectionFileMapper;
	/**
	 * 增加
	 * @param sectionFile
	 * @return
	 */
	public int insert(SectionFile sectionFile)
	{
		return sectionFileMapper.insertSelective(sectionFile);
	}
	/**
	 * 根据主键删除
	 * @param sectionid
	 * @param fileid
	 * @return
	 */
	public int delete(String sectionid, String fileid)
	{
		return sectionFileMapper.deleteByPrimaryKey(sectionid, fileid);
	}
	
	
}
