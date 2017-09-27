package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hust.bigdataplatform.dao.mapper.StudentMapper;
import com.hust.bigdataplatform.model.StudentExample.Criteria;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentExample;

@Repository
public class StudentDao {
	private static final Logger logger = LoggerFactory.getLogger(StudentDao.class);
	
	@Autowired
	private StudentMapper studentMapper;
	
	/**
	 * 查询学生
	 * @param start 开始索引
	 * @param limit 数量
	 * @return
	 */
	public List<Student> selectStudents(int start, int limit){
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdIsNotNull();
		example.setStart(start);
		example.setLimit(limit);
		List<Student> students = studentMapper.selectByExample(example);
		return students;
	}
	
	/**
	 * 
	 * @param studentId
	 * @return
	 */
	public Student findStudentById(String studentId){
		return studentMapper.selectByPrimaryKey(studentId);
	}
	/**
	 * 插入一条学生记录
	 * @param s
	 * @return
	 */
	public int insert(Student s){
		return studentMapper.insertSelective(s);
	}
	
	/**
	 * 删除学生记录
	 * @param studentId 学号
	 * @return
	 */
	public int deleteById(String studentId){
		return studentMapper.deleteByPrimaryKey(studentId);
	}
	/**
	 * 更新学生信息
	 * @param s
	 * @return
	 */
	public int updateById(Student s){
		return studentMapper.updateByPrimaryKeySelective(s);
	}
	/**
	 * 学生登录验证
	 * @param id
	 * @param pwd
	 * @return
	 */
	public List<Student> checkLogin(String id, String pwd) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(id);
		criteria.andStudentPwdEqualTo(pwd);
		List<Student> users = studentMapper.selectByExample(example);
		return users;
	}
	/**
	 * 查询学生数量
	 * @return
	 */
	public long selectCountOfStudent() {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdIsNotNull();
		long count = studentMapper.countByExample(example);
		return count;
	}
}
