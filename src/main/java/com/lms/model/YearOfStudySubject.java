package com.lms.model;

import java.util.Set;

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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
	private long id;

//	@Column(nullable = true)
//	@Size(max = 2)
//	private int finalGrade;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@ManyToOne
	@MapsId("year_of_study_id")
	@JoinColumn(name = "year_of_study_id")
	private YearOfStudy yearOfStudy;

	@OneToMany(mappedBy = "yearOfStudySubject")
	private Set<Notification> notifications;

	public YearOfStudySubject(long id, Subject subject, YearOfStudy yearOfStudy) {
		super();
		this.id = id;
		this.subject = subject;
		this.yearOfStudy = yearOfStudy;
	}
}
