package com.hust.bigdataplatform.model;

import java.util.Date;

public class CourseChapter {
    private String chapterId;

    private String courseId;

    private String chapterName;

    private String coursewarePath;

    private String videoPath;

    private Date creatTime;

    public String getChapterId() {
        return chapterId;
    }

    public void setChapterId(String chapterId) {
        this.chapterId = chapterId == null ? null : chapterId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public String getCoursewarePath() {
        return coursewarePath;
    }

    public void setCoursewarePath(String coursewarePath) {
        this.coursewarePath = coursewarePath == null ? null : coursewarePath.trim();
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath == null ? null : videoPath.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}