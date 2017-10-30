package com.hust.bigdataplatform.model;

public class StudentScore {
    private String studentId;

    private String courseId;

    private Integer usualgrades;

    private Integer expFinalscore;

    private Integer testResults;

    private Integer finalscore;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Integer getUsualgrades() {
        return usualgrades;
    }

    public void setUsualgrades(Integer usualgrades) {
        this.usualgrades = usualgrades;
    }

    public Integer getExpFinalscore() {
        return expFinalscore;
    }

    public void setExpFinalscore(Integer expFinalscore) {
        this.expFinalscore = expFinalscore;
    }

    public Integer getTestResults() {
        return testResults;
    }

    public void setTestResults(Integer testResults) {
        this.testResults = testResults;
    }

    public Integer getFinalscore() {
        return finalscore;
    }

    public void setFinalscore(Integer finalscore) {
        this.finalscore = finalscore;
    }
}