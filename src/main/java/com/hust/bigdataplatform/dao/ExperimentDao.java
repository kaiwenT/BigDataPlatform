package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.ExperimentMapper;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentExample;
import com.hust.bigdataplatform.model.ExperimentExample.Criteria;


@Repository
public class ExperimentDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Experiment.class);
	@Autowired
	private ExperimentMapper experimentMapper;
	
	/**
	 * 在实验表中添加记录
	 * @param experiment
	 * @return
	 */
	public int insert(Experiment experiment)
	{
		return experimentMapper.insert(experiment);
	}
	
	/**
	 * 根据课程号和experimentId，删除某条记录
	 * @param experimentId
	 * @param courseId
	 * @return
	 */
	public int deleteById(String experimentId, String courseId)
	{
		return experimentMapper.deleteByPrimaryKey(experimentId, courseId);
	}
	
	/**
	 * 根据实验ID查找记录
	 * @param experimentId
	 * @return
	 */
	public List<Experiment> selectByExperimentId(String experimentId)
	{
		ExperimentExample example = new ExperimentExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(experimentId);
		List<Experiment> experiments = experimentMapper.selectByExample(example);
		return experiments;
	}
	
	/**
	 * 根据课程ID寻找该课程中的实验记录
	 * @param CourseId
	 * @return
	 */
	public List<Experiment> selectByCourseId(String CourseId)
	{
		ExperimentExample example = new ExperimentExample();
		Criteria criteria = example.createCriteria();
		criteria.andCourseIdEqualTo(CourseId);
		List<Experiment> experiments = experimentMapper.selectByExample(example);
		return experiments;
	}
	
	
	/**
	 * 根据experimentId更新记录
	 * @param experiment
	 * @return
	 */
	public int updateById(Experiment experiment)
	{
		return experimentMapper.updateByPrimaryKey(experiment);
	}

}
