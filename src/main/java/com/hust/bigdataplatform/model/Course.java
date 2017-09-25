package com.hust.bigdataplatform.model;

import java.util.Date;

public class Course {
    private String courseId;

    private String courseName;

    private Date courseBegintime;

    private Integer courseCredit;

    private String coursePath;

    private Float courseUsualgradesscale;

    private String courseVideopath;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public Date getCourseBegintime() {
        return courseBegintime;
    }

    public void setCourseBegintime(Date courseBegintime) {
        this.courseBegintime = courseBegintime;
    }

    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    public String getCoursePath() {
        return coursePath;
    }

    public void setCoursePath(String coursePath) {
        this.coursePath = coursePath == null ? null : coursePath.trim();
    }

    public Float getCourseUsualgradesscale() {
        return courseUsualgradesscale;
    }

    public void setCourseUsualgradesscale(Float courseUsualgradesscale) {
        this.courseUsualgradesscale = courseUsualgradesscale;
    }

    public String getCourseVideopath() {
        return courseVideopath;
    }

    public void setCourseVideopath(String courseVideopath) {
        this.courseVideopath = courseVideopath == null ? null : courseVideopath.trim();
    }
}