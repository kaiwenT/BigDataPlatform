package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentFile;
import com.hust.bigdataplatform.model.File;

public interface ExperimentFileService {

	/**
	 * 查找某个实验指定类型文件
	 * @param experimentId
	 * @param type 文件类型，为空查找所有文件
	 * @return
	 */
	public List<File> findFileByExperiment(String experimentId, String type);
	/**
	 * 查找某个文件所属实验
	 * @param fileId
	 * @return
	 */
	public Experiment findExperimentByFile(String fileId);
	/**
	 * 增加实验文件记录
	 * @param experimentId
	 * @param file
	 * @return
	 */
	public int add(String experimentId, File file);
	/**
	 * 更新实验文件
	 * @param experimentFile
	 * @return
	 */
	public int update(ExperimentFile experimentFile);
	/**
	 * 删除记录
	 * @param experimentId
	 * @return
	 */
	public int deleteByExperiment(String experimentId);
	
	/**
	 * 删除记录
	 * @param fileId
	 * @return
	 */
	public int deleteByFile(String fileId);
}
