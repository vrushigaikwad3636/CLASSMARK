package com.jbk.Dao;

import java.util.List;

import com.jbk.Entity.Student;
import com.jbk.Entity.User;

public interface Userdao {

	public List<User> getAllSubject(User user);

	public String addUser(User user);

	public String updateUser(String userName, User user);

	public String deleteUser(String userName);

	public User getUserById(String userName);

	

}
