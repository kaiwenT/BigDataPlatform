package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.TeacherDao;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Teacher;
import com.hust.bigdataplatform.service.TeacherService;
/**
 * 
 * @author niannian
 *
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	
	private static final Logger logger = LoggerFactory.getLogger(TeacherServiceImpl.class);
	
	private TeacherDao teacherdao;

	//验证教师登陆；若返回0，则不存在该用户；若返回1，密码错误；若返回2,登陆成果
	@Override
	public int TeacherLogin(String teacherid, String teacherpwd) {
		// TODO Auto-generated method stub
		Teacher teacher = teacherdao.findById(teacherid);
		if (teacher.equals(null)) {
			return 0;
		}
		else if (teacher.getTeacherPwd().equals(teacherpwd)) {
			return 2;
		}
		else {
			return 1;
		}
	}

}
