package com.hust.bigdataplatform.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.params.ExpScore;
import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentScoreService;
import com.hust.bigdataplatform.service.StudentTaskService;
import com.hust.bigdataplatform.util.ExcelWrite;
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
	@Autowired
	private StudentCourseService studentCourseService;
	
	private static final Logger logger = LoggerFactory.getLogger(StudentScoreController.class);
	
	//发布成绩，开始计算总成绩
	@RequestMapping("/CalculateScore")
	@ResponseBody
	public Object CalculateScore(@RequestParam(value = "courseId", required = true) String courseId) {
	
		if (courseId==null||courseId.equals("")) {
			return ResultUtil.errorWithMsg("登录超时，查询成绩失败");
		}
		List<Student> students = studentCourseService.findBycourseId(courseId);
		for (Student student : students) {
			int status = studentScoreService.UpdateByStuIdAndCourseId(student.getStudentId(), courseId);
			if (status==0) {
				return ResultUtil.errorWithMsg("发布成绩有误");
			}
		}
		return ResultUtil.success("发布成绩成功！");
 	}
	
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
		List<Student> students = studentCourseService.findBycourseId(courseId);
		for (Student student : students) {
			int status = studentScoreService.UpdateByStuIdAndCourseId(student.getStudentId(), courseId);
			if (status==0) {
				return ResultUtil.errorWithMsg("计算总成绩有误");
			}
		}
		List<Map<String, String>> result=studentScoreService.ShowStudentFinalScore(courseId);
		if (result==null) {
			return ResultUtil.errorWithMsg("查询成绩失败");
		}
		return ResultUtil.success(result);
 	}
	
	@RequestMapping("/DownloadScore")
	@ResponseBody
	public void DownloadScore(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "courseId", required = true) String courseId) throws IOException {
		
		List<List<String>> result = studentScoreService.GetAllScore(courseId);
		OutputStream outputStream = null;
	    try {
            if (result == null) {
                response.sendError(404, "导出错误");
                return;
            }
            String filename = "学生成绩表.xls";
            outputStream = response.getOutputStream();
            response.setCharacterEncoding("utf-8");
            response.setContentType("multipart/form-data");
            response.setHeader("Content-Disposition", "attachment;fileName="+new String(filename.getBytes("gbk"),"iso-8859-1"));
            HSSFWorkbook workbook = ExcelWrite.exportToExcel(result);
            workbook.write(outputStream);
        } catch (Exception e) {
            logger.info("excel 导出失败\t" + e.toString());
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                logger.info("导出excel时，关闭outputstream失败");
            }
        }
	}
}
