package com.hust.bigdataplatform.model;

public class StudentTask {
    private String studentId;

    private String taskId;

    private Integer taskScore;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    public Integer getTaskScore() {
        return taskScore;
    }

    public void setTaskScore(Integer taskScore) {
        this.taskScore = taskScore;
    }
}