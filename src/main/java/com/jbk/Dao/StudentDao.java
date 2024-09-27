package com.jbk.Dao;

import java.util.List;

import com.jbk.Entity.Student;

public interface StudentDao {
	
	public String addStudent(Student student) ;

	public List<Student> allData(Student student);

	public Student getStudentById(long rollNo);

	public String updateStudent(long rollNo,Student student);

	public String deleteStudent(long rollNo);

	public List<Student> getAllStudentByRoll(List<Long> list);
}
