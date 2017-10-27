package com.hust.bigdataplatform.service;

import com.hust.bigdataplatform.model.CourseScale;

public interface CourseScaleService {

	/**
	 * 查找评分标准
	 * @param courseId
	 * @return
	 */
	public CourseScale findByCourseId(String courseId);
	/**
	 * 删除评分标准
	 * @param courseId
	 * @return
	 */
	public int delete(String courseId);
	/**
	 * 更新评分标准
	 * @param record
	 * @return
	 */
	public int update(CourseScale record);
	/**
	 * 添加一个课程评分标准
	 * @param record
	 * @return
	 */
	public int add(CourseScale record);
	
}
