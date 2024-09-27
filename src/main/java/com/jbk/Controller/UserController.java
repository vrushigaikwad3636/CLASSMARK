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
import com.jbk.Entity.User;

import com.jbk.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService service;
	
	
	@GetMapping("/get-all-user")
	public List<User> getAllUser(User user){
		List<User> allDa =service.getAllUser(user);
		return allDa;		
	}
	
	@PostMapping("/add-user")
	public String addUser(@RequestBody User user) {
		String msg = service.addUser(user);
		return msg; 
		
	}
	
	@GetMapping("/get-student-by-id/{userName}")
	public Object getUserByid(@PathVariable String userName) {
		User user =service.getUserById(userName);
		
	if(user!=null) {
		return user;
	}else {
		return"no exist";
	}
		
		
	}
	
	@PutMapping("/update-User/{userName}")
	public String updateUser(@PathVariable String userName,@RequestBody User user) {
		 String msg = service.updateUser(userName,user);
		return msg;
	}
	
	@GetMapping("/delete-student/{userName}")
	public String deleteStudent(@PathVariable String userName) {
		String msg=service.deleteUser(userName);
		return msg;
		
	}
}



