package com.jbk.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.Dao.AttendaceDao;
import com.jbk.Entity.Attendance;
import com.jbk.model.AttendanceDto;

@Service
public class AttendanceServiceimpl implements AttandanceSrvice {

	
	@Autowired
	private SubjectService subjectservice;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private AttendaceDao dao;
	@Override
	public String takeAttendanc(AttendanceDto attendanceDto) {
		String id = new SimpleDateFormat("yyyyMMddHHmmSSS").format(new Date(0));
		attendanceDto.setId(id);
		
		
		
		Attendance attendance=new Attendance();
		attendance.setId(id);
		attendance.setDate(attendanceDto.getDate());
		attendance.setTime(attendanceDto.getTime());
		attendance.setCounts(attendanceDto.getRollNos().size());
		
		
		
		
		attendance.setStudents(studentService.getAllStudentbyRoll(attendanceDto.getRollNos()));
		attendance.setSubject(subjectservice.getSubjectById(attendanceDto.getSubjectId()));
		attendance.setUser(userService.getUserById(attendanceDto.getUserName()));
		
		
		return dao.takeAttendanc(attendance);
		
	}

}
