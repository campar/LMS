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
@Table(name = "final_grade")
public class FinalGrade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size(max = 2)
	private int final_grade;

	@ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;
	
	@ManyToOne
    @MapsId("syos_id")
    @JoinColumn(name = "syos_id")
    private YearOfStudySubject yearOfStudySubject;
}
