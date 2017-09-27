package com.hust.bigdataplatform.model;

import java.io.Serializable;
import java.util.Date;

public class Experiment implements Serializable{
    private String experimentId;

    private String courseId;

    private String experimentName;

    private Date experimentDeadline;

    private String experimentSubmitdemand;

    private String experimentManualpath;

    private String experimentResultspath;

    private String experimentReportpath;

    private String experimentVideopath;

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

    public String getExperimentManualpath() {
        return experimentManualpath;
    }

    public void setExperimentManualpath(String experimentManualpath) {
        this.experimentManualpath = experimentManualpath == null ? null : experimentManualpath.trim();
    }

    public String getExperimentResultspath() {
        return experimentResultspath;
    }

    public void setExperimentResultspath(String experimentResultspath) {
        this.experimentResultspath = experimentResultspath == null ? null : experimentResultspath.trim();
    }

    public String getExperimentReportpath() {
        return experimentReportpath;
    }

    public void setExperimentReportpath(String experimentReportpath) {
        this.experimentReportpath = experimentReportpath == null ? null : experimentReportpath.trim();
    }

    public String getExperimentVideopath() {
        return experimentVideopath;
    }

    public void setExperimentVideopath(String experimentVideopath) {
        this.experimentVideopath = experimentVideopath == null ? null : experimentVideopath.trim();
    }

    public Float getExperimentScale() {
        return experimentScale;
    }

    public void setExperimentScale(Float experimentScale) {
        this.experimentScale = experimentScale;
    }
}