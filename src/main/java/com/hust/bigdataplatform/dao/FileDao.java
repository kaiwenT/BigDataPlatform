package com.hust.bigdataplatform.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.FileMapper;
import com.hust.bigdataplatform.model.File;


@Repository
public class FileDao {
	
	private static final Logger logger = LoggerFactory.getLogger(File.class);
	@Autowired
	private FileMapper fileMapper;
	
	/**
	 * 添加记录
	 * @param file
	 * @return
	 */
	public int insert(File file)
	{
		return fileMapper.insertSelective(file);
	}
	
	/**
	 * 根据fileId，删除某条记录
	 * @param fileId
	 * @return
	 */
	public int deleteById(String fileId)
	{
		return fileMapper.deleteByPrimaryKey(fileId);
	}
	
	/**
	 * 根据ID查找记录
	 * @param fileId
	 * @return
	 */
	public File selectByFileId(String fileId)
	{
		return fileMapper.selectByPrimaryKey(fileId);
	}
	
	/**
	 * 根据fileId更新记录
	 * @param file
	 * @return
	 */
	public int updateById(File file)
	{
		return fileMapper.updateByPrimaryKey(file);
	}

}
