package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExpEvaluateDao;
import com.hust.bigdataplatform.model.ExpEvaluate;
import com.hust.bigdataplatform.service.ExpEvaluateService;
@Service
public class ExpEvaluateServiceImpl implements ExpEvaluateService{

	@Autowired
	private ExpEvaluateDao expEvaluateDao;
	
	@Override
	public int insert(String experimentId, String studentId, String evaluator, int score) {
		ExpEvaluate e = new ExpEvaluate();
		e.setExperimentId(experimentId);
		e.setStudentId(studentId);
		e.setEvaluator(evaluator);
		e.setEvaluatesore(score);
		return expEvaluateDao.insertSelective(e);
	}

	@Override
	public int delete(String experimentId, String studentId, String evaluator) {
		// TODO Auto-generated method stub
		return expEvaluateDao.deleteById(experimentId, studentId, evaluator);
	}

	@Override
	public int update(String experimentId, String studentId, String evaluator, int score) {
		ExpEvaluate e = new ExpEvaluate();
		e.setExperimentId(experimentId);
		e.setStudentId(studentId);
		e.setEvaluator(evaluator);
		e.setEvaluatesore(score);
		return expEvaluateDao.updateById(e);
	}

	@Override
	public List<ExpEvaluate> selectByStudentId(String expId, String studentId) {
		// TODO Auto-generated method stub
		return expEvaluateDao.selectByStudentId(expId, studentId);
	}

	@Override
	public List<ExpEvaluate> selectByEvaluator(String expId, String evaluator) {
		// TODO Auto-generated method stub
		return expEvaluateDao.selectByEvaluator(expId, evaluator);
	}

	@Override
	public ExpEvaluate selectByPrimaryKey(String expId, String studentId, String evaluator) {
		// TODO Auto-generated method stub
		return expEvaluateDao.selectByPrimaryKey(expId, studentId, evaluator);
	}

}
