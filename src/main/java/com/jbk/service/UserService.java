package com.jbk.service;

import java.util.List;

import com.jbk.Entity.Student;
import com.jbk.Entity.User;

public interface UserService {

	public List<User> getAllUser(User user);

	public String addUser(User user);

	public User getUserById(String userName);

	public String updateUser(String userName, User user);

	public String deleteUser(String userName);
	
	

}
