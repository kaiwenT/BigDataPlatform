package com.hust.bigdataplatform.model.params;

import java.util.List;

public class ExperimentScoreQuery {
	
	String studentId;
	String studentName;
	List<ExpScore> explist;
	String  Overallresult;
	
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public List<ExpScore> getExplist() {
		return explist;
	}
	public void setExplist(List<ExpScore> explist) {
		this.explist = explist;
	}
	public String getFinalScore() {
		return Overallresult;
	}
	public void setFinalScore(String Overallresult) {
		this.Overallresult = Overallresult;
	}

	
}
