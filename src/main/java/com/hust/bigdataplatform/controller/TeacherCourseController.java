package com.hust.bigdataplatform.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.service.ChapterSectionService;
import com.hust.bigdataplatform.service.CourseChapterService;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.service.FileService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.TeacherCourseService;
import com.hust.bigdataplatform.service.impl.ChapterSectionServiceImpl;
import com.hust.bigdataplatform.service.impl.FileServiceImpl;
import com.hust.bigdataplatform.util.ResultUtil;
import com.hust.bigdataplatform.util.UploadUtils;
import com.hust.bigdataplatform.util.fileUtil;

@Controller
@RequestMapping("/teacherCourse")
public class TeacherCourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private CourseChapterService courseChapterService;
	@Autowired
	private ChapterSectionService chapterSectionService;
	@Autowired
	private FileService fileservice;
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
		//先删除章下的节
		List<ChapterSection> chapterSections = chapterSectionService.selectByChapterId(chapterId);
		for (ChapterSection chapterSection : chapterSections) {
			courseChapterService.deleteSectionfile(chapterSection.getSectionid());
		}
		File file= new File(courseChapterService.selectById(chapterId, courseId).getCoursewarePath());
		file.delete();
		File file1= new File(courseChapterService.selectById(chapterId, courseId).getVideoPath());
		file1.delete();
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
		courseChapterService.deleteSectionfile(sectionId);
	    //删除section表中记录
		int status = chapterSectionService.deleteSection(sectionId);
		if (status==0) {
			return ResultUtil.errorWithMsg("删除节失败！");
		}
		return ResultUtil.success("删除节成功！");
	}
	/**
	 * 上传PDF文件
	 * @param uploadfile
	 * @param chapter
	 * @param sectionId
	 * @return
	 */
	@RequestMapping(value="/UploadPDF")
	@ResponseBody
	public Object UploadPDF(@RequestParam(value="formData")MultipartFile uploadfile,
			@RequestParam(value="chapterId") String chapterId,@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="courseId") String courseId)
	{
		CourseChapter courseChapter = courseChapterService.selectById(chapterId, courseId);
		if (courseChapter==null) {
			return ResultUtil.errorWithMsg("上传失败");
		}
		com.hust.bigdataplatform.model.File f = new com.hust.bigdataplatform.model.File();
		f.setCreateTime(new Date());
		String uid = UUID.randomUUID().toString();
		f.setFileId(uid);
		f.setFileType("PDF");
		f.setFileName(uploadfile.getOriginalFilename());
		String road = courseChapter.getCoursewarePath()+"/"+sectionId ;
		UploadUtils uploadUtils = new UploadUtils();
		if (uploadUtils.uploadUtils(uploadfile, road)) {
			//在file表中添加记录
			fileservice.insert(f);
			//改变文件的名字
			if (fileUtil.updatename(road+"/"+uploadfile.getOriginalFilename(), road+"/"+uid+".pdf")) {
				return ResultUtil.success("上传成功！");
			}
		}
		return ResultUtil.errorWithMsg("上传失败");
		
	}
	
	@RequestMapping(value="/UploadVideo")
	@ResponseBody
	public Object UploadVideo(@RequestParam(value="formData")MultipartFile uploadfile,
			@RequestParam(value="chapterId") String chapterId,@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="courseId") String courseId)
	{
		CourseChapter courseChapter = courseChapterService.selectById(chapterId, courseId);
		if (courseChapter==null) {
			return ResultUtil.errorWithMsg("上传失败");
		}
		
		com.hust.bigdataplatform.model.File f = new com.hust.bigdataplatform.model.File();
		f.setCreateTime(new Date());
		String uid = UUID.randomUUID().toString();
		f.setFileId(uid);
		f.setFileType("VIDEO");
		f.setFileName(uploadfile.getOriginalFilename());
		
		String road = courseChapter.getVideoPath()+"/"+sectionId;
		UploadUtils uploadUtils = new UploadUtils();
		if (uploadUtils.uploadUtils(uploadfile, road)) {
			fileservice.insert(f);
			//改变文件的名字
			if (fileUtil.updatename(road+"/"+uploadfile.getOriginalFilename(), road+"/"+uid+".mp4")) {
				return ResultUtil.success("上传成功！");
			}
		}
		return ResultUtil.errorWithMsg("上传失败");
		
	}
	
	@RequestMapping("/showPDF")
	@ResponseBody
	public Object showPDF(@RequestParam(value="chapterId") String chapterId,@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="courseId") String courseId)
	{
		CourseChapter course = courseChapterService.selectById(chapterId, courseId);
		if (course == null) {
			return ResultUtil.errorWithMsg("查找PDF失败");
		}
		String road = course.getCoursewarePath()+"/"+sectionId;
		File file = new File(road);
		if (!file.exists()) {
			return ResultUtil.errorWithMsg("没有文件！");
		}
		List<com.hust.bigdataplatform.model.File> files = new ArrayList<com.hust.bigdataplatform.model.File>();
		List<String> names = fileUtil.getFileName(road);
		for (String string : names) {
			files.add(fileservice.selectById(string.substring(0, string.indexOf("."))));
		}
		for (com.hust.bigdataplatform.model.File file2 : files) {
			System.out.println("**********"+file2.getFileName());
		}
		return ResultUtil.success(files);
	}
	
	@RequestMapping("/showViedo")
	@ResponseBody
	public Object showViedo(@RequestParam(value="chapterId") String chapterId,@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="courseId") String courseId)
	{
		CourseChapter course = courseChapterService.selectById(chapterId, courseId);
		if (course == null) {
			return ResultUtil.errorWithMsg("查找PDF失败");
		}
		String road = course.getVideoPath()+"/"+sectionId;
		File file = new File(road);
		if (!file.exists()) {
			return ResultUtil.errorWithMsg("文件不存在！");
		}
		List<com.hust.bigdataplatform.model.File> files = new ArrayList<com.hust.bigdataplatform.model.File>();
		List<String> names = fileUtil.getFileName(road);
		for (String string : names) {
			files.add(fileservice.selectById(string.substring(0, string.indexOf("."))));
		}
		for (com.hust.bigdataplatform.model.File file2 : files) {
			System.out.println("8888888"+file2.getFileName());
		}
		return ResultUtil.success(files);
	}
	@RequestMapping("/DeleteVideo")
	@ResponseBody
	public Object DeleteVideo(@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="videoId") String videoId, @RequestParam(value="courseId") String courseId)
	{
		//删除文件成功后，在删除记录
		ChapterSection chapterSection = chapterSectionService.selectBySectionId(sectionId);
		CourseChapter chapter=courseChapterService.selectById(chapterSection.getChapterId(), courseId);
		String road = chapter.getVideoPath()+"/"+chapterSection.getSectionid()+"/"+videoId+".mp4";
		File file = new File(road);
		if (file.isFile()) {
			file.delete();
		}
		if (fileservice.delete(videoId)==1) {
			return ResultUtil.success("删除成功！");
		}
		return ResultUtil.errorWithMsg("删除失败！");
	}
	
	@RequestMapping("/DeletePDF")
	@ResponseBody
	public Object DeletePDF(@RequestParam(value="sectionId") String sectionId,
			@RequestParam(value="pdfId") String pdfId, @RequestParam(value="courseId") String courseId)
	{
		//删除文件成功后，在删除记录
		ChapterSection chapterSection = chapterSectionService.selectBySectionId(sectionId);
		CourseChapter chapter=courseChapterService.selectById(chapterSection.getChapterId(), courseId);
		String road = chapter.getCoursewarePath()+"/"+chapterSection.getSectionid()+"/"+pdfId+".pdf";
		File file = new File(road);
		if (file.isFile()) {
			file.delete();
		}
		if (fileservice.delete(pdfId)==1) {
			return ResultUtil.success("删除成功！");
		}
		return ResultUtil.errorWithMsg("删除失败！");
	}

}
