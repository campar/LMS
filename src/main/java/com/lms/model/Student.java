package com.lms.model;

import javax.persistence.Entity;

@Entity
public class Student extends User {
	private String name;
	private long jmbg;

	public Student() {
	}

	public Student(String name, long jmbg) {
		super();
		this.name = name;
		this.jmbg = jmbg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getJmbg() {
		return jmbg;
	}

	public void setJmbg(long jmbg) {
		this.jmbg = jmbg;
	}
}
