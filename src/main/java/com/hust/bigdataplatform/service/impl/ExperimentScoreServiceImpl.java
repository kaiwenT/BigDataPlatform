package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.ExperimentDao;
import com.hust.bigdataplatform.dao.ExperimentScoreDao;
import com.hust.bigdataplatform.model.CourseScale;
import com.hust.bigdataplatform.model.ExpEvaluate;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.params.ExpScore;
import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;
import com.hust.bigdataplatform.service.ExpEvaluateService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.CourseScaleService;
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
	@Autowired
	private ExpEvaluateService expEvaluateService;
	@Autowired
	private CourseScaleService CourseScaleService;
	
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
		ShowExpScore(courseId);
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
			if (!experiments.isEmpty()) {
				for (Experiment experiment : experiments) {
					updateReportScore(courseId,  experiment.getExperimentId(), student.getStudentId());
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
		}
		return experimentScoreQueries;
	}
	/**
	 * 添加实验成功后，初始化experimentScore表；
	 * 根据courseId找到List<students>，再根据expId和studentid在
	 * experimentScore中寻找，若有记录则跳过，若没有记录则添加
	 */
	@Override
	public int AddExperimentScore(String courseId, String expId ) {
		//根据courseid获取studentID
		List<Student> students = studentCourseService.findBycourseId(courseId);
		for (Student student : students) {
			ExperimentScore eScore = new ExperimentScore();
			if (experimentScoreDao.selectExpScoreByStuId(student.getStudentId(), expId)==null) 
			{//插入记录
				eScore.setExperimentId(expId);
				eScore.setStudentId(student.getStudentId());
				int i = 0;
				eScore.setExpFinalscore(i);
				eScore.setReportscore(i);
				eScore.setResultsscore(i);
				int s = experimentScoreDao.insert(eScore);
				if (s==0) {
					return 0;
				}
			}
		}
		return 1;
	}
	/**
	 * 添加学生名单成功后，根据courseID 找到list<exp>, 再根据expId和studentid在
	 * experimentScore中寻找，若有记录则跳过，若没有记录则添加
	 */
	@Override
	public int AddExperimentScore(String courseId, List<Student> students) {
		if (students.size()==0||students==null) {
			return 0;
		}
		List<Experiment> experiments = experimentService.findExperimentByCourseId(courseId);
		if (experiments.size()==0 || experiments==null) {
			return 0;
		}
		for (Experiment experiment : experiments) {
			String expid = experiment.getExperimentId();
			if (expid!=null&&expid!="") {
				for (Student student : students) {
					String stuId = student.getStudentId();
					if (stuId!=null&&stuId!="") {
						ExperimentScore eScore = new ExperimentScore();
						if (experimentScoreDao.selectExpScoreByStuId(stuId, expid)==null) {
							eScore.setExperimentId(expid);
							eScore.setStudentId(stuId);
							int i=0;
							eScore.setExpFinalscore(i);
							eScore.setReportscore(i);
							eScore.setResultsscore(i);
							int s = experimentScoreDao.insert(eScore);
							if (s==0) {
								return 0;
							}
						}
					}
				}
				
			}
		}
		return 1;
	}
	//更新学生的报告总成绩
	@Override
	public int updateReportScore(String courseId, String expId, String studentId) {
		if (courseId==" " || courseId == null|| expId==" " || expId == null || studentId==" " || studentId == null ) {
			return 0;
			
		}
		else {
			List<ExpEvaluate> evaluates = expEvaluateService.selectByStudentId(expId, studentId);
			int expscore = 0;
			if (evaluates.size()>0) {
				for (ExpEvaluate expEvaluate : evaluates) {
					expscore +=expEvaluate.getEvaluatesore();
				}
				expscore = expscore/evaluates.size();
			}
			CourseScale courseScale = CourseScaleService.findByCourseId(courseId);
			ExperimentScore exp= experimentScoreDao.selectExpScoreByStuId(studentId, expId);
			int finalsorce = (int) (expscore*courseScale.getExpReportRate()+(1-courseScale.getExpReportRate())*exp.getResultsscore());
			exp.setExpFinalscore(finalsorce);
			exp.setReportscore(expscore);
			int s = experimentScoreDao.updateByPrimaryKey(exp);
			if (s==0) {
				return 0;
			}
			else {
				return 1;
			}
		}
		
	}
	
}