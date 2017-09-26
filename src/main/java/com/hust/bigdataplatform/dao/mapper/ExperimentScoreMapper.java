package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.ExperimentScore;
import com.hust.bigdataplatform.model.ExperimentScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExperimentScoreMapper {
    long countByExample(ExperimentScoreExample example);

    int deleteByExample(ExperimentScoreExample example);

    int deleteByPrimaryKey(@Param("studentId") String studentId, @Param("experimentId") String experimentId);

    int insert(ExperimentScore record);

    int insertSelective(ExperimentScore record);

    List<ExperimentScore> selectByExample(ExperimentScoreExample example);

    ExperimentScore selectByPrimaryKey(@Param("studentId") String studentId, @Param("experimentId") String experimentId);

    int updateByExampleSelective(@Param("record") ExperimentScore record, @Param("example") ExperimentScoreExample example);

    int updateByExample(@Param("record") ExperimentScore record, @Param("example") ExperimentScoreExample example);

    int updateByPrimaryKeySelective(ExperimentScore record);

    int updateByPrimaryKey(ExperimentScore record);
}