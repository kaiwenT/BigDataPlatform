package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.ExperimentFileMapper;
import com.hust.bigdataplatform.dao.mapper.ExperimentMapper;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentExample;
import com.hust.bigdataplatform.model.ExperimentFileExample.Criteria;
import com.hust.bigdataplatform.model.File;
import com.hust.bigdataplatform.model.ExperimentFile;
import com.hust.bigdataplatform.model.ExperimentFileExample;

@Repository
public class ExperimentFileDao {
	
	private static final Logger logger = LoggerFactory.getLogger(ExperimentFileDao.class);
	@Autowired
	private ExperimentFileMapper experimentFileMapper;
	
	/**
	 * 增加实验文件记录
	 * @param record
	 * @return
	 */
	public int insert(ExperimentFile record){
		return experimentFileMapper.insert(record);
	}

	/**
	 * 删除实验文件记录
	 * @param fileid
	 * @param experimentId
	 * @return
	 */
	public int delete(String fileid, String experimentId){
		return experimentFileMapper.deleteByPrimaryKey(experimentId, fileid);
	}
	/**
	 * 删除记录
	 * @param example
	 * @return
	 */
	public int delete(ExperimentFileExample example){
		return experimentFileMapper.deleteByExample(example);
	}
	/**
	 * 查找某个文件的记录
	 * @param fileId
	 * @return
	 */
	public ExperimentFile findByFileId(String fileId){
		ExperimentFileExample example = new ExperimentFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andFileIdEqualTo(fileId);
		List<ExperimentFile> list = experimentFileMapper.selectByExample(example);
		if(list == null || list.size() <= 0){
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查找某个实验的所有文件
	 * @param experimentId
	 * @return
	 */
	public List<ExperimentFile> findByExperimentId(String experimentId){
		ExperimentFileExample example = new ExperimentFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(experimentId);
		return experimentFileMapper.selectByExample(example);
	}
	
	/**
	 * 更新实验文件记录
	 * @param record
	 * @return
	 */
	public int update(ExperimentFile record){
		ExperimentFileExample example = new ExperimentFileExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(record.getExperimentId());
		criteria.andFileIdEqualTo(record.getFileId());
		return experimentFileMapper.updateByExample(record, example);
	}
}
