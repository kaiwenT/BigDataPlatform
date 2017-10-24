package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.SectionFile;
import com.hust.bigdataplatform.model.SectionFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SectionFileMapper {
    long countByExample(SectionFileExample example);

    int deleteByExample(SectionFileExample example);

    int deleteByPrimaryKey(@Param("sectionid") String sectionid, @Param("fileid") String fileid);

    int insert(SectionFile record);

    int insertSelective(SectionFile record);

    List<SectionFile> selectByExample(SectionFileExample example);

    int updateByExampleSelective(@Param("record") SectionFile record, @Param("example") SectionFileExample example);

    int updateByExample(@Param("record") SectionFile record, @Param("example") SectionFileExample example);
}