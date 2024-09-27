package com.jbk.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Entity.Student;
import com.jbk.Entity.Subject;

@Repository
public class subjectDaoimpl implements SubjectDao {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Subject> getAllSubject(Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Student.class);
			criteria.addOrder(Order.asc("id"));
			List list = criteria.list();

			return list;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;

	}

	@Override
	public String addSubject(Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			session.save(subject);
			session.beginTransaction().commit();
			return "data added";

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Subject getSubjecctById(long id) {
		Session session = null;

		try {
			session = factory.openSession();
			return session.get(Subject.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String updateSubject(long id, Subject subject) {
		Session session = null;
		try {
			session = factory.openSession();
			Subject subject1 = session.get(Subject.class, id);
			if (subject1 != null) {
				subject1.setCode(subject.getCode());
				subject1.setName(subject.getName());
				session.update(subject1);
				;
				return "Subject is succesfully";

			} else {
				return "subject not found";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public String deleteSubject(long id) {
		Session session = null;
		try {
			session = factory.openSession();
			Subject subject1 = session.get(Subject.class, id);

			if (subject1 != null) {
				session.delete(subject1);
				session.beginTransaction().commit();
				return "Subject deleted successfully";
			} else {
				return "Subject not found";
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}