package com.lms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Subject;
import com.lms.model.SyllabusOutcome;
import com.lms.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public Subject finSubjectdById(int id) {

		return subjectRepository.findById(id).get();
	}

	public List<SyllabusOutcome> getSillabusBySubjectId(int id) {
		return subjectRepository.findById(id).get().getSyllabusOutcomes();
	}
}
