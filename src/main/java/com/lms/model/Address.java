package com.lms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String street;
	private String number;

	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;

	public Address(int id, String street, String number, City city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.city = city;
	}
}
