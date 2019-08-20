package com.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private int godina;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private StudyProgramme studyProgramme;

	@ManyToMany
	@JoinTable(name = "year_of_study_subject", joinColumns = @JoinColumn(name = "year_of_study_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Subject> subjects;
	
	@OneToMany(mappedBy = "yearOfStudy")
    private Set<StudentYearOfStudy> studentYearOfStudy = new HashSet<StudentYearOfStudy>();

	public YearOfStudy(Long id, int godina, StudyProgramme studyProgramme) {
		super();
		this.id = id;
		this.godina = godina;
		this.studyProgramme = studyProgramme;
	}
}
