package com.jbk.Dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Entity.Student;


@Repository
public class StudentDaoimpl implements StudentDao {

	
	@Autowired
	private  SessionFactory factory;
	
	@Override
	public String addStudent(Student student) {
		
		Session session=null;
		try {
			session=factory.openSession();
			session.save(student);
			session.beginTransaction().commit();
			return "data added";
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	
	}

	@Override
	public List<Student> allData(Student student) {
	Session session=null;
	try {
	session=factory.openSession();
	Criteria criteria = session.createCriteria(Student.class);
	criteria.addOrder(Order.asc("rollNo"));
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
	public Student getStudentById(long rollNo) {
		Session session=null;
		
		try {
			session=factory.openSession();
			return session.get(Student.class, rollNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public String updateStudent(long rollNo, Student student) {
		Session session=null;
		
		try {
			session=factory.openSession();
			Student student1 = session.get(Student.class, rollNo);
			
			if(student1!=null) {
				//update the new fields with new value
				student1.setFirstName(student.getFirstName());
				student1.setLastName(student .getLastName());
				student1.setEmail(student.getEmail());
				student1.setPhoneNumber(student.getPhoneNumber());
				student1.setAddress(student.getAddress());
				student1.setDateOfBirth(student.getDateOfBirth());
				student1.setDepartment(student.getDepartment());
				student1.setGender(student.getGender());
				student1.setStudentId(student.getStudentId());
				student1.setClassName(student.getClassName());
				
				session.update(student1);
				session.beginTransaction().commit();
				return"Student is succesfully";
			}
			else {
				return"student not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public String deleteStudent(long rollNo) {
		Session session=null;
		try {
			session=factory.openSession();
			Student student1 = session.get(Student.class, rollNo);
			
			if(student1!=null) {
				session.delete(student1);
				session.beginTransaction().commit();
				return"Student deleted successfully";
			}
			else {
				return"Student not found";
			}
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudentByRoll(List<Long> list) {

		Session session=null;
		List<Student> studentlist=null;
		try {
			session=factory.openSession();
			studentlist=session.byMultipleIds(Student.class).multiLoad(list);
		} catch (Exception e) {
			e.printStackTrace();		}
		
	finally {
		session.close();
	}
		return studentlist;
	}
	
	
	

}
