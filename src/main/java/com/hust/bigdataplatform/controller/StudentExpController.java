package com.hust.bigdataplatform.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.service.ExpEvaluateService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.util.ResultUtil;
import com.hust.bigdataplatform.util.fileUtil;
   
@Controller
@RequestMapping("/studentexp")
public class StudentExpController {

	@Autowired
	private ExperimentService experimentService;
	@Autowired
	private ExpEvaluateService expEvaluateService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private StudentCourseService studentCourseService;
	
	@RequestMapping("/getMutualEvalFiles")
	@ResponseBody
	public Object getMutualEvalFiles(@RequestParam(value="experimentId", required=true)String experimentId,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("实验id为空");
		}
		String stuId = (String) sessionService.getObject("studentId", request);
		if(stuId == null || "".equals(stuId)){
			return ResultUtil.errorWithMsg("登录信息失效，请重新登录");
		}
		Experiment e = experimentService.findExperimentByExpId(experimentId).get(0);
		String groupId = studentCourseService.findStudentCourseByStuId(stuId, e.getCourseId()).getStudentGroupid();
		List<String> groupList = studentCourseService.findGroupIdList(e.getCourseId());
		String egroupid = groupList.get((groupList.indexOf(groupId) + 1) % groupList.size());
		List<String> ids = fileUtil.getFileName(Constant.DIRECTORY.REPORT_SUBMIT+experimentId,"pdf");
		if(ids == null || ids.isEmpty()){
			return ResultUtil.errorWithMsg("暂无实验报告");
		}		
		List<String> fids = new ArrayList<>();
		for(String id : ids){
			if(stuId.equals(id)){
				continue;
			}
			String gid = studentCourseService.findStudentCourseByStuId(id, e.getCourseId()).getStudentGroupid();
			if(gid != null && gid.equals(egroupid) && expEvaluateService.selectByPrimaryKey(experimentId, id, stuId) == null){
				fids.add(id);
			}
		}
		
		return ResultUtil.success(fids);
	}
	
	@RequestMapping("/setEvalScore")
	@ResponseBody
	public Object setEvalScore(@RequestParam(value="experimentId", required=true)String experimentId,
			@RequestParam(value="studentId", required=true)String studentId,
			@RequestParam(value="score", required=true)int score,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("实验id为空");
		}
		String evaluator = (String) sessionService.getObject("studentId", request);
		if(studentId == null || "".equals(studentId)){
			return ResultUtil.errorWithMsg("实验报告id为空");
		}
		if(evaluator == null || "".equals(evaluator)){
			return ResultUtil.errorWithMsg("登录信息为空");
		}
		int f;
		if(expEvaluateService.selectByPrimaryKey(experimentId, studentId, evaluator) == null){
			f = expEvaluateService.insert(experimentId, studentId, evaluator, score);
		}else{
			f = expEvaluateService.update(experimentId, studentId, evaluator, score);
		}
		if(f == 0){
			return ResultUtil.errorWithMsg("更新互评分数失败");
		}
		return ResultUtil.success("更新互评分数成功");
	}
}
