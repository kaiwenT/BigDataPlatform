package com.hust.bigdataplatform.controller;

import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/teacherCourse")
public class NNCourse {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/SetCourseIntroduce")
	@ResponseBody
	public Object SetCourseIntroduce(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="courseIntroduce") String courseIntroduce)
	{
		Course course = courseService.findCourseById(courseId);
		course.setCourseIntroduce(courseIntroduce);
		int status = courseService.updateCourse(course);
		if (status==0) {
			return ResultUtil.errorWithMsg("课程介绍填写失败！");
		}
		return ResultUtil.success("课程介绍填写成功！");
	}
	
	@RequestMapping("/SetCourseOutline")
	@ResponseBody
	public Object SetCourseOutline(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="courseOutline") String Outline)
	{
		Course course = courseService.findCourseById(courseId);
		course.setCourseOutline(Outline);
		int status = courseService.updateCourse(course);
		if (status==0) {
			return ResultUtil.errorWithMsg("课程大纲填写失败！");
		}
		return ResultUtil.success("课程大纲填写成功！");
	}
	
	@RequestMapping("/AddChatper")
	@ResponseBody
	public Object AddChatper(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="courseName")String courseName)
	{
		CourseChapter courseChapter = new CourseChapter();
		return courseService;
		
	}

}
