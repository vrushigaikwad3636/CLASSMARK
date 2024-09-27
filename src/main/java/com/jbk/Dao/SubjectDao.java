package com.jbk.Dao;

import java.util.List;

import com.jbk.Entity.Subject;

public interface SubjectDao {

	public List<Subject> getAllSubject(Subject subject);

	public String addSubject(Subject subject);

	public Subject getSubjecctById(long id);

	public String updateSubject(long id, Subject subject);

	public String deleteSubject(long id);

}
