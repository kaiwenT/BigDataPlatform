package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.File;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.service.ExperimentFileService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {

	@Autowired
	private ExperimentService experimentService;
	@Autowired
	private ExperimentFileService experimentFileService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SessionService sessionService;
	/**
	 * 获取某个课程的所有的实验
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentsByCourse")
	@ResponseBody
	public Object getExperimentsByCourse(@RequestParam(value="courseId", required=true)String courseId,
			HttpServletRequest request){
		if(courseId == null || "".equals(courseId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		List<Experiment> exps = experimentService.findExperimentByCourseId(courseId);
		return ResultUtil.success(exps);
	}
	
	@RequestMapping("/getExperimentById")
	@ResponseBody
	public Object getExperimentById(@RequestParam(value="experimentId", required=true)String experimentId,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("实验id为空");
		}
		List<Experiment> exps = experimentService.findExperimentByExpId(experimentId);
		if(exps == null || exps.isEmpty()){
			return ResultUtil.errorWithMsg("实验查询失败");
		}
		return ResultUtil.success(exps.get(0));
	}
	/**
	 * 获取某个实验所有文件，包括video,pdf
	 * @param experimentId
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFilesByExperiment")
	@ResponseBody
	public Object getFilesByExperiment(@RequestParam(value="experimentId", required=true)String experimentId,
			@RequestParam(value="type", required=false)String type,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		List<File> files = experimentFileService.findFileByExperiment(experimentId, type);
		return ResultUtil.success(files);
	}
	/**
	 * 获取某个文件所属的实验
	 * @param fileId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentByFile")
	@ResponseBody
	public Object getExperimentByFile(@RequestParam(value="fileId", required=true)String fileId,			
			HttpServletRequest request){
		if(fileId == null || "".equals(fileId)){
			return ResultUtil.errorWithMsg("文件id为空");
		}
		Experiment e = experimentFileService.findExperimentByFile(fileId);
		if(e == null){
			return ResultUtil.errorWithMsg("文件对应实验为空");
		}
		return ResultUtil.success(e);
	}
	/**
	 * 获取当前登录学生某个实验的成绩
	 * @param experimentId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentScore")
	@ResponseBody
	public Object getExperimentScore(@RequestParam(value="experimentId", required=true)String experimentId,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		String stuId = (String) sessionService.getObject("studentId", request);
		if(stuId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		ExperimentScore escore = experimentScoreService.selectExpScoreByStu(stuId, experimentId);
		if(escore == null){
			return ResultUtil.success(0);
		}
		return ResultUtil.success(escore.getExpFinalscore());
	}
}
