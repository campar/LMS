package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phoneNumber;
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "university_id", nullable = false)
	private University university;

	@JsonManagedReference
	@OneToMany(mappedBy = "faculty")
	private Set<StudyProgramme> studyProgrammes;

	public Faculty() {
	}

	public Faculty(int id, String name, University university, String phoneNumber, String description) {
		super();
		this.id = id;
		this.name = name;
		this.university = university;
		this.phoneNumber = phoneNumber;
		this.description = description;
	}

	public int getId() {
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

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<StudyProgramme> getStudyProgrammes() {
		return studyProgrammes;
	}

	public void setStudyProgrammes(Set<StudyProgramme> studyProgrammes) {
		this.studyProgrammes = studyProgrammes;
	}
}
