package com.hust.bigdataplatform.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hust.automaticrating.utils.AutoRating;
import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentFile;
import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.File;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.service.ExperimentFileService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.ExperimentService;
import com.hust.bigdataplatform.service.FileService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.util.DateConverter;
import com.hust.bigdataplatform.util.ImageUtil;
import com.hust.bigdataplatform.util.ResultUtil;
import com.hust.bigdataplatform.util.UploadUtils;
import com.hust.bigdataplatform.util.fileUtil;
   
@Controller
@RequestMapping("/experiment")
public class ExperimentController {

	@Autowired
	private ExperimentService experimentService;
	@Autowired
	private ExperimentFileService experimentFileService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private FileService fileservice;
	/**
	 * 获取某个课程的所有的实验
	 * @param courseId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentsByCourse")
	@ResponseBody
	public Object getExperimentsByCourse(@RequestParam(value="courseId", required=true)String courseId,
			HttpServletRequest request){
		if(courseId == null || "".equals(courseId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		List<Experiment> exps = experimentService.findExperimentByCourseId(courseId);
		return ResultUtil.success(exps);
	}
	
	@RequestMapping("/getExperimentById")
	@ResponseBody
	public Object getExperimentById(@RequestParam(value="experimentId", required=true)String experimentId,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("实验id为空");
		}
		List<Experiment> exps = experimentService.findExperimentByExpId(experimentId);
		if(exps == null || exps.isEmpty()){
			return ResultUtil.errorWithMsg("实验查询失败");
		}
		return ResultUtil.success(exps.get(0));
	}
	/**
	 * 获取某个实验所有文件，包括video,pdf
	 * @param experimentId
	 * @param type
	 * @param request
	 * @return
	 */
	@RequestMapping("/getFilesByExperiment")
	@ResponseBody
	public Object getFilesByExperiment(@RequestParam(value="experimentId", required=true)String experimentId,
			@RequestParam(value="type", required=false)String type,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		List<File> files = experimentFileService.findFileByExperiment(experimentId, type);
		return ResultUtil.success(files);
	}
	/**
	 * 获取某个文件所属的实验
	 * @param fileId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentByFile")
	@ResponseBody
	public Object getExperimentByFile(@RequestParam(value="fileId", required=true)String fileId,			
			HttpServletRequest request){
		if(fileId == null || "".equals(fileId)){
			return ResultUtil.errorWithMsg("文件id为空");
		}
		Experiment e = experimentFileService.findExperimentByFile(fileId);
		if(e == null){
			return ResultUtil.errorWithMsg("文件对应实验为空");
		}
		return ResultUtil.success(e);
	}
	/**
	 * 获取当前登录学生某个实验的成绩
	 * @param experimentId
	 * @param request
	 * @return
	 */
	@RequestMapping("/getExperimentScore")
	@ResponseBody
	public Object getExperimentScore(@RequestParam(value="experimentId", required=true)String experimentId,
			HttpServletRequest request){
		if(experimentId == null || "".equals(experimentId)){
			return ResultUtil.errorWithMsg("课程id为空");
		}
		String stuId = (String) sessionService.getObject("studentId", request);
		if(stuId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		ExperimentScore escore = experimentScoreService.selectExpScoreByStu(stuId, experimentId);
		if(escore == null){
			return ResultUtil.success(0);
		}
		return ResultUtil.success(escore.getExpFinalscore());
	}
	
	@RequestMapping("/AddExperiment")
	@ResponseBody
	public Object AddExperiment(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="exptitle") String exptitle,
			@RequestParam(value="expdeadline") String deadline)
	{
		if (courseId=="") {
			return ResultUtil.errorWithMsg("课程id为空");
		}
		Experiment experiment = new Experiment();
		String uid = UUID.randomUUID().toString();
		experiment.setExperimentId(uid);
		experiment.setCourseId(courseId);
		experiment.setExperimentName(exptitle);
		experiment.setExperimentSubmitdemand(" ");
		experiment.setExperimentCreatetime(new Date());
		experiment.setExperimentDeadline(new DateConverter().convert(deadline));
//		experiment.setExperimentManualpath(Constant.DIRECTORY.EXPERIMENT_REPORT+uid);
//		System.out.println("实验手册："+Constant.DIRECTORY.EXPERIMENT_REPORT);
//		experiment.setExperimentVideopath(Constant.DIRECTORY.EXPERIMENT_VIDEO+uid);
//		System.out.println("实验视频："+Constant.DIRECTORY.EXPERIMENT_VIDEO);
		experiment.setExperimentReportpath(Constant.DIRECTORY.REPORT_SUBMIT+uid);
		experiment.setExperimentResultspath(Constant.DIRECTORY.EXPERIMENT_DATA_SUBMIT+uid);
		int status = experimentService.addExperiment(experiment);
		if (status==0) {
			return ResultUtil.errorWithMsg("添加实验失败！");
		}
		//当添加实验后，在experimentScore表中插入记录
		int s = experimentScoreService.AddExperimentScore(courseId, uid);
		if (s==0) {
			return ResultUtil.errorWithMsg("实验分数表初始化失败！");
		}
		//添加一个实验记录时启动自动评分线程
		AutoRating.rating(experiment, "");
		return ResultUtil.success(experiment);
	}
	
	@RequestMapping("/UpdateExperiment")
	@ResponseBody
	public Object UpdateExperiment(@RequestParam(value="courseId") String courseId,
			@RequestParam(value="exptitle") String exptitle,
			@RequestParam(value="expdeadline") String deadline,
			@RequestParam(value="experimentId") String experimentId)
	{
		if (courseId=="") {
			return ResultUtil.errorWithMsg("课程id为空");
		}
		List<Experiment> experiment = experimentService.findExperimentByExpId(experimentId);
		if (experiment==null) {
			return ResultUtil.errorWithMsg("此实验不存在！");
		}
		String oldName = experiment.get(0).getExperimentName();
		experiment.get(0).setExperimentDeadline(new DateConverter().convert(deadline));
		experiment.get(0).setExperimentName(exptitle);
		int status = experimentService.updateExperiment(experiment.get(0));
		if (status==0) {
			return ResultUtil.errorWithMsg("修改实验内容失败！");
		}

		//更新实验信息时启动自动评分线程
		AutoRating.rating(experiment.get(0), oldName);
		return ResultUtil.errorWithMsg("修改实验内容成功！");
	}
	
	@RequestMapping("/UpdateExpSubmitDemand")
	@ResponseBody
	public Object UpdateExpSubmitDemand(@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value="submitDemand") String submitDemand)
	{
		List<Experiment> experiment = experimentService.findExperimentByExpId(experimentId);
		if (experiment==null) {
			return ResultUtil.errorWithMsg("没找到该实验！");
		}
		experiment.get(0).setExperimentSubmitdemand(submitDemand);
		int status = experimentService.updateExperiment(experiment.get(0));
		if (status==0) {
			return ResultUtil.errorWithMsg("修改实验 提交要求失败！");
		}
		return ResultUtil.success("修改实验 提交要求失成功!");
	}
	
	@RequestMapping(value="/UploadFile")
	@ResponseBody
	public Object UploadFile(@RequestParam(value="formData")MultipartFile uploadfile,
			@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value="type") String type)
	{
		List<Experiment> experiment = experimentService.findExperimentByExpId(experimentId);
		if (experiment.get(0)==null) {
			return ResultUtil.errorWithMsg("上传失败");
		}	
		com.hust.bigdataplatform.model.File f = new com.hust.bigdataplatform.model.File();
		f.setCreateTime(new Date());
		String uid = UUID.randomUUID().toString();
		f.setFileId(uid);
		f.setFileType(type);
		f.setFileName(uploadfile.getOriginalFilename());
		
		ExperimentFile experimentFile = new ExperimentFile();
		experimentFile.setExperimentId(experimentId);
		experimentFile.setFileId(uid);
		
		String road = Constant.DIRECTORY.FILE;
//		if (type.equals("PDF")) {
//			road=experiment.get(0).getExperimentManualpath();
//		}
//		else{
//			road=experiment.get(0).getExperimentVideopath();
//		}
		UploadUtils uploadUtils = new UploadUtils();
		if (uploadUtils.uploadUtils(uploadfile, road)) {
			fileservice.insert(f);
			experimentFileService.add(experimentId, f);
			//改变文件的名字
			if (type.equals("PDF")) {
				if (fileUtil.updatename(road+"/"+uploadfile.getOriginalFilename(), road+"/"+uid+".pdf")) {
					ImageUtil.generatePDFImage(road+"/"+uid+".pdf", road+"/"+uid+".jpg");
					return ResultUtil.success(uid);
				}
			}
			else {
				if (fileUtil.updatename(road+"/"+uploadfile.getOriginalFilename(), road+"/"+uid+".mp4")) {
					ImageUtil.generateVideoImage(Constant.FFMPEG_PATH, road+"/"+uid+".mp4", road+"/"+uid+".jpg");
					return ResultUtil.success(uid);
				}
			}
		}
		return ResultUtil.errorWithMsg("上传失败");
	}
	
	@RequestMapping(value="/DeleteFile")
	@ResponseBody
	public Object DeleteFile(@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value="fileId") String fileId)
	{
		//先删除文件，然后在file中删除记录
		List<Experiment> experiment = experimentService.findExperimentByExpId(experimentId);
		if (experiment.get(0)==null) {
			return ResultUtil.errorWithMsg("删除失败！");
		}
		File file = fileservice.selectById(fileId);
		if (file==null) {
			return ResultUtil.errorWithMsg("删除失败！");
		}
		String road="";
		if (file.getFileType().equals("PDF")) {
//			 road = Constant.DIRECTORY.EXPERIMENT_REPORT+experimentId+"/"+fileId+".pdf";
			road = Constant.DIRECTORY.FILE+fileId+".pdf";
		}
		else{
//			 road = Constant.DIRECTORY.EXPERIMENT_VIDEO+experimentId+"/"+fileId+".mp4";
			road = Constant.DIRECTORY.FILE+fileId+".mp4";
		}
		java.io.File test = new java.io.File(road);
		java.io.File pic = new java.io.File(Constant.DIRECTORY.FILE+fileId+".jpg");
		if (test.isFile() && pic.isFile()) {
			if (test.delete() && pic.delete()) {
				if (fileservice.delete(file.getFileId())==1) {
					return ResultUtil.success("删除成功！");
				}
			}
		}
		return ResultUtil.errorWithMsg("删除失败！");
	}
	
	@RequestMapping(value="/DeleteExperiment")
	@ResponseBody
	public Object DeleteExperiment(@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value="courseId") String courseId)
	{
		List<File> experimentFile = experimentFileService.findFileByExperiment(experimentId, "");
		if (experimentFile==null) {
			return ResultUtil.errorWithMsg("删除失败！");
		}
		if (experimentFile.size()!=0) {
			//删除目录
//			String road1 = Constant.DIRECTORY.EXPERIMENT_REPORT+experimentId;
//			String road2 = Constant.DIRECTORY.EXPERIMENT_VIDEO+experimentId;
			for(File f : experimentFile){
				String type = "PDF".equals(f.getFileType()) ? ".pdf" : ".mp4";
				String road1 = Constant.DIRECTORY.FILE + f.getFileId() + type;
				String road2 = Constant.DIRECTORY.FILE + f.getFileId() + ".jpg";
				fileUtil.deleteSection(road1);
				fileUtil.deleteSection(road2);
			}

				
		}
		if (experimentService.deleteExperiment(experimentId, courseId)==0) {
			return ResultUtil.errorWithMsg("删除失败！");
		}
		return ResultUtil.success("删除成功！");
	}
}
