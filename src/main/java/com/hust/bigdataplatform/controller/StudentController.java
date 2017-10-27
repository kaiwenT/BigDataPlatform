package com.hust.bigdataplatform.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.hust.bigdataplatform.constant.Constant;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.util.ResultUtil;
import com.hust.bigdataplatform.util.UploadUtils;
import com.hust.bigdataplatform.util.fileUtil;


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
		if(studentId == null || "".equals(studentId) || password == null || "".equals(password)){
			return ResultUtil.errorWithMsg("登录失败，用户名或密码为空！");
		}
		
		int islogin = studentService.login(studentId, password);
		if (islogin == 0) {
			return ResultUtil.errorWithMsg("登录失败，不存在的用户名！");
		}
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
	
	/**
	 * 学生上交实验报告
	 * @param request
	 * @param experimentId
	 * @param uploadfile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadExpReport", method = RequestMethod.POST)
	public Object uploadExpReport(@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value = "uploadfile", required = true) MultipartFile uploadfile, 
			HttpServletRequest request){
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		UploadUtils up = new UploadUtils();
		String path = Constant.DIRECTORY.REPORT_SUBMIT + File.separator + experimentId + File.separator + studentId;
		System.out.println(path);
		if(!up.upload(uploadfile, path)){
			return ResultUtil.errorWithMsg(uploadfile.getName() + "上传失败，请重新上传！");
		}
		
		return ResultUtil.success("上传实验报告成功！");
	}
	/**
	 * 上传实验数据
	 * @param request
	 * @param experimentId
	 * @param uploadfile
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadExpData", method = RequestMethod.POST)
	public Object uploadExpData(@RequestParam(value="experimentId") String experimentId,
			@RequestParam(value = "uploadfile") MultipartFile uploadfile,
			HttpServletRequest request){
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		UploadUtils up = new UploadUtils();
		String path = Constant.DIRECTORY.EXPERIMENT_DATA_SUBMIT + File.separator + experimentId + File.separator + studentId;
		
		if(!up.upload(uploadfile, path)){
			return ResultUtil.errorWithMsg(uploadfile.getName() + "上传失败，请重新上传！");
		}
		
		return ResultUtil.success("上传实验报告成功！");
	}	
}
