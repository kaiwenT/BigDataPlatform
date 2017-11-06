package com.hust.bigdataplatform.controller;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

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
import com.hust.bigdataplatform.model.StudentCourse;
import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.model.params.StudentAndGroup;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentScoreService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.service.StudentTaskService;
import com.hust.bigdataplatform.service.TeacherService;
import com.hust.bigdataplatform.util.ResultUtil;
import com.hust.bigdataplatform.util.UploadUtils;
import com.hust.utils.readExcel;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SessionService sessionService;
	@Autowired
	private StudentService studentService;
	@Autowired 
	private StudentCourseService studentCourseService;
	@Autowired
	private StudentScoreService studentScoreService;
	@Autowired
	private StudentTaskService studentTaskService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
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
	
	@ResponseBody
	@RequestMapping("/teacherloginout")
	public Object loginout(HttpServletRequest request) {		
		String teacherId = (String) sessionService.getObject("teacherId", request);		
		if (teacherId != null) {
			sessionService.remove("teacherId", request);
		}		
		return ResultUtil.success("退出成功");
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
		if (teacherid==null) {
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
	/**
	 * 导入学生名单，且成功后 
	 * @param uploadfile
	 * @param courseId
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value="/importStudent",method = RequestMethod.POST)
	public Object importStudent(@RequestParam(value = "formData", required = false) MultipartFile uploadfile,
			@RequestParam(value="courseId")String courseId) throws Exception
	{
		System.out.println("***********");
		if (courseId=="") {
			return ResultUtil.errorWithMsg("课程id为空");
		}
		String road=Constant.DIRECTORY.STUDENT_PHOTO+courseId;
		UploadUtils up = new UploadUtils();
		readExcel rExcel=new readExcel();
		String filename = uploadfile.getOriginalFilename();
		up.upload(uploadfile, road);
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();//对应excel文件
		result = rExcel.ReadStudent(road+"/"+filename);
		//删除名单
		File file = new File(road+"/"+filename);
		file.delete();
		List<Student> students = new ArrayList<Student>();
		List<StudentAndGroup> studentAndGroups = new ArrayList<StudentAndGroup>();
		for (Map<String, String> map : result) 
		{
			Student student = new Student();
			StudentAndGroup sGroup = new StudentAndGroup();
			student.setStudentId(map.get("学号"));
			student.setStudentPwd(map.get("学号"));
			student.setStudentName(map.get("姓名"));
			student.setStudentFaculty(map.get("院系"));
			students.add(student);
			sGroup.setGroupId(map.get("组号"));
			sGroup.setStudentId(map.get("学号"));
			studentAndGroups.add(sGroup);
		}
		//添加学生名单
		int status = studentService.add(students);
		if (status==0) {
			return ResultUtil.errorWithMsg("名单插入失败！");
		}
		//初始化学生选课表
		int s1 = studentCourseService.insert(studentAndGroups, courseId);
		//初始化学生成绩表
		int s2 = studentScoreService.insert(students, courseId); //填充student_score表
		//初始化实验成绩表
		int s3 = experimentScoreService.AddExperimentScore(courseId, students);
		//初始化学生作业表
		int s4 = studentTaskService.addForStudentTask(courseId, students);
		if (s1==0) {
			return ResultUtil.errorWithMsg("学生选课表初始化失败！");
		}
		if (s2==0) {
			return ResultUtil.errorWithMsg("学生成绩表初始化失败！");
		}
		if (s3==0) {
			return ResultUtil.errorWithMsg("实验成绩表初始化失败！");
		}
		if (s4==0) {
			return ResultUtil.errorWithMsg("学生作业表初始化失败！");
		}
		return ResultUtil.success("上传成功");
	}
	@ResponseBody
	@RequestMapping(value="/ShowStudent",method = RequestMethod.POST)
	public Object ShowStudent( @RequestParam(value="courseId")String courseId) 
	{
		if (courseId=="") {
			return ResultUtil.errorWithMsg("登陆超时，请重新登陆");
		}
		List<Student> students = studentCourseService.findBycourseId(courseId);
		if (students==null||students.size()==0) {
			return ResultUtil.errorWithMsg("未上传学生名单！");
		}
		List<StudentAndGroup> studentAndGroups = new ArrayList<StudentAndGroup>();
		for (Student student : students) {
			StudentCourse sCourse = studentCourseService.findStudentCourseByStuId(student.getStudentId(), courseId);
			StudentAndGroup sGroup = new StudentAndGroup();
			sGroup.setGroupId(sCourse.getStudentGroupid());
			sGroup.setStudentFaculty(student.getStudentFaculty());
			sGroup.setStudentId(student.getStudentId());
			sGroup.setStudentName(student.getStudentName());
			studentAndGroups.add(sGroup);
		}
		if (studentAndGroups==null||studentAndGroups.size()==0) {
			return ResultUtil.errorWithMsg("显示学生名单失败！");
		}
		return ResultUtil.success(studentAndGroups);
	}
	
	@ResponseBody
	@RequestMapping(value="/importUsualScore",method = RequestMethod.POST)
	public Object importUsualScore(@RequestParam(value = "formData", required = false) MultipartFile uploadfile,
			@RequestParam(value="courseId")String courseId) throws Exception
	{
		System.out.println("***********");
		if (courseId=="") {
			return ResultUtil.errorWithMsg("课程id为空");
		}
		String road=Constant.DIRECTORY.STUDENT_PHOTO+courseId;
		UploadUtils up = new UploadUtils();
		readExcel rExcel=new readExcel();
		String filename = uploadfile.getOriginalFilename();
		up.upload(uploadfile, road);
		List<Map<String, String>> result = new ArrayList<Map<String,String>>();//对应excel文件
		result = rExcel.ReadStudent(road+"/"+filename);
		//删除名单
		File file = new File(road+"/"+filename);
		file.delete();
		for (Map<String, String> map : result) 
		{
			String studentId = map.get("学号");
			String score = map.get("考勤成绩");
			StudentCourse studentCourse = new StudentCourse();
			studentCourse.setCourseId(courseId);
			studentCourse.setStudentId(studentId);
			int i= (int)Float.parseFloat(score);
			studentCourse.setAttendancerate(i);
			if (studentCourseService.update(studentCourse)==0) {
				return ResultUtil.errorWithMsg("上传失败！");
			}
		}
		return ResultUtil.success("上传成功");
	}
}
