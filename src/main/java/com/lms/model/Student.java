package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
	private String name;
	private String lastName;
	@Size(max = 13)
	private String jmbg;

	@OneToMany(mappedBy = "student")
	private Set<StudyProgrammeStudent> studyProgrammeStudents;

	@OneToMany(mappedBy = "student")
	private Set<FinalGrade> finalGrades;

	@OneToMany(mappedBy = "student")
	private Set<ExamResults> examResults;

	@JsonView(View.Student.class)
	@OneToMany(mappedBy = "student")
	private Set<StudentYearOfStudy> studentYearOfStudy;

	public Student(String username, String email, String password, Role role, String name, String lastName,
			@Size(max = 13) String jmbg, Set<StudyProgrammeStudent> studyProgrammeStudents, Set<FinalGrade> finalGrades,
			Set<ExamResults> examResults, Set<StudentYearOfStudy> studentYearOfStudy) {
		super(username, email, password, role);
		this.name = name;
		this.lastName = lastName;
		this.jmbg = jmbg;
		this.studyProgrammeStudents = studyProgrammeStudents;
		this.finalGrades = finalGrades;
		this.examResults = examResults;
		this.studentYearOfStudy = studentYearOfStudy;
	}

}
