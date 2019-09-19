package com.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Professor;
import com.lms.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public Optional<Professor> findById(long id) {
		return professorRepository.findById(id);
	}

	public Iterable<Professor> findAll() {
		return professorRepository.findAll();
	}

	public Professor save(Professor professor) {
		return professorRepository.save(professor);
	}
}
