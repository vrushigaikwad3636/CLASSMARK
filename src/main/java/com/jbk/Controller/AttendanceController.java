package com.jbk.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.model.AttendanceDto;
import com.jbk.service.AttandanceSrvice;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {
	
	@Autowired
	private AttandanceSrvice attandanceSrvice;
	@PostMapping("/take-attendance")
	public String takeAttendance(@RequestBody AttendanceDto attendanceDto) {
		
		return attandanceSrvice.takeAttendanc(attendanceDto);
		
	}

}
