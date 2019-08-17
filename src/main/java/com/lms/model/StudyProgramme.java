package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class StudyProgramme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Type(type = "text")
	private String description;

	@ManyToOne
	@JsonBackReference
	private Faculty faculty;

	@OneToMany(mappedBy = "studyProgramme")
	@JsonManagedReference
	private Set<YearOfStudy> yearsOfStudy;

	@ManyToOne
	@JoinColumn(name = "director", referencedColumnName = "id", insertable = false, updatable = false)
	private Professor director;

	public StudyProgramme() {
	}

	public StudyProgramme(String name, String description, Faculty faculty) {
		super();
		this.name = name;
		this.description = description;
		this.faculty = faculty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<YearOfStudy> getYearsOfStudy() {
		return yearsOfStudy;
	}

	public void setYearsOfStudy(Set<YearOfStudy> yearsOfStudy) {
		this.yearsOfStudy = yearsOfStudy;
	}

	public Professor getDirector() {
		return director;
	}

	public void setDirector(Professor director) {
		this.director = director;
	}

}
