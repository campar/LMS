package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class YearOfStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int godina;

	@ManyToOne
	@JsonBackReference
	private StudyProgramme studyProgramme;

	@JsonManagedReference
	@JoinTable(name = "year_of_study_subject", joinColumns = @JoinColumn(name = "year_of_study_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	@ManyToMany
	private Set<Subject> subjects;

	public YearOfStudy() {
	}

	public YearOfStudy(int id, int godina, StudyProgramme studyProgramme) {
		super();
		this.id = id;
		this.godina = godina;
		this.studyProgramme = studyProgramme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public StudyProgramme getStudyProgramme() {
		return studyProgramme;
	}

	public void setStudyProgramme(StudyProgramme studyProgramme) {
		this.studyProgramme = studyProgramme;
	}

}
