package com.hust.bigdataplatform.service;

import java.util.List;
import com.hust.bigdataplatform.model.Student;


public interface StudentService {
	public List<Student> selectAllStudents(int start, int limit);
}
