package com.hust.bigdataplatform.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.CourseScale;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.CourseScaleService;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseScaleService courseScaleService;
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
		if(chapterId == null || "".equals(chapterId)){
			return ResultUtil.errorWithMsg("课程节id为空");
		}
		List<ChapterSection> sections = chapterSectionService.selectByChapterId(chapterId);
		return ResultUtil.success(sections);
	}

	/**
	 * 根据章id查询所有节
	 * 
	 * @param chapterId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getChapterBySection")
	@ResponseBody
	public Object getChapterBySection(@RequestParam(value = "sectionId", required = true) String sectionId,
			HttpServletRequest request) {
		if(sectionId == null || "".equals(sectionId)){
			return ResultUtil.errorWithMsg("课程节id为空");
		}
		ChapterSection chapterSection = chapterSectionService.selectBySectionId(sectionId);
		String chapterId = chapterSection.getChapterId();
		String sectionName = chapterSection.getSectionname();
		if(chapterId == null || "".equals(chapterId)){
			return ResultUtil.errorWithMsg("课程章id为空");
		}
		CourseChapter courseChapter = courseChapterService.selectByChapterId(chapterId);
		if(courseChapter == null){
			return ResultUtil.errorWithMsg("课程章为空");
		}
		String[] res = {chapterId, courseChapter.getChapterName(), courseChapter.getCoursewarePath(), courseChapter.getVideoPath(), sectionName}; 
		return ResultUtil.success(res);
	}
	/**
	 * 获取课程
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCourseById")
	@ResponseBody
	public Object getCourseById(@RequestParam(value = "courseId", required = true) String courseId,
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
	
	/**
	 * 获取课程评分标准
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getCourseScale")
	@ResponseBody
	public Object getCourseScale(@RequestParam(value = "courseId", required = true) String courseId,
			HttpServletRequest request) {
		if(courseId == null || "".equals(courseId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		CourseScale scale = courseScaleService.findByCourseId(courseId);
		if(scale == null){
			return ResultUtil.errorWithMsg("课程的评分标准未找到");
		}
	
		return ResultUtil.success(scale);
	}
	
	@RequestMapping("/updateCourseScale")
	@ResponseBody
	public Object updateCourseScale(@RequestParam(value = "courseId", required = true) String courseId,
			@RequestParam(value = "regular_grade", required = true) String regular_grade,
			@RequestParam(value = "exp_grade", required = true) String exp_grade,
			@RequestParam(value = "regular_work", required = true) String regular_work,
			@RequestParam(value = "exp_report", required = true) String exp_report) {
		if (courseId=="" || regular_grade == "" || exp_grade==""|| regular_work==""|| exp_report=="") {
			return ResultUtil.errorWithMsg("各类成绩比例未填写完整！");
		}
		CourseScale courseScale = new CourseScale();
		courseScale.setCourseId(courseId);
		courseScale.setAttendanceRate(Float.parseFloat(regular_grade)/100);
		courseScale.setExperimentRate(Float.parseFloat(exp_grade)/100);
		courseScale.setExerciseRate(Float.parseFloat(regular_work)/100);
		courseScale.setExpReportRate(Float.parseFloat(exp_report)/100);
		if (courseScaleService.findByCourseId(courseId)==null) {
			if (courseScaleService.add(courseScale)==1) {
				return ResultUtil.success("填写成功！");
			}
		}
		else {
			if (courseScaleService.update(courseScale)==1) {
				return ResultUtil.success("修改成功！");
			}
		}
		return ResultUtil.errorWithMsg("失败！");
	}
	
}
