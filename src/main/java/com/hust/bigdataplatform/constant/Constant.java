package com.hust.bigdataplatform.constant;

import org.springframework.beans.factory.annotation.Value;
/**
 * 常量类
 *
 */
public class Constant {

    
	// 把config.properties中的变量值，赋给当前的变量
	private void init(){
		DIRECTORY.init(courseware, courseVideo, taskCourseware, taskVideo, taskSubmit);
	}
	//课程课件路径
	@Value("${courseware}")
	private String courseware;
	
	// 课程视频路径
    @Value("${course_video}")
    private String courseVideo;
    
    //作业视频
    @Value("${task_video}")
    private String taskVideo;
    
    //学生提交作业保存路径
    @Value("${task_submit}")
    private String taskSubmit;
    
    //作业要求
    @Value("${task_courseware}")
    private String taskCourseware;
    
    /**
     * 
     * 文件系统目录常量
     *
     */
    public static class DIRECTORY {

    	/**
    	 * 课程课件目录
    	 */
        public static String COURSEWARE;
        /**
         * 课程视频目录
         */
        public static String COURSE_VIDEO;
        /**
         * 作业要求目录
         */
        public static String TASK_COURSEWARE;
        /**
         * 作业视频目录
         */
        public static String TASK_VIDEO;
        /**
         * 学生提交的作业存放目录
         */
        public static String TASK_SUBMIT;
        
        public static void init(String courseware, String course_video, String task_courseware, String task_video, String task_submit) {
            COURSEWARE = courseware;
            COURSE_VIDEO = course_video;
            TASK_COURSEWARE = task_courseware;
            TASK_VIDEO = task_video;
            TASK_SUBMIT = task_submit;
        }
    }

}
