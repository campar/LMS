package com.lms.model;

import java.util.Date;
import java.util.List;

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
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date dateOfEstablishment;
	private String phoneNumber;
	private String description;

	@OneToMany(mappedBy = "university")
	@JsonView(View.UniversityWithFaculties.class)
	private List<Faculty> faculties;

	@ManyToOne
	@JsonView(View.UniversityWithFaculties.class)
	@JoinColumn(name = "rector", referencedColumnName = "id", insertable = false, updatable = false)
	private Professor rector;

	@ManyToOne
	@JsonView(View.UniversityWithFaculties.class)
	private Address address;

	public University(int id, String name, Date dateOfEstablishment, String phoneNumber, String description,
			List<Faculty> faculties, Professor rector, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfEstablishment = dateOfEstablishment;
		this.phoneNumber = phoneNumber;
		this.description = description;
		this.faculties = faculties;
		this.rector = rector;
		this.address = address;
	}
}
