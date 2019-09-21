package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "student_year_of_study")
public class StudentYearOfStudy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	private Student student;

	@ManyToOne
	@MapsId("year_of_study_id")
	@JoinColumn(name = "year_of_study_id")
	private YearOfStudy yearOfStudy;

	public Long getStudentId() {
		return student.getId();
	}

	public int getId() {
		return id;
	}

	public Long getYearOfStudyId() {
		return yearOfStudy.getId();
	}
}
