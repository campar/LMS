package com.lms.model;

import java.util.HashSet;
import java.util.Set;

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
	private Set<YearOfStudySubject> yearOfStudySubject;
	
	@OneToMany(mappedBy = "yearOfStudy")
    private Set<StudentYearOfStudy> studentYearOfStudy = new HashSet<StudentYearOfStudy>();

	public YearOfStudy(Long id, int year, StudyProgramme studyProgramme) {
		super();
		this.id = id;
		this.year = year;
		this.studyProgramme = studyProgramme;
	}
}
