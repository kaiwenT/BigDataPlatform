package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.CourseScale;
import com.hust.bigdataplatform.model.CourseScaleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseScaleMapper {
    long countByExample(CourseScaleExample example);

    int deleteByExample(CourseScaleExample example);

    int deleteByPrimaryKey(String courseId);

    int insert(CourseScale record);

    int insertSelective(CourseScale record);

    List<CourseScale> selectByExample(CourseScaleExample example);

    CourseScale selectByPrimaryKey(String courseId);

    int updateByExampleSelective(@Param("record") CourseScale record, @Param("example") CourseScaleExample example);

    int updateByExample(@Param("record") CourseScale record, @Param("example") CourseScaleExample example);

    int updateByPrimaryKeySelective(CourseScale record);

    int updateByPrimaryKey(CourseScale record);
}