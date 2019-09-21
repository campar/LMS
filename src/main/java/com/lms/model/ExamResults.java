package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamResults {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int points;

	@ManyToOne
	@MapsId("exam_period_id")
	@JoinColumn(name = "exam_period_id")
	@JsonView(View.ExamResults.class)
	private ExamPeriod examPeriod;

	@ManyToOne
	@MapsId("student_id")
	@JoinColumn(name = "student_id")
	@JsonView(View.ExamResults.class)
	private Student student;

	@ManyToOne
	@MapsId("syos_id")
	@JoinColumn(name = "syos_id")
	@JsonView(View.ExamResults.class)
	private YearOfStudySubject yearOfStudySubject;
}
