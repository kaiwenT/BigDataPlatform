package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.ExperimentMapper;
import com.hust.bigdataplatform.dao.mapper.ExperimentScoreMapper;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentExample;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.ExperimentScoreExample;
import com.hust.bigdataplatform.model.ExperimentScoreExample.Criteria;

/**
 * 学生实验成绩表增删改查操作
 * @author tankai
 *
 */
@Repository
public class ExperimentScoreDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Experiment.class);
	@Autowired
	private ExperimentScoreMapper experimentScoreMapper;
	
	/**
	 * 在实验分数表中添加记录 
	 * @param experimentScore
	 * @return
	 */	 
	public int insert(ExperimentScore experimentScore)
	{
		return experimentScoreMapper.insert(experimentScore);
	}
	public int insertSelective(ExperimentScore experimentScore)
	{
		return experimentScoreMapper.insertSelective(experimentScore);
	}
	
	/**
	 * 根据学号和experimentId，删除某条记录
	 * @param experimentId
	 * @param studentId
	 * @return
	 */	
	public int deleteById(String experimentId, String studentId)
	{
		return experimentScoreMapper.deleteByPrimaryKey(studentId, experimentId);
	}
	
	/**
	 * 查找某个学生某个实验的分数记录
	 * @param studentId 学号
	 * @param experimentId 实验号
	 * @return
	 */
	public ExperimentScore selectExpScoreByStuId(String studentId, String experimentId)
	{	
		return experimentScoreMapper.selectByPrimaryKey(studentId, experimentId);
	}
	
	/**
	 * 查找某个学生所有实验的分数
	 * @param studentId 学号
	 * @return
	 */
	public List<ExperimentScore> selectAllExpScoreByStuId(String studentId)
	{		
		ExperimentScoreExample example = new ExperimentScoreExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return experimentScoreMapper.selectByExample(example);
	}
	
	/**
	 * 根据学号，experimentId更新记录
	 * @param expScore
	 * @return
	 */	 
	public int updateByPrimaryKey(ExperimentScore expScore)
	{
		return experimentScoreMapper.updateByPrimaryKey(expScore);
	}

	public int updateByPrimaryKeySelective(ExperimentScore expScore)
	{
		return experimentScoreMapper.updateByPrimaryKeySelective(expScore);
	}
}
