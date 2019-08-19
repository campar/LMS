package com.lms.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

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
	@Size(max = 13)
	private String jmbg;
	private String biography;

	@JsonIgnore
	@ManyToMany
    Set<Title> titles;

	public Professor(String username, String email, String password, Role role, String name,
			@Size(max = 13) String jmbg, String biography, Set<Title> titles) {
		super(username, email, password, role);
		this.name = name;
		this.jmbg = jmbg;
		this.biography = biography;
		this.titles = titles;
	}
}
