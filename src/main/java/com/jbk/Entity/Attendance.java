package com.jbk.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Attendance {
	

	@Id
	private String id;
	
	
	private String date;
	private String time;
	private int counts;
	
	
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subject")
	private Subject subject;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="attendance_student",joinColumns = @JoinColumn(name="aid"),inverseJoinColumns =@JoinColumn(name="student"))
	private List<Student> students;
	
	public Attendance() {
		// TODO Auto-generated constructor stub
	}

	public Attendance(String id, List<Student> students, User user, Subject subject, String date, String time,
			int counts) {
		super();
		this.id = id;
		this.students = students;
		this.user = user;
		this.subject = subject;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
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
