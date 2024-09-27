package com.jbk.service;

import java.util.List;

import com.jbk.Entity.Subject;

public interface SubjectService {

	public List<Subject> getAllSubject(Subject subject);

	public String addSubject(Subject subject);

	public Subject getSubjectById(long id);

	public String updateSubject(long id, Subject subject);

	public String deleteSubject(long id);

	

}
