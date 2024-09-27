package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.jbk.Dao.StudentDao;
import com.jbk.Entity.Student;

@Service
public class StudentServiceimpl implements StudentService {

	@Autowired
	private StudentDao dao;

	@Override
	public String addStudent(Student student) {

		String msg = dao.addStudent(student);
		return msg;
	}

	@Override
	@GetMapping
	public List<Student> allData(Student student) {
		List<Student> alldata = dao.allData(student);
		return alldata;
	}

	@Override
	public String updateStudent(long rollNo, Student student) {

		return dao.updateStudent(rollNo, student);
	}

	@Override
	public String deleteStudent(long rollNo) {

		return dao.deleteStudent(rollNo);
	}

	@Override
	public Student getStudentbyid(long rollNo) {
		Student student = dao.getStudentById(rollNo);
		return student;
	}

	@Override
	public List<Student> getAllStudentbyRoll(List<Long> list) {
		
		List<Student> student =dao.getAllStudentByRoll(list);
		return student;
	}

}
