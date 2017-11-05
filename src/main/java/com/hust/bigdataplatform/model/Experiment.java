package com.hust.bigdataplatform.model;

import java.util.Date;

public class Experiment {
    private String experimentId;

    private String courseId;

    private String experimentName;

    private Date experimentCreatetime;

    private Date experimentDeadline;

    private String experimentSubmitdemand;

    private Float experimentScale;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId == null ? null : experimentId.trim();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getExperimentName() {
        return experimentName;
    }

    public void setExperimentName(String experimentName) {
        this.experimentName = experimentName == null ? null : experimentName.trim();
    }

    public Date getExperimentCreatetime() {
        return experimentCreatetime;
    }

    public void setExperimentCreatetime(Date experimentCreatetime) {
        this.experimentCreatetime = experimentCreatetime;
    }

    public Date getExperimentDeadline() {
        return experimentDeadline;
    }

    public void setExperimentDeadline(Date experimentDeadline) {
        this.experimentDeadline = experimentDeadline;
    }

    public String getExperimentSubmitdemand() {
        return experimentSubmitdemand;
    }

    public void setExperimentSubmitdemand(String experimentSubmitdemand) {
        this.experimentSubmitdemand = experimentSubmitdemand == null ? null : experimentSubmitdemand.trim();
    }

    public Float getExperimentScale() {
        return experimentScale;
    }

    public void setExperimentScale(Float experimentScale) {
        this.experimentScale = experimentScale;
    }
}