package com.hust.bigdataplatform.model;

public class CourseScale {
    private String courseId;

    private Float attendanceRate;

    private Float exerciseRate;

    private Float experimentRate;

    private Float expReportRate;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public Float getAttendanceRate() {
        return attendanceRate;
    }

    public void setAttendanceRate(Float attendanceRate) {
        this.attendanceRate = attendanceRate;
    }

    public Float getExerciseRate() {
        return exerciseRate;
    }

    public void setExerciseRate(Float exerciseRate) {
        this.exerciseRate = exerciseRate;
    }

    public Float getExperimentRate() {
        return experimentRate;
    }

    public void setExperimentRate(Float experimentRate) {
        this.experimentRate = experimentRate;
    }

    public Float getExpReportRate() {
        return expReportRate;
    }

    public void setExpReportRate(Float expReportRate) {
        this.expReportRate = expReportRate;
    }
}