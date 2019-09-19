package com.lms.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.Subject;
import com.lms.model.SyllabusOutcome;
import com.lms.service.SubjectService;
import com.lms.utils.View;

@RestController
@CrossOrigin
@RequestMapping("/subjects")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@GetMapping("/{id}")
	@JsonView(View.Subject.class)
	private Subject getSubjectById(@PathVariable int id) {
		return subjectService.finSubjectdById(id);
	}

	@GetMapping("/{id}/sillabus")
	@JsonView(View.Subject.class)
	public Set<SyllabusOutcome> getSillabusBySubjectId(@PathVariable int id) {
		return subjectService.getSillabusBySubjectId(id);
	}
}
