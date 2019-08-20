package com.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.lms.model.composite_pk.StudentYearOfStudyPK;

@Entity
@Table(name = "student_year_of_study")
public class StudentYearOfStudy {
	@EmbeddedId
	private StudentYearOfStudyPK id;
	
	@ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;
	
	@ManyToOne
    @MapsId("year_of_study_id")
    @JoinColumn(name = "year_of_study_id")
    private YearOfStudy yearOfStudy;
	
	@Column(name = "indexNumber")
	@Size(max = 7)
	private String indexNumber;
	
	@Column(name = "start_date")
	private Date startDate;
}
