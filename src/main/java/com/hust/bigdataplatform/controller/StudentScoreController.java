package com.hust.bigdataplatform.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.StudentScoreService;
import com.hust.bigdataplatform.service.StudentTaskService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/StudentScore")
public class StudentScoreController {
	
	@Autowired
	private StudentTaskService studentTaskService;
	@Autowired
	private StudentScoreService studentScoreService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
	
	//显示平时成绩： 考勤成绩、作业一、作业二.... 平时总成绩
	@RequestMapping("/ShowUsualScore")
	@ResponseBody
	public Object ShowUsualScore(@RequestParam(value = "courseId", required = true) String courseId) {
	
		if (courseId==null||courseId.equals("")) {
			return ResultUtil.errorWithMsg("登录超时，查询成绩失败");
		}
		List<Map<String, String>> result= studentTaskService.ShowUsualScore(courseId);
		if (result==null) {
			return ResultUtil.errorWithMsg("查询成绩失败");
		}
		return ResultUtil.success(result);
 	}
	
	//显示实验成绩：实验一 （报告、数据、总成绩）、实验二 （报告、数据、总成绩）....实验总成绩
	@RequestMapping("/ShowExpScore")
	@ResponseBody
	public Object ShowExpScore(@RequestParam(value = "courseId", required = true) String courseId) {
		if (courseId==null||courseId.equals("")) {
			return ResultUtil.errorWithMsg("登录超时，查询成绩失败");
		}
		List<ExperimentScoreQuery> result = experimentScoreService.ShowExpScore(courseId);
		if (result==null) {
			return ResultUtil.errorWithMsg("查询成绩失败");
		}
		return ResultUtil.success(result);
	}
	
	//显示总成绩：平时总成绩、 实验总成绩、考试成绩、最后成绩
	@RequestMapping("/ShowfinalScore")
	@ResponseBody
	public Object ShowfinalScore(@RequestParam(value = "courseId", required = true) String courseId) {
	
		if (courseId==null||courseId.equals("")) {
			return ResultUtil.errorWithMsg("登录超时，查询成绩失败");
		}
		List<Map<String, String>> result=studentScoreService.ShowStudentFinalScore(courseId);
		if (result==null) {
			return ResultUtil.errorWithMsg("查询成绩失败");
		}
		return ResultUtil.success(result);
 	}
}
