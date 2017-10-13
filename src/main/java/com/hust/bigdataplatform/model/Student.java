package com.hust.bigdataplatform.model;

public class Student {
    private String studentId;

    private String studentName;

    private String studentPwd;

    private String studentFaculty;

    private String studentTele;

    private String studentPicturepath;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }

    public String getStudentPwd() {
        return studentPwd;
    }

    public void setStudentPwd(String studentPwd) {
        this.studentPwd = studentPwd == null ? null : studentPwd.trim();
    }

    public String getStudentFaculty() {
        return studentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        this.studentFaculty = studentFaculty == null ? null : studentFaculty.trim();
    }

    public String getStudentTele() {
        return studentTele;
    }

    public void setStudentTele(String studentTele) {
        this.studentTele = studentTele == null ? null : studentTele.trim();
    }

    public String getStudentPicturepath() {
        return studentPicturepath;
    }

    public void setStudentPicturepath(String studentPicturepath) {
        this.studentPicturepath = studentPicturepath == null ? null : studentPicturepath.trim();
    }
}