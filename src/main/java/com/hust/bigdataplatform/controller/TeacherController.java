package com.hust.bigdataplatform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.TeacherService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SessionService sessionService;
	
	/**
	 * 登录
	 * @param teacherId
	 * @param teacherPwd
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/Teacherlogin")
	public Object TeacherLogin(@RequestParam(value="teacherId", required=true) String teacherId, 
			@RequestParam(value="teacherPwd", required = true) String teacherPwd, HttpServletRequest request)
	{
		int status = teacherService.TeacherLogin(teacherId, teacherPwd);
		if (status == 2) {
			sessionService.setObject("teacherId", teacherId, request);
			return ResultUtil.success("登录成功！");
		}
		else if (status == 0) {
			return ResultUtil.errorWithMsg("帐号错误！");
		}
		else {
			return ResultUtil.errorWithMsg("密码错误");
		}
	}
	/**
	 * 查询当前登录的教师信息
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/CurrentTeacher")
	public Object CurrentTeacher(HttpServletRequest request)
	{
		String teacherid = (String) sessionService.getObject("teacherId", request);
		if (teacherid.equals(null)) {
			return ResultUtil.errorWithMsg("登录超时，请重新登录！");
		}
		//根据id查找教师信息
		Teacher teacher = teacherService.findById(teacherid);
		if (teacher.equals(null)) {
			return ResultUtil.errorWithMsg("查询教师信息失败，查询结果为空！");
		}
		else {
			return ResultUtil.success(teacher);
		}
	}

}
