package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExperimentDao;
import com.hust.bigdataplatform.dao.ExperimentScoreDao;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.ExperimentScoreExample;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.ExperimentScoreExample.Criteria;
import com.hust.bigdataplatform.model.params.ExpScore;
import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.service.StudentCourseService;
@Service
public class ExperimentScoreServiceImpl implements ExperimentScoreService {

	@Autowired
	private ExperimentScoreDao experimentScoreDao;
	@Autowired
	private ExperimentDao experimentDao;
	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private ExperimentService experimentService;
	
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

	@Override
	public int findExpAvgScore(String studentId, String courseId) {
		if(studentId == null || courseId == null){
			return 0;
		}
		List<Experiment> exps = experimentDao.selectByCourseId(courseId);
		if(exps == null || exps.isEmpty()){
			return 0;
		}
		int score = 0;
		for(Experiment e : exps){
			ExperimentScore esc = experimentScoreDao.selectExpScoreByStuId(studentId, e.getExperimentId());
			if(esc != null){
				score += esc.getExpFinalscore();
			}			
		}
		return score / exps.size();
	}

	/**
	 * 显示实验成绩：实验一 （报告、数据、总成绩）、实验二 （报告、数据、总成绩）....实验总成绩
	 */
	@Override
	public List<ExperimentScoreQuery> ShowExpScore(String courseId) {
		// TODO Auto-generated method stub
		List<Student> students = studentCourseService.findBycourseId(courseId);
		List<ExperimentScoreQuery> experimentScoreQueries = new ArrayList<ExperimentScoreQuery>();
		for (Student student : students) {
			ExperimentScoreQuery eQuery = new ExperimentScoreQuery();
			eQuery.setStudentId(student.getStudentId());
			eQuery.setStudentName(student.getStudentName());
			List<ExpScore> eList = new ArrayList<ExpScore>();
			List<Experiment> experiments = experimentService.findExperimentByCourseId(courseId);
			for (Experiment experiment : experiments) {
				ExperimentScore experimentScore = experimentScoreDao.selectExpScoreByStuId(student.getStudentId(), experiment.getExperimentId());
				if (experimentScore==null) {
					continue;
				}
				ExpScore expScore = new ExpScore();
				expScore.setExpName(experiment.getExperimentName());
				expScore.setReportScore(String.valueOf(experimentScore.getReportscore()));
				expScore.setResultsScore(String.valueOf(experimentScore.getResultsscore()));
				expScore.setFinalScore(String.valueOf(experimentScore.getExpFinalscore()));
				eList.add(expScore);
			}
			eQuery.setExplist(eList);
			//算出最终的成绩
			int score = 0;
			for(ExpScore expScore:eList)
			{
				score = score+Integer.parseInt(expScore.getFinalScore());;
			}
			score = score/eList.size();
			eQuery.setFinalScore(String.valueOf(score));
			experimentScoreQueries.add(eQuery);
		}
		return experimentScoreQueries;
	}
}