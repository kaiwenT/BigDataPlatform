package com.hust.bigdataplatform.model;

import java.util.Date;

public class Task {
    private String taskId;

    private String courseId;

    private String taskName;

    private Date taskDeadline;

    private String taskCoursewarepath;

    private String taskSubmitpath;

    private String taskVideopath;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public String getTaskCoursewarepath() {
        return taskCoursewarepath;
    }

    public void setTaskCoursewarepath(String taskCoursewarepath) {
        this.taskCoursewarepath = taskCoursewarepath == null ? null : taskCoursewarepath.trim();
    }

    public String getTaskSubmitpath() {
        return taskSubmitpath;
    }

    public void setTaskSubmitpath(String taskSubmitpath) {
        this.taskSubmitpath = taskSubmitpath == null ? null : taskSubmitpath.trim();
    }

    public String getTaskVideopath() {
        return taskVideopath;
    }

    public void setTaskVideopath(String taskVideopath) {
        this.taskVideopath = taskVideopath == null ? null : taskVideopath.trim();
    }
}