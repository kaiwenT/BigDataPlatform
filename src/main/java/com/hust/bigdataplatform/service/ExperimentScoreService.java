package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;

public interface ExperimentScoreService {
	/**
	 * 查询学生某个实验的成绩
	 * @param studentId 学号
	 * @param experimentId 实验id
	 * @return
	 */
	public ExperimentScore selectExpScoreByStu(String studentId, String experimentId);
	/**
	 * 查找某个学生所有实验的分数
	 * @param studentId 学号
	 * @return
	 */
	public List<ExperimentScore> selectAllExpScoreByStuId(String studentId);
	/**
	 * 在实验分数表中添加记录 
	 * @param experimentScore
	 * @return
	 */	
	public int insert(ExperimentScore experimentScore);
	/**
	 * 根据学号和experimentId，删除某条记录
	 * @param experimentId
	 * @param studentId
	 * @return
	 */	
	public int deleteById(String experimentId, String studentId);
	/**
	 * 根据学号，experimentId更新记录
	 * @param expScore
	 * @return
	 */	
	public int update(ExperimentScore expScore);
	/**
	 * 查找某个学生某个课程所有实验的平均分
	 * @param studentId
	 * @param courseId
	 * @return
	 */
	public int findExpAvgScore(String studentId, String courseId);
	
	public List<ExperimentScoreQuery> ShowExpScore( String courseId);
	
	public int AddExperimentScore(String courseId, List<Student> students);
	
	public int AddExperimentScore(String courseId, String expId );
	
	public int updateReportScore(String courseId, String expId, String studentId);
	
}
