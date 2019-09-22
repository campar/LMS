package com.lms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class YearOfStudy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int year;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyProgramme studyProgramme;

	@OneToMany(mappedBy = "yearOfStudy")
	private List<YearOfStudySubject> yearOfStudySubject;

	@OneToMany(mappedBy = "yearOfStudy")
	private List<StudentYearOfStudy> studentYearOfStudy;

	public YearOfStudy(Long id, int year, StudyProgramme studyProgramme, List<YearOfStudySubject> yearOfStudySubject,
			List<StudentYearOfStudy> studentYearOfStudy) {
		super();
		this.id = id;
		this.year = year;
		this.studyProgramme = studyProgramme;
		this.yearOfStudySubject = yearOfStudySubject;
		this.studentYearOfStudy = studentYearOfStudy;
	}

}
