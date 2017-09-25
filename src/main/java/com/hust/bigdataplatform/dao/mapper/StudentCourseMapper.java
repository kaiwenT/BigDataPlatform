package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.StudentCourse;
import com.hust.bigdataplatform.model.StudentCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentCourseMapper {
    long countByExample(StudentCourseExample example);

    int deleteByExample(StudentCourseExample example);

    int deleteByPrimaryKey(@Param("studentId") String studentId, @Param("courseId") String courseId);

    int insert(StudentCourse record);

    int insertSelective(StudentCourse record);

    List<StudentCourse> selectByExample(StudentCourseExample example);

    StudentCourse selectByPrimaryKey(@Param("studentId") String studentId, @Param("courseId") String courseId);

    int updateByExampleSelective(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    int updateByExample(@Param("record") StudentCourse record, @Param("example") StudentCourseExample example);

    int updateByPrimaryKeySelective(StudentCourse record);

    int updateByPrimaryKey(StudentCourse record);
}