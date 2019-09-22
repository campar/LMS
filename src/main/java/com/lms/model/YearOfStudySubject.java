package com.lms.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "year_of_study_subject")
public class YearOfStudySubject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	@JsonView(View.YearOfStudySubject.class)
	private Subject subject;

	@ManyToOne
	@MapsId("year_of_study_id")
	@JoinColumn(name = "year_of_study_id")
	@JsonView(View.YearOfStudySubject.class)
	private YearOfStudy yearOfStudy;

	@ManyToOne
	@MapsId("professor_id")
	@JoinColumn(name = "professor_id")
	@JsonView(View.YearOfStudySubject.class)
	private Professor professor;

	@OneToMany(mappedBy = "yearOfStudySubject")
	@JsonView(View.YearOfStudySubject.class)
	private List<FinalGrade> finalGrades;

	@OneToMany(mappedBy = "yearOfStudySubject")
	@JsonView(View.YearOfStudySubject.class)
	private List<Notification> notifications;

	public YearOfStudySubject(int id, Subject subject, YearOfStudy yearOfStudy, Professor professor,
			List<FinalGrade> finalGrades, List<Notification> notifications) {
		super();
		this.id = id;
		this.subject = subject;
		this.yearOfStudy = yearOfStudy;
		this.professor = professor;
		this.finalGrades = finalGrades;
		this.notifications = notifications;
	}
}
