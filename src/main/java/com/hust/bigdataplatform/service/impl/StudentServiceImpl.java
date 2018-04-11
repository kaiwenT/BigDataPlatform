package com.hust.bigdataplatform.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.StudentDao;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
	
	@Autowired
	private StudentDao studentDao;
		
	@Override
	public List<Student> selectAllStudents(int start, int limit) {
		// TODO Auto-generated method stub
		List<Student> stus = studentDao.selectStudents(start, limit);
		if(stus.isEmpty()){
			logger.info("未查找到学生");
		}
		return stus;
	}
	
	@Override
	public int login(String id, String pwd) {
		// TODO Auto-generated method stub
		Student st = studentDao.findStudentById(id);
		if(st == null){
			return 0;
		}
		if(!pwd.equals(st.getStudentPwd())){
			return -1;
		}
		return 1;
	}

	@Override
	public Student selectStudentById(String studentId) {
		// TODO Auto-generated method stub
		return studentDao.findStudentById(studentId);
	}

	@Override
	public int add(List<Student> students) {
		if (students.size()==0 || students==null) {
			return 0;
		}
		for (Student student : students) {
			if (student==null) {
				return 0;
			}
			Student s = studentDao.findStudentById(student.getStudentId());
			if (s==null) {
				int status = studentDao.insert(student);
				if (status==0) {
					return 0;
				}
			}
		}
		return 1;
	}

	@Override
	public int deleteStudent(String studentId) {
		if(studentId == null){
			return 0;
		}
		return studentDao.deleteById(studentId);
	}

}
