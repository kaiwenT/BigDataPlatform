package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.TeacherCourseService;
import com.hust.bigdataplatform.service.TeacherService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/teacherCourse")
public class TeacherCourseController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private SessionService sessionService;	
	
	@ResponseBody
	@RequestMapping("/getCourseByTeacher")
	public Object getCourseByTeacher(HttpServletRequest request)
	{
		String teacherId = (String) sessionService.getObject("teacherId", request);
		if (teacherId==null) {
			return ResultUtil.errorWithMsg("登录超时，请重新登录！");
		}
		//根据teacherId查找课程ID
		List<Course> courses = teacherCourseService.getCourseByTeacherid(teacherId);
		if (courses.equals(null)) {
			return ResultUtil.errorWithMsg("您当前没有任何课程");
		}
		return ResultUtil.success(courses);
		
	}
}
