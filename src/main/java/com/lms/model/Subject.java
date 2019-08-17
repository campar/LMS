package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private int espb;
	private Boolean required;
	private int numberOfLectures;
	private int numberOfExercises;
	private int differentKindOfLectures;
	private int researchWork;
	private int otherClasses;

	@JsonBackReference
	@ManyToMany(mappedBy = "subjects")
	private Set<YearOfStudy> yearOfStudy;

	@JsonManagedReference
	@OneToMany(mappedBy = "subject")
	private Set<SyllabusOutcome> syllabusOutcomes;

	public Subject() {
	}

	public Subject(int id, String name, int espb, Boolean required, int numberOfLectures, int numberOfExercises,
			int differentKindOfLectures, int researchWork, int otherClasses) {
		super();
		this.id = id;
		this.name = name;
		this.espb = espb;
		this.required = required;
		this.numberOfLectures = numberOfLectures;
		this.numberOfExercises = numberOfExercises;
		this.differentKindOfLectures = differentKindOfLectures;
		this.researchWork = researchWork;
		this.otherClasses = otherClasses;
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

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public Boolean getRequired() {
		return required;
	}

	public void setRequired(Boolean required) {
		this.required = required;
	}

	public int getNumberOfLectures() {
		return numberOfLectures;
	}

	public void setNumberOfLectures(int numberOfLectures) {
		this.numberOfLectures = numberOfLectures;
	}

	public int getNumberOfExercises() {
		return numberOfExercises;
	}

	public void setNumberOfExercises(int numberOfExercises) {
		this.numberOfExercises = numberOfExercises;
	}

	public int getDifferentKindOfLectures() {
		return differentKindOfLectures;
	}

	public void setDifferentKindOfLectures(int differentKindOfLectures) {
		this.differentKindOfLectures = differentKindOfLectures;
	}

	public int getResearchWork() {
		return researchWork;
	}

	public void setResearchWork(int researchWork) {
		this.researchWork = researchWork;
	}

	public int getOtherClasses() {
		return otherClasses;
	}

	public void setOtherClasses(int otherClasses) {
		this.otherClasses = otherClasses;
	}

	public Set<YearOfStudy> getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(Set<YearOfStudy> yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public Set<SyllabusOutcome> getSyllabusOutcomes() {
		return syllabusOutcomes;
	}

	public void setSyllabusOutcomes(Set<SyllabusOutcome> syllabusOutcomes) {
		this.syllabusOutcomes = syllabusOutcomes;
	}

}
