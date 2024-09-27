package com.jbk.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Entity.Student;

import com.jbk.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService service;
	
	
	@GetMapping("/get-all-students")
	public List<Student> getAllAtudent(Student student){
		List<Student> allDa =service.allData(student);
		return allDa;		
	}
	
	@PostMapping("/add-student")
	public String addStudent(@RequestBody Student student) {
		String msg = service.addStudent(student);
		return msg; 
		
	}
	
	@GetMapping("/get-student-by-id/{rollNo}")
	public Object getStudentById(@PathVariable Long rollNo) {
		Student student =service.getStudentbyid(rollNo);
		
	if(student!=null) {
		return student;
	}else {
		return"no exist";
	}
		
		
	}
	
	@PutMapping("/update-student/{rollNO}")
	public String updateStudent(@PathVariable long rollNo,@RequestBody Student student) {
		 String msg = service.updateStudent(rollNo,student);
		return msg;
	}
	
	@GetMapping("/delete-student/{rollNo}")
	public String deleteStudent(@PathVariable long rollNo) {
		String msg=service.deleteStudent(rollNo);
		return msg;
		
	}
}
