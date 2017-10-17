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

}
