package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Professor extends User {
	private String name;
	private long jmbg;
	private String biography;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "title_id", nullable = false)
	private ProfessorTitle title;

	public Professor(String name, long jmbg, String biography, ProfessorTitle title) {
		super();
		this.name = name;
		this.jmbg = jmbg;
		this.biography = biography;
		this.title = title;
	}
}
