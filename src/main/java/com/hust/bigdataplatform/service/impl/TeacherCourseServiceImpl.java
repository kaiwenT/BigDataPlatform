package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.CourseDao;
import com.hust.bigdataplatform.dao.TeacherCourseDao;
import com.hust.bigdataplatform.dao.TeacherDao;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.model.TeacherCourse;
import com.hust.bigdataplatform.service.TeacherCourseService;
@Service
public class TeacherCourseServiceImpl implements TeacherCourseService{
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherCourseServiceImpl.class);
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeacherCourseDao teacherCourseDao;
	@Autowired
	private CourseDao courseDao;
	/**
	 * 查询教师教授的课程
	 */
	@Override
	public List<Course> getCourseByTeacherid(String teacherid) {
		if (teacherid.equals(null)) {
			return null;
		}
		else 
		{
			List<TeacherCourse> teacherCourses = teacherCourseDao.selectByTeacherID(teacherid);
			if (teacherCourses.equals(null)) {
				return null;
			}
			List<Course> courses = new ArrayList<>();
			for (TeacherCourse teacherCourse : teacherCourses) {
				Course course = courseDao.findById(teacherCourse.getCourseId());
				if (!course.equals(null)) {
					courses.add(course);
				}
			}
			return courses;
		}	
	}
	@Override
	public Teacher getTeacherByCourseid(String courseid) {
		if(courseid == null || "".equals(courseid)){
			return null;
		}
		List<TeacherCourse> l = teacherCourseDao.selectByCourseId(courseid);
		if(l == null || l.isEmpty()){
			return null;
		}
		if(l.get(0).getTeacherId() == null){
			return null;
		}
		return teacherDao.findById(l.get(0).getTeacherId());
	}
}
