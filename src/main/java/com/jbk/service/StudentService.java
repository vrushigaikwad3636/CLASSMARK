package com.jbk.service;

import java.util.List;

import com.jbk.Entity.Student;

public interface StudentService {
	
	public String addStudent(Student student) ;
	
	public List<Student> allData(Student student);

	public Student getStudentbyid(long rollNo);

	public String updateStudent(long rollNo,Student student);

	public String deleteStudent(long rollNo);
		
	
	public List<Student> getAllStudentbyRoll(List<Long> list);
	}