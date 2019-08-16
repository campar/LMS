package com.lms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProfessorTitle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private Date dateStart;
	private Date dateEnd;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "field_id", nullable = false)
	private ScientificField scientificField;
	
	public ProfessorTitle() {}

	public ProfessorTitle(long id, String name, Date dateStart, Date dateEnd, ScientificField scientificField) {
		super();
		this.id = id;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.scientificField = scientificField;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public ScientificField getScientificField() {
		return scientificField;
	}

	public void setScientificField(ScientificField scientificField) {
		this.scientificField = scientificField;
	}
}
