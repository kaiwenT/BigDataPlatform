package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.ChapterSection;
import com.hust.bigdataplatform.model.ChapterSectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChapterSectionMapper {
    long countByExample(ChapterSectionExample example);

    int deleteByExample(ChapterSectionExample example);

    int deleteByPrimaryKey(String sectionid);

    int insert(ChapterSection record);

    int insertSelective(ChapterSection record);

    List<ChapterSection> selectByExample(ChapterSectionExample example);

    ChapterSection selectByPrimaryKey(String sectionid);

    int updateByExampleSelective(@Param("record") ChapterSection record, @Param("example") ChapterSectionExample example);

    int updateByExample(@Param("record") ChapterSection record, @Param("example") ChapterSectionExample example);

    int updateByPrimaryKeySelective(ChapterSection record);

    int updateByPrimaryKey(ChapterSection record);
}