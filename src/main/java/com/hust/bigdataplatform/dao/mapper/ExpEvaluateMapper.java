package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.ExpEvaluate;
import com.hust.bigdataplatform.model.ExpEvaluateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ExpEvaluateMapper {
    long countByExample(ExpEvaluateExample example);

    int deleteByExample(ExpEvaluateExample example);

    int deleteByPrimaryKey(@Param("experimentId") String experimentId, @Param("studentId") String studentId, @Param("evaluator") String evaluator);

    int insert(ExpEvaluate record);

    int insertSelective(ExpEvaluate record);

    List<ExpEvaluate> selectByExample(ExpEvaluateExample example);

    ExpEvaluate selectByPrimaryKey(@Param("experimentId") String experimentId, @Param("studentId") String studentId, @Param("evaluator") String evaluator);

    int updateByExampleSelective(@Param("record") ExpEvaluate record, @Param("example") ExpEvaluateExample example);

    int updateByExample(@Param("record") ExpEvaluate record, @Param("example") ExpEvaluateExample example);

    int updateByPrimaryKeySelective(ExpEvaluate record);

    int updateByPrimaryKey(ExpEvaluate record);
}