package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.Experiment;
import com.hust.bigdataplatform.model.ExperimentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExperimentMapper {
    long countByExample(ExperimentExample example);

    int deleteByExample(ExperimentExample example);

    int deleteByPrimaryKey(@Param("experimentId") String experimentId, @Param("courseId") String courseId);

    int insert(Experiment record);

    int insertSelective(Experiment record);

    List<Experiment> selectByExample(ExperimentExample example);

    Experiment selectByPrimaryKey(@Param("experimentId") String experimentId, @Param("courseId") String courseId);

    int updateByExampleSelective(@Param("record") Experiment record, @Param("example") ExperimentExample example);

    int updateByExample(@Param("record") Experiment record, @Param("example") ExperimentExample example);

    int updateByPrimaryKeySelective(Experiment record);

    int updateByPrimaryKey(Experiment record);
}