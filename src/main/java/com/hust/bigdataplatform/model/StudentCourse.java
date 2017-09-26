package com.hust.bigdataplatform.model;

public class StudentCourse {
    private String studentId;

    private String courseId;

    private Integer attendancerate;

    private Integer finalresult;

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

    public Integer getAttendancerate() {
        return attendancerate;
    }

    public void setAttendancerate(Integer attendancerate) {
        this.attendancerate = attendancerate;
    }

    public Integer getFinalresult() {
        return finalresult;
    }

    public void setFinalresult(Integer finalresult) {
        this.finalresult = finalresult;
    }
}