package com.jbk.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Entity.Attendance;

@Repository
public class AttendanceDaoimpl implements AttendaceDao {

	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public String takeAttendanc(Attendance attendance) {

		Session session=null;
		String msg = null;
		
		try {
			session=factory.openSession();
			session.save(attendance);
			session.beginTransaction().commit();
			msg="Attendance Submited";
			
		} catch (Exception e) {
			e.printStackTrace();
			msg="sumething want worng during submit attendance ";
		}
		finally{
		session.close();
		}
		
		
		return msg;
	}

}
