package com.hust.bigdataplatform.model;

public class Teacher {
    private String teacherId;

    private String teacherName;

    private String teacherPwd;

    private String teacherPhone;

    private String techerPicturepath;

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId == null ? null : teacherId.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd == null ? null : teacherPwd.trim();
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone == null ? null : teacherPhone.trim();
    }

    public String getTecherPicturepath() {
        return techerPicturepath;
    }

    public void setTecherPicturepath(String techerPicturepath) {
        this.techerPicturepath = techerPicturepath == null ? null : techerPicturepath.trim();
    }
}