package com.jbk.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Entity.Student;
import com.jbk.Entity.User;

@Repository
public class UserDaoimpl implements Userdao {

	@Autowired
	private SessionFactory  factory;
	@Override
	public List<User> getAllSubject(User user) {
		Session session=null;
		try {
		session=factory.openSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.addOrder(Order.asc("userName"));
		List list = criteria.list();
		
		return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public String addUser(User user) {
		Session session=null;
		
		try {
			session=factory.openSession();
			session.save(user);
			session.beginTransaction().commit();
			return"data added";
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public String updateUser(String userName, User user) {

		Session session=null;
		try {
			session=factory.openSession();
			User user2 = session.get(User.class, userName);
			if(user2!=null) {
				user2.setFirstName(user.getFirstName());
				user2.setLastName(user.getLastName());
				user2.setEmail(user.getEmail());
				user2.setPassword(user.getPassword());
				user2.setMobile(user.getMobile());
				user2.setUserName(user.getUserName());
				
				session.update(user2);
				session.beginTransaction().commit();
				return"User is update";
				
			}
			else {
				return"user is not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteUser(String userName) {

		Session session=null;
		
		try {
			session=factory.openSession();
			User user2 = session.get(User.class, userName);
			if(user2!=null) {
			session.delete(user2);
			session.beginTransaction().commit();
			return"user deleted successfully";
			
		}
		else {
			return"user not found";
			
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public User getUserById(String userName) {
		Session session=null;
		try {
			session=factory.openSession();
			session.get(User.class, userName);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
