package com.lms.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExamPeriod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date startTime;
	private Date endTime;
	
	@OneToMany(mappedBy = "examPeriod")
	private Set<ExamResults> examResults;
	
	@ManyToOne
	private ExamType examType;

	public ExamPeriod(int id, String name, Date startTime, Date endTime, ExamType examType) {
		super();
		this.id = id;
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.examType = examType;
	}
}
