package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExperimentDao;
import com.hust.bigdataplatform.dao.ExperimentScoreDao;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.ExperimentScoreExample;
import com.hust.bigdataplatform.model.ExperimentScoreExample.Criteria;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.ExperimentService;
@Service
public class ExperimentScoreServiceImpl implements ExperimentScoreService {

	@Autowired
	private ExperimentScoreDao experimentScoreDao;

	@Override
	public ExperimentScore selectExpScoreByStu(String studentId, String experimentId) {
		if(studentId == null || experimentId == null){
			return null;
		}
		return experimentScoreDao.selectExpScoreByStuId(studentId, experimentId);
	}

	@Override
	public List<ExperimentScore> selectAllExpScoreByStuId(String studentId) {
		if(studentId == null || "".equals(studentId)){
			return null;
		}
		return experimentScoreDao.selectAllExpScoreByStuId(studentId);
	}

	@Override
	public int insert(ExperimentScore experimentScore) {
		if(experimentScore == null){
			return 0;
		}
		return experimentScoreDao.insert(experimentScore);
	}

	@Override
	public int deleteById(String experimentId, String studentId) {
		if(studentId == null || experimentId == null){
			return 0;
		}
		return experimentScoreDao.deleteById(experimentId, studentId);
	}

	@Override
	public int update(ExperimentScore expScore) {
		if(expScore == null){
			return 0;
		}
		return experimentScoreDao.updateByPrimaryKeySelective(expScore);
	}
}