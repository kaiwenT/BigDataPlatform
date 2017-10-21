package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/experiment")
public class ExperimentController {

	@Autowired
	private ExperimentService experimentService;
	
	@Autowired
	private CourseService courseService;
	
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
}
