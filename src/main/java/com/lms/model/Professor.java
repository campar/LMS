package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Professor extends User {
	private String name;
	private String jmbg;
	private String biography;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "title_id", nullable = false)
	private ProfessorTitle title;

	public Professor() {
	}

	public Professor(String name, String jmbg, String biography, ProfessorTitle title) {
		super();
		this.name = name;
		this.jmbg = jmbg;
		this.biography = biography;
		this.title = title;
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
