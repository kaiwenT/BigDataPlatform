package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.ExperimentFile;
import com.hust.bigdataplatform.model.ExperimentFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExperimentFileMapper {
    long countByExample(ExperimentFileExample example);

    int deleteByExample(ExperimentFileExample example);

    int deleteByPrimaryKey(@Param("experimentId") String experimentId, @Param("fileId") String fileId);

    int insert(ExperimentFile record);

    int insertSelective(ExperimentFile record);

    List<ExperimentFile> selectByExample(ExperimentFileExample example);

    int updateByExampleSelective(@Param("record") ExperimentFile record, @Param("example") ExperimentFileExample example);

    int updateByExample(@Param("record") ExperimentFile record, @Param("example") ExperimentFileExample example);
}