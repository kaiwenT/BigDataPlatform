package com.hust.bigdataplatform.model;

public class ExpEvaluate {
    private String experimentId;

    private String studentId;

    private String evaluator;

    private Integer evaluatesore;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId == null ? null : experimentId.trim();
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator == null ? null : evaluator.trim();
    }

    public Integer getEvaluatesore() {
        return evaluatesore;
    }

    public void setEvaluatesore(Integer evaluatesore) {
        this.evaluatesore = evaluatesore;
    }
}