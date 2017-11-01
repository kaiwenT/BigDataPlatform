package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.StudentTask;
import com.hust.bigdataplatform.model.StudentTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentTaskMapper {
    long countByExample(StudentTaskExample example);

    int deleteByExample(StudentTaskExample example);

    int deleteByPrimaryKey(@Param("studentId") String studentId, @Param("taskId") String taskId);

    int insert(StudentTask record);

    int insertSelective(StudentTask record);

    List<StudentTask> selectByExample(StudentTaskExample example);

    StudentTask selectByPrimaryKey(@Param("studentId") String studentId, @Param("taskId") String taskId);

    int updateByExampleSelective(@Param("record") StudentTask record, @Param("example") StudentTaskExample example);

    int updateByExample(@Param("record") StudentTask record, @Param("example") StudentTaskExample example);

    int updateByPrimaryKeySelective(StudentTask record);

    int updateByPrimaryKey(StudentTask record);
}