package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.SubjectDao;
import com.jbk.Dao.Userdao;
import com.jbk.Entity.Student;
import com.jbk.Entity.Subject;
import com.jbk.Entity.User;

@Service
public class Userserviceimpl implements UserService {

	@Autowired
	private Userdao dao;

	@Override
	public List<User> getAllUser(User user) {
		List<User> allData=dao.getAllSubject(user);
		return allData;
	}

	@Override
	public String addUser(User user) {
		return dao.addUser(user);
	}

	@Override
	public User getUserById(String userName) {
		return dao.getUserById(userName);
	}

	@Override
	public String updateUser(String userName, User user) {
		return dao.updateUser(userName,user);
	}

	@Override
	public String deleteUser(String userName) {
		
		return dao.deleteUser(userName);
	}
	
	

}
