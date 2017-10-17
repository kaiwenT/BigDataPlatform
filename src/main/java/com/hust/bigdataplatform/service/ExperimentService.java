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
}
