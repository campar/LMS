package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.StudyProgramme;
import com.lms.service.StudyProgrammeService;
import com.lms.utils.View;

@CrossOrigin
@RestController
@RequestMapping("/api/study-programmes")
public class StudyProgrammeController {

	@Autowired
	private StudyProgrammeService studyProgrammeService;

	@GetMapping("/{id}")
	@JsonView(View.StudyProgrammeWithYearsOfStudyWithSubjects.class)
	public StudyProgramme getStudyProgrammeById(@PathVariable int id) {
		return studyProgrammeService.getStudyProgrammeById(id);
	}
}
