package com.hust.bigdataplatform.model;

public class TaskScore {
    private String studentId;

    private String taskId;

    private Integer taskscore;

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

    public Integer getTaskscore() {
        return taskscore;
    }

    public void setTaskscore(Integer taskscore) {
        this.taskscore = taskscore;
    }
}