package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "study_programme_student")
public class StudyProgrammeStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String index_number;
	private String yearOfEnrollment;

	@ManyToOne
	@MapsId("study_program_id")
	@JoinColumn(name = "study_program_id")
	@JsonView(View.StudyProgrammeStudent.class)
	private StudyProgramme studyProgramme;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	@JsonView(View.StudyProgrammeStudent.class)
	private Student student;

	public StudyProgrammeStudent(long id, String index_number, String yearOfEnrollment, StudyProgramme studyProgramme,
			Student student) {
		super();
		this.id = id;
		this.index_number = index_number;
		this.yearOfEnrollment = yearOfEnrollment;
		this.studyProgramme = studyProgramme;
		this.student = student;
	}

}
