package com.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SyllabusOutcome {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private int sort;
	private String period;

	@Type(type = "text")
	private String description;

	@JsonView(View.SyllabusOutcome.class)
	@ManyToOne(fetch = FetchType.LAZY)
	private Subject subject;

	public SyllabusOutcome(int id, int sort, String period, String description, Subject subject) {
		super();
		this.id = id;
		this.sort = sort;
		this.period = period;
		this.description = description;
		this.subject = subject;
	}
}
