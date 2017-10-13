package com.hust.bigdataplatform.dao.mapper;

import com.hust.bigdataplatform.model.CourseChapter;
import com.hust.bigdataplatform.model.CourseChapterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseChapterMapper {
    long countByExample(CourseChapterExample example);

    int deleteByExample(CourseChapterExample example);

    int deleteByPrimaryKey(@Param("chapterId") String chapterId, @Param("courseId") String courseId);

    int insert(CourseChapter record);

    int insertSelective(CourseChapter record);

    List<CourseChapter> selectByExample(CourseChapterExample example);

    CourseChapter selectByPrimaryKey(@Param("chapterId") String chapterId, @Param("courseId") String courseId);

    int updateByExampleSelective(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);

    int updateByExample(@Param("record") CourseChapter record, @Param("example") CourseChapterExample example);

    int updateByPrimaryKeySelective(CourseChapter record);

    int updateByPrimaryKey(CourseChapter record);
}