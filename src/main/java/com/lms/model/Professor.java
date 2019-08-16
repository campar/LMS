package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private long jmbg;
	private String biography;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "title_id", nullable = false)
	private ProfessorTitle title;
	
	public Professor() {}

	public Professor(long id, String name, long jmbg, String biography, ProfessorTitle title) {
		super();
		this.id = id;
		this.name = name;
		this.jmbg = jmbg;
		this.biography = biography;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public ProfessorTitle getTitle() {
		return title;
	}

	public void setTitle(ProfessorTitle title) {
		this.title = title;
	}
}
