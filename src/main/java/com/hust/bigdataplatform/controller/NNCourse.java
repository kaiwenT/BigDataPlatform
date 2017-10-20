package com.hust.bigdataplatform.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/teacherCourse")
public class NNCourse {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private CourseChapterService courseChapterService;
	@Autowired
	private ChapterSectionService chapterSectionService;
	
	/**
	 * 设置课程介绍内容
	 * @param courseId
	 * @param courseIntroduce
	 * @return
	 */
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
	/**
	 * 设置课程大纲
	 * @param courseId
	 * @param Outline
	 * @return
	 */
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
	/**
	 * 添加章
	 * @param courseId
	 * @param courseName
	 * @return
	 */
	@RequestMapping("/AddChatper")
	@ResponseBody
	public Object AddChatper(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="courseName")String courseName)
	{
		CourseChapter courseChapter = new CourseChapter();
		String chapterId = UUID.randomUUID().toString(); //章ID
		courseChapter.setChapterId(chapterId);
		courseChapter.setChapterName(courseName);
		courseChapter.setCourseId(courseId);
		String coursewarePath = Constant.DIRECTORY.COURSEWARE+chapterId;
		courseChapter.setCoursewarePath(coursewarePath);
		String videoPath = Constant.DIRECTORY.COURSE_VIDEO+chapterId;
		courseChapter.setVideoPath(videoPath);
		courseChapter.setCreatTime(new Date()); //到此courseChapter封装完毕
		int status = courseChapterService.insertChapter(courseChapter);
		if (status==2) {
			return ResultUtil.errorWithMsg("章的名字不能为空！");
		}
		if (status==0) {
			return ResultUtil.errorWithMsg("添加章失败！");
		}
		return ResultUtil.success(courseChapter);
	}
	/**
	 * 修改章
	 * @param chapterId
	 * @param courseName
	 * @return
	 */
	@RequestMapping("/UpdateChatper")
	@ResponseBody
	public Object UpdateChatper(@RequestParam(value="chapterId") String chapterId,
			@RequestParam(value="chapterName") String chapterName, @RequestParam(value="courseId")String courseId)
	{
		CourseChapter courseChapter = courseChapterService.selectById(chapterId, courseId);
		if (courseChapter==null) {
			return ResultUtil.errorWithMsg("修改章失败！");
		}
		courseChapter.setChapterName(chapterName);
		int status = courseChapterService.update(courseChapter);
		if (status==0) {
			return ResultUtil.errorWithMsg("修改章失败！");
		}
		if (status==2) {
			return ResultUtil.errorWithMsg("章的名字不能为空！");
		}
		return ResultUtil.success("修改成功！");
	}
	/**
	 * 删除章，包括章下面的节信息（磁盘中的PDF和video）,数据库中设置了联级更新
	 * @param chapter
	 * @param courseId
	 * @return
	 */
	@RequestMapping("/DeleteChapter")
	@ResponseBody
	public Object DeleteChapter(@RequestParam("chapterId") String chapterId,
			@RequestParam(value="courseId") String courseId)
	{
		int status = courseChapterService.deleteByChapterId(chapterId, courseId);
		if (status==0) {
			return ResultUtil.errorWithMsg("删除章失败！");
		}
		return ResultUtil.success("删除章成功！");
	}
	/**
	 * 增加节 
	 * @param chpaterId
	 * @param sectionName
	 * @return
	 */
	@RequestMapping("/AddSection")
	@ResponseBody
	public Object AddSection(@RequestParam("chapterId") String chpaterId, 
			@RequestParam("sectionName") String sectionName)
	{
		ChapterSection chapterSection = new ChapterSection();
		chapterSection.setChapterId(chpaterId);
		chapterSection.setSectionid(UUID.randomUUID().toString());
		chapterSection.setCreatTime(new Date());
		chapterSection.setSectionname(sectionName);
		int status = chapterSectionService.insertSection(chapterSection);
		if (status==2) {
			return ResultUtil.errorWithMsg("节的名字不能为空！");
		}
		if (status==0) {
			return ResultUtil.errorWithMsg("添加节失败！");
		}
		return ResultUtil.success(chapterSection);
	}
	/**
	 * 修改节名字
	 * @param sectionId
	 * @param sectionName
	 * @return
	 */
	@RequestMapping("/UpdateSection")
	@ResponseBody
	public Object UpdateSection(@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="sectionName") String sectionName)
	{
		ChapterSection chapterSection = chapterSectionService.selectBySectionId(sectionId);
		if (chapterSection==null) {
			return ResultUtil.errorWithMsg("修改节失败！");
		}
		chapterSection.setSectionname(sectionName);
		int status = chapterSectionService.Update(chapterSection);
		if (status==0) {
			return ResultUtil.errorWithMsg("修改节失败！");
		}
		if (status==2) {
			return ResultUtil.errorWithMsg("节的名字不能为空！");
		}
		return ResultUtil.success("修改节成功！");
		
	}
	/**
	 * 删除节
	 * @param sectionId
	 * @return
	 */
	@RequestMapping("/DeleteSection")
	@ResponseBody
	public Object DeleteSection(@RequestParam(value="sectionId") String sectionId)
	{
		int status = chapterSectionService.deleteSection(sectionId);
		if (status==0) {
			return ResultUtil.errorWithMsg("删除节失败！");
		}
		return ResultUtil.success("删除节成功！");
	}
}
