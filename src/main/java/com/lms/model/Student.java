package com.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Student extends User {
	private String name;
	@Size(max = 13)
	private String jmbg;
	
	@OneToMany(mappedBy = "student")
    private Set<StudentYearOfStudy> studentYearOfStudy = new HashSet<StudentYearOfStudy>();

	public Student() {
	}

	public Student(String name, @Size(max = 13) String jmbg) {
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
