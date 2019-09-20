package com.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.YearOfStudySubject;
import com.lms.repository.YearOfStudySubjectRepository;

@Service
public class YearOfStudySubjectService {
	@Autowired
	YearOfStudySubjectRepository yearOfStudySubjectRepository;
	
	public Optional<YearOfStudySubject> findById(long id) {
		return yearOfStudySubjectRepository.findById(id);
	}

	public Iterable<YearOfStudySubject> findAll() {
		return yearOfStudySubjectRepository.findAll();
	}

	public YearOfStudySubject save(YearOfStudySubject syos) {
		return yearOfStudySubjectRepository.save(syos);
	}
}
