package com.hust.bigdataplatform.model;

public class ExperimentScore {
    private String studentId;

    private String experimentId;

    private Integer resultsscore;

    private Integer reportscore;

    private Integer expFinalscore;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId == null ? null : experimentId.trim();
    }

    public Integer getResultsscore() {
        return resultsscore;
    }

    public void setResultsscore(Integer resultsscore) {
        this.resultsscore = resultsscore;
    }

    public Integer getReportscore() {
        return reportscore;
    }

    public void setReportscore(Integer reportscore) {
        this.reportscore = reportscore;
    }

    public Integer getExpFinalscore() {
        return expFinalscore;
    }

    public void setExpFinalscore(Integer expFinalscore) {
        this.expFinalscore = expFinalscore;
    }
}