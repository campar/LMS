package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "year_of_study_subject")
public class YearOfStudySubject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(max = 2)
	private int finalGrade;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToOne
	@MapsId("year_of_study_id")
	@JoinColumn(name = "year_of_study_id")
	private YearOfStudy yearOfStudy;

	public YearOfStudySubject(long id, @Size(max = 2) int finalGrade, Subject subject, YearOfStudy yearOfStudy) {
		super();
		this.id = id;
		this.finalGrade = finalGrade;
		this.subject = subject;
		this.yearOfStudy = yearOfStudy;
	}
}
