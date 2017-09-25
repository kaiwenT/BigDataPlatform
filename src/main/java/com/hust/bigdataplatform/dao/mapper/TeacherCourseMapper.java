package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.TeacherCourse;
import com.hust.bigdataplatform.model.TeacherCourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherCourseMapper {
    long countByExample(TeacherCourseExample example);

    int deleteByExample(TeacherCourseExample example);

    int deleteByPrimaryKey(@Param("teacherId") String teacherId, @Param("courseId") String courseId);

    int insert(TeacherCourse record);

    int insertSelective(TeacherCourse record);

    List<TeacherCourse> selectByExample(TeacherCourseExample example);

    int updateByExampleSelective(@Param("record") TeacherCourse record, @Param("example") TeacherCourseExample example);

    int updateByExample(@Param("record") TeacherCourse record, @Param("example") TeacherCourseExample example);
}