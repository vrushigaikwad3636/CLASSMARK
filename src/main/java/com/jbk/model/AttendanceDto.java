package com.jbk.model;

import java.util.List;

public class AttendanceDto {
	
	private String id;
	private List<Long> rollNos;
	private String userName;
	private long subjectId;
	private String date;
	private String time;
	private int counts;
	public AttendanceDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public AttendanceDto(String id, List<Long> rollNos, String userName, long subjectId, String date, String time,
			int counts) {
		super();
		this.id = id;
		this.rollNos = rollNos;
		this.userName = userName;
		this.subjectId = subjectId;
		this.date = date;
		this.time = time;
		this.counts = counts;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Long> getRollNos() {
		return rollNos;
	}
	public void setRollNos(List<Long> rollNos) {
		this.rollNos = rollNos;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public long getSubjectId() {
		return subjectId;
	}




	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}




	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	
	
	

}
