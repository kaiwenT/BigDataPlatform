package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.CourseChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterMapper {
    long countByExample(CourseChapterExample example);

    int deleteByExample(CourseChapterExample example);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);

    List<CourseChapter> selectByExample(CourseChapterExample example);

    int updateByExampleSelective(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);

    int updateByExample(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);
}