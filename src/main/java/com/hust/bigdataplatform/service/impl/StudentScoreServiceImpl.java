package com.hust.bigdataplatform.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hust.bigdataplatform.dao.StudentScoreDao;
import com.hust.bigdataplatform.model.Student;
import com.hust.bigdataplatform.model.StudentScore;
import com.hust.bigdataplatform.service.CourseScaleService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentScoreService;
@Service
public class StudentScoreServiceImpl implements StudentScoreService {

	@Autowired
	private StudentScoreDao studentScoreDao;
	@Autowired
	private StudentCourseService studentCourseService;
	@Autowired
	private ExperimentScoreService experimentScoreService;
	@Autowired
	private CourseScaleService courseScaleService;
	
	@Override
	public StudentScore findByStuIdAndCourseId(String stuId, String courseId) {
		if (stuId==null||stuId.equals("")||courseId==null||courseId.equals("")) {
			return null;
		}
		return studentScoreDao.findByStuIdAndCourseId(stuId, courseId);
	}

	@Override
	public int add(StudentScore studentScore) {
		if (studentScore==null) {
			return 0;
		}
		return studentScoreDao.add(studentScore);
	}

	@Override
	public int update(StudentScore studentScore) {
		if (studentScore==null) {
			return 0;
		}
		return studentScoreDao.update(studentScore);
	}

	/**
	 * 插入成绩
	 */
	@Override
	public int addByStuIdAndCourseId(String stuId, String courseId) {
		if (stuId==null||stuId.equals("")||courseId==null||courseId.equals("")) {
			return 0;
		}
		int usualScore = studentCourseService.getFinalUsualScore(stuId, courseId);
		int expScore = experimentScoreService.findExpAvgScore(stuId, courseId);
		int testScore = studentScoreDao.findByStuIdAndCourseId(stuId, courseId).getTestResults();
		float usualRate = courseScaleService.findByCourseId(courseId).getAttendanceRate();
		float expRate = courseScaleService.findByCourseId(courseId).getExperimentRate();
		int score = (int) (usualScore*usualRate+expScore*expRate+testScore*(1-expRate-usualRate));
		
		StudentScore studentScore = new StudentScore();
		studentScore.setCourseId(courseId);
		studentScore.setExpFinalscore(expScore);
		studentScore.setFinalscore(score);
		studentScore.setStudentId(stuId);
		studentScore.setTestResults(testScore);
		studentScore.setUsualgrades(usualScore);
		return studentScoreDao.add(studentScore);
	}

	/**
	 * 显示总成绩：平时总成绩、 实验总成绩、考试成绩、最后成绩
	 */
	@Override
	public List<Map<String, String>> ShowStudentFinalScore(String courseId) {
		List<Student> students = studentCourseService.findBycourseId(courseId);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		for (Student student : students) {
			Map<String, String> map = new HashMap<>();
			StudentScore studentScore = studentScoreDao.findByStuIdAndCourseId(student.getStudentId(), courseId);
			map.put("studentId", student.getStudentId());
			map.put("studentname", student.getStudentName());
			map.put("usualGrades", String.valueOf(studentScore.getUsualgrades()));
			map.put("exp_finalScore",  String.valueOf(studentScore.getExpFinalscore()));
			map.put("test_results", String.valueOf(studentScore.getTestResults()));
			map.put("finalScore", String.valueOf(studentScore.getFinalscore()));
			list.add(map);
		}
		return list;
	}

	@Override
	public int insert(List<Student> students, String courseId) {
		if (students.size()==0||students==null||courseId=="") {
			return 0;
		}
		for (Student student : students) {
			StudentScore studentScore = new StudentScore();
			studentScore.setCourseId(courseId);
			studentScore.setStudentId(student.getStudentId());
			int s= studentScoreDao.add(studentScore);
			if (s==0) {
				return 0;
			}
		}
		return 1;
	}
	

}
