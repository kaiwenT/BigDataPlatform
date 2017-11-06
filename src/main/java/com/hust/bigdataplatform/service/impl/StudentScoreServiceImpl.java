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
import com.hust.bigdataplatform.model.params.ExpScore;
import com.hust.bigdataplatform.model.params.ExperimentScoreQuery;
import com.hust.bigdataplatform.service.CourseScaleService;
import com.hust.bigdataplatform.service.ExperimentScoreService;
import com.hust.bigdataplatform.service.StudentCourseService;
import com.hust.bigdataplatform.service.StudentScoreService;
import com.hust.bigdataplatform.service.StudentTaskService;
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
	@Autowired
	private StudentTaskService  studentTaskService;
	
	
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
	public int UpdateByStuIdAndCourseId(String stuId, String courseId) {
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
		return studentScoreDao.update(studentScore);
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
		if (students.size()==0||students==null) {
			return 0;
		}
		for (Student student : students) {
			if (studentScoreDao.findByStuIdAndCourseId(student.getStudentId(), courseId)==null) {
				StudentScore studentScore = new StudentScore();
				studentScore.setCourseId(courseId);
				studentScore.setStudentId(student.getStudentId());
				int i = 0;
				studentScore.setExpFinalscore(i);
				studentScore.setFinalscore(i);
				studentScore.setTestResults(i);
				studentScore.setUsualgrades(i);
				int s= studentScoreDao.add(studentScore);
				if (s==0) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * 导出所有成绩
	 */
	@Override
	public List<List<String>> GetAllScore(String courseId) {
		List<Map<String, String>> result1= studentTaskService.ShowUsualScore(courseId);
		List<ExperimentScoreQuery> result2 = experimentScoreService.ShowExpScore(courseId);
		List<Map<String, String>> result3=ShowStudentFinalScore(courseId);
		//处理Excel属性行
		//平时成绩属性列
		List<String> title = new ArrayList<String>();
		title.add("学号");
		title.add("姓名");
		int num = Integer.parseInt(result1.get(0).get("tasknum"));
		for(int i=0; i<num; i++)
		{
			title.add("平时作业"+(i+1));
		}
		title.add("考勤成绩");
		title.add("平时总成绩");
		//实验属性列
		List<ExpScore> expScores = result2.get(0).getExplist();
		for(int i = 0; i < expScores.size();i++)
		{
			title.add(expScores.get(i).getExpName()+"(数据)");
			title.add(expScores.get(i).getExpName()+"(报告)");
			title.add(expScores.get(i).getExpName()+"(总)");
		}
		title.add("实验总成绩");
		title.add("考试成绩");
		title.add("最终成绩");
		//成绩
		List<List<String>> result = new ArrayList<List<String>>();
		result.add(title);
		for (int i = 0; i < result1.size(); i++) {  //同时遍历三个分数结果
			List<String> list = new ArrayList<String>();
			list.add(result1.get(i).get("studentId"));
			list.add(result1.get(i).get("studentname"));
			//平时成绩
			for(String key:result1.get(i).keySet())
			{
				if (key!="studentId"&&key!="studentname"&&key!="tasknum"&&key!="attendenceScore"&&key!="finalUsualScore") {
					list.add(result1.get(i).get(key));
				}
			}
			list.add(result1.get(i).get("attendenceScore"));
			list.add(result1.get(i).get("finalUsualScore"));
			//实验成绩
			expScores = result2.get(i).getExplist();
			for( int j = 0; j < expScores.size();j++)
			{
				list.add(expScores.get(j).getResultsScore());
				list.add(expScores.get(j).getReportScore());
				list.add(expScores.get(j).getFinalScore());
			}
			list.add(result2.get(i).getFinalScore()); //实验总成绩
			//考试成绩
			list.add(result3.get(i).get("test_results"));
			//最终成绩
			list.add(result3.get(i).get("finalScore"));
			result.add(list);
		}
		return result;
	}
	
}
