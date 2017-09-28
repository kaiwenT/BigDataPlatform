package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.ExpEvaluateMapper;
import com.hust.bigdataplatform.dao.mapper.ExperimentMapper;
import com.hust.bigdataplatform.model.ExpEvaluate;
import com.hust.bigdataplatform.model.ExpEvaluateExample;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentExample;
import com.hust.bigdataplatform.model.ExpEvaluateExample.Criteria;

/**
 *  实验评分Dao，包括exp_evaluate表的增删改查
 * @author tankai
 *
 */
@Repository
public class ExpEvaluateDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Experiment.class);
	@Autowired
	private ExpEvaluateMapper expEvaluateMapper;
	
	/**
	 * 在实验评分表中添加记录
	 * @param experiment
	 * @return
	 */
	public int insert(ExpEvaluate record)
	{
		return expEvaluateMapper.insert(record);
	}
	public int insertSelective(ExpEvaluate record)
	{
		return expEvaluateMapper.insertSelective(record);
	}
	/**
	 * 删除某条记录
	 * @param experimentId 实验号
	 * @param studentId 被评分人学号
	 * @param evaluator 评分人学号
	 * @return
	 */
	public int deleteById(String experimentId, String studentId, String evaluator)
	{
		return expEvaluateMapper.deleteByPrimaryKey(experimentId, studentId, evaluator);
	}
	
	/**
	 * 查找某个学生所有的被评分记录
	 * @param expId 实验号
	 * @param studentId 被评分的学生学号
	 * @return
	 */
	public List<ExpEvaluate> selectByStudentId(String expId, String studentId)
	{
		ExpEvaluateExample example = new ExpEvaluateExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(expId);
		criteria.andStudentIdEqualTo(studentId);
		return expEvaluateMapper.selectByExample(example);
	}
	
	/**
	 * 查找某个学生作为评分者所有的评分记录
	 * @param expId 实验id
	 * @param evaluator 评分学生id
	 * @return
	 */
	public List<ExpEvaluate> selectByEvaluator(String expId, String evaluator)
	{
		ExpEvaluateExample example = new ExpEvaluateExample();
		Criteria criteria = example.createCriteria();
		criteria.andExperimentIdEqualTo(expId);
		criteria.andEvaluatorEqualTo(evaluator);
		return expEvaluateMapper.selectByExample(example);
	}
	
	
	/**
	 * 更新记录
	 * @param e
	 * @return
	 */
	public int updateById(ExpEvaluate e)
	{
		return expEvaluateMapper.updateByPrimaryKeySelective(e);
	}

}
