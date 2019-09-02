package com.lms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int maxPoints;
	private Date startTime;
	private Date endTime;
	
	@ManyToOne
	private ExamType examType;
	
	@ManyToOne
	private YearOfStudySubject yearOfStudySubject;

	public Exam(int id, String name, int maxPoints, Date startTime, Date endTime, ExamType examType, YearOfStudySubject yearOfStudySubject) {
		super();
		this.id = id;
		this.name = name;
		this.maxPoints = maxPoints;
		this.startTime = startTime;
		this.endTime = endTime;
		this.examType = examType;
		this.yearOfStudySubject = yearOfStudySubject;
	}
}
