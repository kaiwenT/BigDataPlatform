package com.hust.bigdataplatform.model;

import java.util.Date;

public class Course {
    private String courseId;

    private String courseName;

    private String courseIntroduce;

    private String courseOutline;

    private String courseDemand;

    private Date courseBegintime;

    private Integer courseCredit;

    private String courseCoursewarepath;

    private String courseVideopath;

    private Float courseUsualgradesscale;

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

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce == null ? null : courseIntroduce.trim();
    }

    public String getCourseOutline() {
        return courseOutline;
    }

    public void setCourseOutline(String courseOutline) {
        this.courseOutline = courseOutline == null ? null : courseOutline.trim();
    }

    public String getCourseDemand() {
        return courseDemand;
    }

    public void setCourseDemand(String courseDemand) {
        this.courseDemand = courseDemand == null ? null : courseDemand.trim();
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

    public String getCourseCoursewarepath() {
        return courseCoursewarepath;
    }

    public void setCourseCoursewarepath(String courseCoursewarepath) {
        this.courseCoursewarepath = courseCoursewarepath == null ? null : courseCoursewarepath.trim();
    }

    public String getCourseVideopath() {
        return courseVideopath;
    }

    public void setCourseVideopath(String courseVideopath) {
        this.courseVideopath = courseVideopath == null ? null : courseVideopath.trim();
    }

    public Float getCourseUsualgradesscale() {
        return courseUsualgradesscale;
    }

    public void setCourseUsualgradesscale(Float courseUsualgradesscale) {
        this.courseUsualgradesscale = courseUsualgradesscale;
    }
}