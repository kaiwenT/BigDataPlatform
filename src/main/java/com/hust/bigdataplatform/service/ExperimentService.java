package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Experiment;

public interface ExperimentService {

	/**
	 * 查找课程下所有的实验
	 * @param courseId
	 * @return
	 */
	public List<Experiment> findExperimentByCourseId(String courseId);
	/**
	 * 根据实验id查找实验
	 * @param experimentId
	 * @return
	 */
	public List<Experiment> findExperimentByExpId(String experimentId);
	/**
	 * 增加实验
	 * @param exp
	 * @return
	 */
	public int addExperiment(Experiment exp);
	/**
	 * 更新实验
	 * @param exp
	 * @return
	 */
	public int updateExperiment(Experiment exp);
	/**
	 * 删除实验
	 * @param experimentId
	 * @param courseId
	 * @return
	 */
	public int deleteExperiment(String experimentId, String courseId);
}
