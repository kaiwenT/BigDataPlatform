package com.hust.bigdataplatform.constant;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
/**
 * 常量类
 *
 */
public class Constant {

    
	// 把config.properties中的变量值，赋给当前的变量
	private void init(){
		DIRECTORY.init(studentPhoto, teacherPhoto, coursePhoto, courseware, courseVideo, experimentVideo, experimentReport, experimentDataSubmit, reportSubmit);
	}
	// 学生头像存放文件夹
    @Value("${student_photo}")
    private String studentPhoto;
    // 教师头像存放文件夹
    @Value("${teacher_photo}")
    private String teacherPhoto;
    // 课程图片存放文件夹
    @Value("${course_photo}")
    private String coursePhoto;
    
	//课程课件存放文件夹
	@Value("${courseware}")
	private String courseware;
	
	// 课程视频存放文件夹
    @Value("${course_video}")
    private String courseVideo;
    
    //实验视频存放文件夹
    @Value("${experiment_video}")
    private String experimentVideo;
    
    //实验手册存放文件夹
    @Value("${experiment_report}")
    private String experimentReport;
    
    //学生提交实验报告存放文件夹
    @Value("${report_submit}")
    private String reportSubmit;
    
    //学生提交实验数据存放文件夹
    @Value("${experiment_data_submit}")
    private String experimentDataSubmit;
    
    
    /**
     * 
     * 文件系统目录常量
     *
     */
    public static class DIRECTORY {

    	/**
         * 学生头像目录
         */
        public static String STUDENT_PHOTO;
        /**
         * 教师头像目录
         */
        public static String TEACHER_PHOTO;
        /**
         * 课程图片目录
         */
        public static String COURSE_PHOTO;
    	/**
    	 * 课程课件目录
    	 */
        public static String COURSEWARE;
        /**
         * 课程视频目录
         */
        public static String COURSE_VIDEO;
        /**
         * 实验手册目录
         */
        public static String EXPERIMENT_REPORT;
        /**
         * 实验视频目录
         */
        public static String EXPERIMENT_VIDEO;
        /**
         * 学生提交的实验数据存放目录
         */
        public static String EXPERIMENT_DATA_SUBMIT;
        /**
         * 学生提交的实验报告存放目录
         */
        public static String REPORT_SUBMIT;
        
        public static void init(String studentPhoto, String teacherPhoto, String coursePhoto, String courseware, String courseVideo, String experimentReport, String experimentVideo, String experimentSubmit, String reportSubmit) {
        	STUDENT_PHOTO = studentPhoto;
        	TEACHER_PHOTO = teacherPhoto;
        	COURSE_PHOTO = coursePhoto;
        	COURSEWARE = courseware;
            COURSE_VIDEO = courseVideo;
            EXPERIMENT_REPORT = experimentReport;
            EXPERIMENT_VIDEO = experimentVideo;
            EXPERIMENT_DATA_SUBMIT = experimentSubmit;
            REPORT_SUBMIT = reportSubmit;
            
            //目录不存在就自动创建目录
            if(!new File(studentPhoto).exists()){
            	new File(studentPhoto).mkdirs();
            }
            if(!new File(teacherPhoto).exists()){
            	new File(teacherPhoto).mkdirs();
            }
            if(!new File(coursePhoto).exists()){
            	new File(coursePhoto).mkdirs();
            }
            if(!new File(courseVideo).exists()){
            	new File(courseVideo).mkdirs();
            }
            if(!new File(experimentReport).exists()){
            	new File(experimentReport).mkdirs();
            }
            if(!new File(experimentVideo).exists()){
            	new File(experimentVideo).mkdirs();
            }
            if(!new File(experimentSubmit).exists()){
            	new File(experimentSubmit).mkdirs();
            }
            if(!new File(reportSubmit).exists()){
            	new File(reportSubmit).mkdirs();
            }
        }
    }

}
