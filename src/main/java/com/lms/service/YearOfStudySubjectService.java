package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.YearOfStudySubject;
import com.lms.repository.YearOfStudySubjectRepository;

@Service
public class YearOfStudySubjectService {

	@Autowired
	private YearOfStudySubjectRepository yearOfStudySubjectRepostiory;

	public YearOfStudySubject getAllYearOfStudySubjectById(int id) {
		return yearOfStudySubjectRepostiory.findById(id).get();
	}
}
