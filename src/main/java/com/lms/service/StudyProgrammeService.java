package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.StudyProgramme;
import com.lms.repository.StudyProgrammeRepository;

@Service
public class StudyProgrammeService {

	@Autowired
	private StudyProgrammeRepository studyProgrammeRepository;

	public StudyProgramme getStudyProgrammeById(int id) {
		return studyProgrammeRepository.findById(id).get();
	}
}
