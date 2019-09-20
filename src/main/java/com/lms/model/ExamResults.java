package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.springframework.lang.Nullable;

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
	
	@Nullable
	private int points;
	
	@ManyToOne
    @MapsId("exam_period_id")
    @JoinColumn(name = "exam_period_id")
    private ExamPeriod examPeriod;
	
	@ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;
	
	@ManyToOne
    @MapsId("syos_id")
    @JoinColumn(name = "syos_id")
    private YearOfStudySubject yearOfStudySubject;
}
