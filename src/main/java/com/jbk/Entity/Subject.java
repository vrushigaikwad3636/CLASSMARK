package com.jbk.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	
	@Id
	private long id;
	private String name;
	private String code;
	
	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public Subject(long id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	
	

}
