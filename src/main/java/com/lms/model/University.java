package com.lms.model;

import java.util.Date;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class University {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date dateOfEstablishment;

	@OneToMany(mappedBy = "university")
	@JsonIgnore
	private Set<Faculty> faculties;

	public University() {
	}

	public University(int id, String name, Date dateOfEstablishment) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfEstablishment = dateOfEstablishment;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfEstablishment() {
		return dateOfEstablishment;
	}

	public void setDateOfEstablishment(Date dateOfEstablishment) {
		this.dateOfEstablishment = dateOfEstablishment;
	}

	public Set<Faculty> getFaculties() {
		return faculties;
	}

	public void setFaculties(Set<Faculty> faculties) {
		this.faculties = faculties;
	}

}
