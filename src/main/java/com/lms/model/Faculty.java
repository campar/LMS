package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Faculty {
	
	@Id
	private int id;
	private  String naziv;
	
	//@JoinColumn(name = "university_id", nullable = false)
	@ManyToOne
	private University university;

	public Faculty() {}
	
	public Faculty(int id, String naziv, University university) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.university = university;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public University getUniversity() {
		return university;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUniversity(University university) {
		this.university = university;
	}
}
