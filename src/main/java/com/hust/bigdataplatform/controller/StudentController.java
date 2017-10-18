package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SessionService sessionService;
	
	@ResponseBody
	@RequestMapping("/login")
	public Object login(@RequestParam(value = "studentId", required = true) String studentId,
			@RequestParam(value = "password", required = true) String password,
			HttpServletRequest request) {
		
		
		int islogin = studentService.login(studentId, password);
		if (islogin < 0) {
			return ResultUtil.errorWithMsg("登录失败，用户名或者密码错误！");
		}
		sessionService.setObject("studentId", studentId, request);
		return ResultUtil.success("登录成功");
	}
	@ResponseBody
	@RequestMapping("/logout")
	public Object logout(HttpServletRequest request) {		
		String studentId = (String) sessionService.getObject("studentId", request);		
		if (studentId != null) {
			sessionService.remove("studentId", request);
		}		
		return ResultUtil.success("登录成功");
	}
	/**
	 * 查询当前登录学生信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPersonalInfo")
	public Object getPersonalInfo(HttpServletRequest request) {
		//@RequestParam(value = "studentId", required = true) String studentId, 
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		Student student = studentService.selectStudentById(studentId);
		if (null == student) {
			return ResultUtil.errorWithMsg("查询学生信息失败，查询为空");
		}
		return ResultUtil.success(student);
	}
	
	/**
	 * 查询所有的学生
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAllStudents")
	public Object selectAllStudents(@RequestParam(value = "start", required = true) int start,
			@RequestParam(value = "limit", required = true) int limit, HttpServletRequest request) {
		List<Student> students = studentService.selectAllStudents(start,limit);
		if (null == students || students.size() == 0) {
			return ResultUtil.errorWithMsg("查询所有学生失败，查询为空");
		}
		return ResultUtil.success(students);
	}
	
}
