package com.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.ExamResults;
import com.lms.repository.ExamResultRepository;

@Service
public class ExamResultsService {
	@Autowired
	ExamResultRepository examResultsRepository;
	
	public Optional<ExamResults> findById(int id) {
		return examResultsRepository.findById(id);
	}

	public Iterable<ExamResults> findAll() {
		return examResultsRepository.findAll();
	}

	public ExamResults save(ExamResults examResults) {
		return examResultsRepository.save(examResults);
	}
}
