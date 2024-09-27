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
import com.jbk.Entity.Subject;
import com.jbk.service.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController {
	
	@Autowired
	private SubjectService service;

	@GetMapping("/get-all-subject")
	public List<Subject> getAllSubject(Subject subject){
		List<Subject> allData=service.getAllSubject(subject);
		return allData;
		
		
	}
	
	@PostMapping("/add-subject")
	public String addSubject(@RequestBody Subject subject) {
		String msg= service.addSubject(subject);
		return msg;
		
		
	}
	
	@GetMapping("/get-subject-by-id/{id}")
	public Object getSubjectById(@PathVariable long id ) {
		
		Subject subjecct=service.getSubjectById(id);
		if(subjecct!=null) {
			return subjecct;
		}else {
		return "no exist" ;
		}
		
	}
	
	@PutMapping("/update-subject/{id}")
	public String updateSubject(@PathVariable long id,@RequestBody Subject subject) {
		 String msg = service.updateSubject(id,subject);
		return msg;
	}
	
	@GetMapping("/delete-subject/{id}")
	public String deleteSubject(@PathVariable long id) {
		String msg=service.deleteSubject(id);
		return msg;
		
	}

}
