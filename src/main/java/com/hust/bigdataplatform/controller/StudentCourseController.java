package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/studentcourse")
public class StudentCourseController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private SessionService sessionService;	
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCouresByStudent")
	public Object getCouresByStudent(HttpServletRequest request) {		
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		List<Course> courses = studentCourseService.selectCoursesByStudent(studentId);
		if (null == courses) {
			return ResultUtil.errorWithMsg("查询学生信息失败，查询为空");
		}
		return ResultUtil.success(courses);
	}
	
	
}
