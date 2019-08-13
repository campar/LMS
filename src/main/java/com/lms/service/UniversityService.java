package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.University;
import com.lms.repository.UniversityRepository;

@Service
public class UniversityService {
	
	@Autowired
	private UniversityRepository universityRepository;
	
	
	public List<University> getAllUniversity() {
		List<University> universities = new ArrayList<>();
		universityRepository.findAll().forEach(universities::add);
		return universities;
	}

}
