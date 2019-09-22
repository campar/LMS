package com.lms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.utils.View;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String phoneNumber;
	private String description;

	@JsonView(View.Faculty.class)
	@ManyToOne(cascade = CascadeType.ALL)
	private University university;

	@JsonView(View.Faculty.class)
	@OneToMany(mappedBy = "faculty")
	private List<StudyProgramme> studyProgrammes;

	@ManyToOne
	@JsonView(View.Faculty.class)
	@JoinColumn(name = "dean", referencedColumnName = "id", insertable = false, updatable = false)
	private Professor dean;

	public Faculty(int id, String name, String phoneNumber, String description, University university,
			List<StudyProgramme> studyProgrammes, Professor dean) {
		super();
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.university = university;
		this.studyProgrammes = studyProgrammes;
		this.dean = dean;
	}
}
