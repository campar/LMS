package com.lms.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends User {
	private String name;
	@Size(max = 13)
	private String jmbg;
	
	@OneToMany(mappedBy = "student")
    private Set<StudentYearOfStudy> studentYearOfStudy = new HashSet<StudentYearOfStudy>();

	public Student(String name, @Size(max = 13) String jmbg) {
		super();
		this.name = name;
		this.jmbg = jmbg;
	}
}
