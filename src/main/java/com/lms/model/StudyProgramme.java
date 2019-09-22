package com.lms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StudyProgramme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Type(type = "text")
	private String description;

	@Enumerated(EnumType.STRING)
	private Degree degree;

	@Type(type = "text")
	private String title;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonView(View.FacultyWithStudyProgramme.class)
	private Faculty faculty;

	@JsonView(View.YearOfStudy.class)
	@OneToMany(mappedBy = "studyProgramme")
	private List<YearOfStudy> yearsOfStudy;

	@JsonView(View.StudyProgramme.class)
	@OneToMany(mappedBy = "studyProgramme")
	private List<StudyProgrammeStudent> studyProgrammeStudents;

	@ManyToOne
	@JsonView(View.YearOfStudy.class)
	@JoinColumn(name = "director", referencedColumnName = "id", insertable = false, updatable = false)
	private Professor director;

	public StudyProgramme(String name, String description, Faculty faculty) {
		super();
		this.name = name;
		this.description = description;
		this.faculty = faculty;
	}
}
