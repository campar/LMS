package com.lms.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.Professor;
import com.lms.model.StudyProgramme;
import com.lms.model.Subject;
import com.lms.service.ProfessorService;
import com.lms.service.StudyProgrammeService;
import com.lms.service.SubjectService;
import com.lms.utils.View;

@CrossOrigin
@RestController
@RequestMapping("/api/study-programmes")
public class StudyProgrammeController {

	@Autowired
	private StudyProgrammeService studyProgrammeService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private ProfessorService professorService;

	@GetMapping("/{id}")
	@JsonView(View.StudyProgrammeWithYearsOfStudyWithSubjects.class)
	public StudyProgramme getStudyProgrammeById(@PathVariable int id) {
		Optional<StudyProgramme> studyProgramme = studyProgrammeService.getStudyProgrammeById(id);
		
		if (studyProgramme.isPresent()) {
			return studyProgramme.get();
		}
		
		return null;
	}
	
	@JsonView(View.Subject.class)
	@GetMapping("/{id}/{professorId}/subjects")
	public Set<Subject> allSubjectOfProfesorOnProgramme(@PathVariable int id, @PathVariable long professorId) {
		Optional<StudyProgramme> studyProgramme = studyProgrammeService.getStudyProgrammeById(id);
		Optional<Professor> professor = professorService.findById(professorId);

		if (!studyProgramme.isPresent() || !professor.isPresent()) {
			return null;
		}

		return subjectService.allSubjectOfProfesorOnProgramme(id, professorId);
	}
}
