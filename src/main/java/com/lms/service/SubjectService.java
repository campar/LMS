package com.lms.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Professor;
import com.lms.model.StudyProgramme;
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
	
	public Set<Subject> allSubjectOfProfesorOnProgramme(StudyProgramme studyProgramme, Professor professor) {
		return subjectRepository.allSubjectOfProfesorOnProgramme(studyProgramme, professor);
	}
}
