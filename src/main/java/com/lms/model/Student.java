package com.lms.model;

import javax.persistence.Entity;

@Entity
public class Student extends User {
	private String name;
	private String jmbg;

	public Student() {
	}

	public Student(String name, String jmbg) {
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

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
}
