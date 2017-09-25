package com.hust.bigdataplatform.model;

public class StudentCourse {
    private String studentId;

    private String courseId;

    private Float courseTotalscore;

    private Integer attendancerate;

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

    public Float getCourseTotalscore() {
        return courseTotalscore;
    }

    public void setCourseTotalscore(Float courseTotalscore) {
        this.courseTotalscore = courseTotalscore;
    }

    public Integer getAttendancerate() {
        return attendancerate;
    }

    public void setAttendancerate(Integer attendancerate) {
        this.attendancerate = attendancerate;
    }
}