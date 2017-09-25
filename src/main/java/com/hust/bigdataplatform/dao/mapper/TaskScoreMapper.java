package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.TaskScore;
import com.hust.bigdataplatform.model.TaskScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskScoreMapper {
    long countByExample(TaskScoreExample example);

    int deleteByExample(TaskScoreExample example);

    int deleteByPrimaryKey(@Param("studentId") String studentId, @Param("taskId") String taskId);

    int insert(TaskScore record);

    int insertSelective(TaskScore record);

    List<TaskScore> selectByExample(TaskScoreExample example);

    TaskScore selectByPrimaryKey(@Param("studentId") String studentId, @Param("taskId") String taskId);

    int updateByExampleSelective(@Param("record") TaskScore record, @Param("example") TaskScoreExample example);

    int updateByExample(@Param("record") TaskScore record, @Param("example") TaskScoreExample example);

    int updateByPrimaryKeySelective(TaskScore record);

    int updateByPrimaryKey(TaskScore record);
}