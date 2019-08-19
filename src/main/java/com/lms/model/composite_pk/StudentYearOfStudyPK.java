package com.lms.model.composite_pk;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class StudentYearOfStudyPK implements Serializable {
	@Column(name = "student_id")
    private Long student_id;

     @Column(name = "year_of_study_id")
    private Long year_of_study_id;
}
