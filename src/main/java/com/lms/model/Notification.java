package com.lms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Notification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;

	@ManyToOne
	@JsonView(View.Notification.class)
	private User createdBy;

	@CreatedDate
	@Column(name = "created_date")
	private Date createdDate;

	@Type(type = "text")
	private String content;

	@ManyToOne
	@JsonView(View.Notification.class)
	private YearOfStudySubject yearOfStudySubject;

	// private File file;

	public Notification(int id, String title, User createdBy, Date createdDate, String content,
			YearOfStudySubject yearOfStudySubject) {
		super();
		this.id = id;
		this.title = title;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.content = content;
		this.yearOfStudySubject = yearOfStudySubject;
	}
}
