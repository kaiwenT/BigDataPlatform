package com.hust.bigdataplatform.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.Base64;
import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.util.ResultUtil;
import com.sun.mail.util.BASE64EncoderStream;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@Autowired
	private ChapterSectionService chapterSectionService;

	@Autowired
	private CourseChapterService courseChapterService;

	/**
	 * 根据课程id查询所有章
	 * 
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getChaptersByCourse")
	@ResponseBody
	public Object getChaptersByCourse(@RequestParam(value = "courseId", required = true) String courseId,
			HttpServletRequest request) {
		List<CourseChapter> chapters = courseChapterService.selectByCourseID(courseId);
		return ResultUtil.success(chapters);
	}

	/**
	 * 根据章id查询所有节
	 * 
	 * @param chapterId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getSectionsByChapter")
	@ResponseBody
	public Object getSectionsByChapter(@RequestParam(value = "chapterId", required = true) String chapterId,
			HttpServletRequest request) {
		List<ChapterSection> sections = chapterSectionService.selectByChapterId(chapterId);
		return ResultUtil.success(sections);
	}

	/**
	 * 获取课程
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCourseById")
	@ResponseBody
	public Object getCoursePhoto(@RequestParam(value = "courseId", required = true) String courseId,
			HttpServletRequest request) {
		if(courseId == null || "".equals(courseId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		Course course = courseService.findCourseById(courseId);
		if(course == null){
			return ResultUtil.errorWithMsg("课程未找到");
		}
	
		return ResultUtil.success(course);
	}
}
