package com.hust.bigdataplatform.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Connection.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentCourse;
import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.service.CourseService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.SessionService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentService;
import com.hust.bigdataplatform.service.TeacherCourseService;
import com.hust.bigdataplatform.service.TeacherService;
import com.hust.bigdataplatform.util.ResultUtil;

@Controller
@RequestMapping("/studentcourse")
public class StudentCourseController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private CourseService courseService;
	@Autowired
	private TeacherCourseService teacherCourseService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
	@Autowired
	private SessionService sessionService;	
	
	/**
	 * 查找登录学生所选课程
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getCourseByStudent")
	public Object getCourseByStudent(HttpServletRequest request) {		
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		List<Course> courses = studentCourseService.selectCoursesByStudent(studentId);
		if (null == courses) {
			return ResultUtil.errorWithMsg("学生没有选课");
		}
		return ResultUtil.success(courses);
	}
	
	/**
	 * 查询当前登录学生所有选课的课程成绩
	 * 包括课程名，教师名，平时成绩，实验成绩，考试成绩
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/selectAllCourseGrade")
	public Object selectAllCourseGrade(HttpServletRequest request) {		
		String studentId = (String) sessionService.getObject("studentId", request);
		if(studentId == null){
			return ResultUtil.errorWithMsg("登录信息过期，请重新登录！");
		}
		List<StudentCourse> stucourses = studentCourseService.findStudentCourseByStuId(studentId);
		if (null == stucourses) {
			return ResultUtil.errorWithMsg("学生没有选课");
		}
		List<Map<String, String>> res = new ArrayList<Map<String, String>>();
		for(StudentCourse scourse : stucourses){
			if(scourse == null){
				continue;
			}
			Map<String, String> map = new HashMap<>();
			Teacher t = teacherCourseService.getTeacherByCourseid(scourse.getCourseId());
			if(t == null){
				continue;
			}
			Course course = courseService.findCourseById(scourse.getCourseId());
			if(course == null){
				continue;
			}
			map.put("courseName", course.getCourseName());
			map.put("teacherName", t.getTeacherName());			
			map.put("usualGrade", String.valueOf(scourse.getAttendancerate()));
			map.put("finalGrade", String.valueOf(scourse.getFinalresult()));
			//考试成绩，建表后从数据库获取，暂定100分
			map.put("examGrade", "100");
			int expScore = experimentScoreService.findExpAvgScore(studentId, scourse.getCourseId());
			map.put("expGrade", String.valueOf(expScore));
			res.add(map);
		}
		
		return ResultUtil.success(res);
	}
}
