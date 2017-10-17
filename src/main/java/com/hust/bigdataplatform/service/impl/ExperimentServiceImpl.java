package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExperimentDao;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.service.ExperimentService;
@Service
public class ExperimentServiceImpl implements ExperimentService {

	@Autowired
	private ExperimentDao experimentDao;
	
	@Override
	public List<Experiment> findExperimentByCourseId(String courseId) {
		// TODO Auto-generated method stub
		if(courseId == null || "".equals(courseId)){
			return null;
		}
		return experimentDao.selectByCourseId(courseId);
	}

	@Override
	public int addExperiment(Experiment experiment) {
		// TODO Auto-generated method stub
		if(experiment == null){
			return 0;
		}
		return experimentDao.insert(experiment);
	}

	@Override
	public int updateExperiment(Experiment experiment) {
		if(experiment == null){
			return 0;
		}
		return experimentDao.updateById(experiment);
	}

	@Override
	public int deleteExperiment(String experimentId, String courseId) {
		if(experimentId == null || "".equals(experimentId)){
			return 0;
		}
		if(courseId == null || "".equals(courseId)){
			return 0;
		}
		return experimentDao.deleteById(experimentId, courseId);
	}

	@Override
	public List<Experiment> findExperimentByExpId(String experimentId) {
		if(experimentId == null || "".equals(experimentId)){
			return null;
		}
		return experimentDao.selectByExperimentId(experimentId);
	}

}
