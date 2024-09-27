package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.SubjectDao;
import com.jbk.Entity.Subject;

@Service
public class SubjectServiceimpl implements SubjectService {

	@Autowired
	private SubjectDao dao;
	
	@Override
	public List<Subject> getAllSubject(Subject subject) {
		List<Subject> allData=dao.getAllSubject(subject);
		return allData;
	}

	@Override
	public String addSubject(Subject subject) {
		
		return dao.addSubject(subject);
	}

	@Override
	public Subject getSubjectById(long id) {
		
		return dao.getSubjecctById(id);
	}

	@Override
	public String updateSubject(long id, Subject subject) {
		
		return dao.updateSubject(id,subject);
	}

	@Override
	public String deleteSubject(long id) {
		
		return dao.deleteSubject(id);
	}

}
