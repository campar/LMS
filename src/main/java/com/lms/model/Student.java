package com.lms.model;

import java.util.List;

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
	@JsonView(View.Student.class)
	private List<StudyProgrammeStudent> studyProgrammeStudents;

	@OneToMany(mappedBy = "student")
	@JsonView(View.Student.class)
	private List<FinalGrade> finalGrades;

	@OneToMany(mappedBy = "student")
	@JsonView(View.Student.class)
	private List<ExamResults> examResults;

	@JsonView(View.Student.class)
	@OneToMany(mappedBy = "student")
	private List<StudentYearOfStudy> studentYearOfStudy;

	public Student(String username, String email, String password, Role role, String name, String lastName,
			@Size(max = 13) String jmbg, List<StudyProgrammeStudent> studyProgrammeStudents,
			List<FinalGrade> finalGrades, List<ExamResults> examResults, List<StudentYearOfStudy> studentYearOfStudy) {
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
