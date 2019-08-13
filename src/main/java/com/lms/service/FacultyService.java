package com.lms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Faculty;
import com.lms.repository.FacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public List<Faculty> getAllFaculties(){
		List<Faculty> faculties = new ArrayList<>();
		facultyRepository.findAll().forEach(faculties::add);
		return faculties;
	}
	
}
