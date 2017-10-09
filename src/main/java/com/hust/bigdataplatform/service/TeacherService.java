package com.hust.bigdataplatform.service;

import java.util.List;

import com.hust.bigdataplatform.model.Course;

public interface TeacherService {
	/**
	 * 教师登陆
	 * @param teacherid
	 * @param teacherpwd
	 * @return
	 */
	public int TeacherLogin(String teacherid, String teacherpwd);
	
	

}
