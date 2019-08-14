package com.lms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Faculty;
import com.lms.repository.FacultyRepository;

@Service
public class FacultyService {
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public Optional<Faculty> findById(int id) {
		return facultyRepository.findById(id);
	}
	
	public List<Faculty> getAllFaculties(){
		List<Faculty> faculties = new ArrayList<>();
		facultyRepository.findAll().forEach(faculties::add);
		return faculties;
	}
	
	public Faculty save(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
}
