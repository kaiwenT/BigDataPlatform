package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.StudentScore;
import com.hust.bigdataplatform.model.StudentScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentScoreMapper {
    long countByExample(StudentScoreExample example);

    int deleteByExample(StudentScoreExample example);

    int deleteByPrimaryKey(@Param("studentId") String studentId, @Param("courseId") String courseId);

    int insert(StudentScore record);

    int insertSelective(StudentScore record);

    List<StudentScore> selectByExample(StudentScoreExample example);

    StudentScore selectByPrimaryKey(@Param("studentId") String studentId, @Param("courseId") String courseId);

    int updateByExampleSelective(@Param("record") StudentScore record, @Param("example") StudentScoreExample example);

    int updateByExample(@Param("record") StudentScore record, @Param("example") StudentScoreExample example);

    int updateByPrimaryKeySelective(StudentScore record);

    int updateByPrimaryKey(StudentScore record);
}