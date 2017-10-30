package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.CourseTask;
import com.hust.bigdataplatform.model.CourseTaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseTaskMapper {
    long countByExample(CourseTaskExample example);

    int deleteByExample(CourseTaskExample example);

    int deleteByPrimaryKey(@Param("courseId") String courseId, @Param("taskId") String taskId);

    int insert(CourseTask record);

    int insertSelective(CourseTask record);

    List<CourseTask> selectByExample(CourseTaskExample example);

    int updateByExampleSelective(@Param("record") CourseTask record, @Param("example") CourseTaskExample example);

    int updateByExample(@Param("record") CourseTask record, @Param("example") CourseTaskExample example);
}