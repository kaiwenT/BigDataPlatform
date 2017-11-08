package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.ExpEvaluate;

public interface ExpEvaluateService {

	/**
	 * 插入一条学生实验报告互评记录
	 * @param experimentId
	 * @param studentId
	 * @param evaluator
	 * @param score
	 * @return
	 */
	public int insert(String experimentId,String studentId,String evaluator,int score);
	/**
	 * 删除一条学生实验报告互评记录
	 * @param experimentId
	 * @param studentId
	 * @param evaluator
	 * @return
	 */
	public int delete(String experimentId,String studentId,String evaluator);
	/**
	 * 更新
	 * @param experimentId
	 * @param studentId
	 * @param evaluator
	 * @param score
	 * @return
	 */
	public int update(String experimentId,String studentId,String evaluator,int score);
	/**
	 * 查询学生某个实验的所有评分
	 * @param expId
	 * @param studentId 被评价者
	 * @return
	 */
	public List<ExpEvaluate> selectByStudentId(String expId, String studentId);
	/**
	 * 查询学生某个实验对别人的所有评分
	 * @param expId
	 * @param evaluator 评价人
	 * @return
	 */
	public List<ExpEvaluate> selectByEvaluator(String expId, String evaluator);
	/**
	 * 查询实验A ，学生x 对学生y 的评分
	 * @param expId A.id
	 * @param studentId y.id 
	 * @param evaluator x.id
	 * @return
	 */
	public ExpEvaluate selectByPrimaryKey(String expId, String studentId, String evaluator);
	
	
}
