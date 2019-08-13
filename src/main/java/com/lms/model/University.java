package com.lms.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
	private String id;
	
	private Date datumOsnivanja;

	public University() {}
	
	public University(String naziv, Date datumOsnivanja) {
		super();
		this.id = naziv;
		this.datumOsnivanja = datumOsnivanja;
	}

	public String getNaziv() {
		return id;
	}

	public void setNaziv(String naziv) {
		this.id = naziv;
	}

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}
}
