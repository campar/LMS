package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

	@JsonView(View.Subject.class)
	@OneToMany(mappedBy = "subject")
	private Set<SyllabusOutcome> syllabusOutcomes;

	public Subject(int id, String name, int espb, Boolean required, int numberOfLectures, int numberOfExercises,
			int differentKindOfLectures, int researchWork, int otherClasses, Set<YearOfStudy> yearOfStudy,
			Set<SyllabusOutcome> syllabusOutcomes) {
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
		this.yearOfStudy = yearOfStudy;
		this.syllabusOutcomes = syllabusOutcomes;
	}
}
