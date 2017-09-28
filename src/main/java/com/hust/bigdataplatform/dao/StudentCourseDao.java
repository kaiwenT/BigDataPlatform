package com.hust.bigdataplatform.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hust.bigdataplatform.dao.mapper.StudentCourseMapper;
import com.hust.bigdataplatform.model.Course;
import com.hust.bigdataplatform.model.StudentCourse;
import com.hust.bigdataplatform.model.StudentCourseExample;
import com.hust.bigdataplatform.model.StudentCourseExample.Criteria;
/**
 * 该类主要实现对学生-课程表的 增删查改
 * @author tankai
 *
 */
@Repository
public class StudentCourseDao {
	
	private static final Logger logger = LoggerFactory.getLogger(Course.class);
	@Autowired
	private StudentCourseMapper studentCourseMapper;
	
	/**
	 * 为StudentCourse表中增加学生选程记录，参数为实体类Studentcourse
	 * @param studentcourse
	 * @return
	 */
	public int insertSelective(StudentCourse studentcourse)
	{
		return studentCourseMapper.insertSelective(studentcourse);
	}
	
	/**
	 * 根据学生ID查找该学生选修的课程
	 * @param studentId
	 * @return
	 */
	public List<StudentCourse> findCourseByStudentId(String studentId){
		StudentCourseExample example = new StudentCourseExample();
		Criteria criteria = example.createCriteria();
		criteria.andStudentIdEqualTo(studentId);
		return studentCourseMapper.selectByExample(example);
	}
	
	/**
	 * 根据学生课程ID（主键）,修改学生课程信息
	 * @param scourse
	 * @return
	 */
	public int updateByCourseId(StudentCourse scourse)
	{
		return studentCourseMapper.updateByPrimaryKeySelective(scourse);
	}

}
