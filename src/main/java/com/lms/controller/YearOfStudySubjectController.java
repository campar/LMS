package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.YearOfStudySubject;
import com.lms.service.YearOfStudySubjectService;
import com.lms.utils.View;

@CrossOrigin
@RequestMapping("/api/yearOfStudySubject")
@RestController
public class YearOfStudySubjectController {

	@Autowired
	private YearOfStudySubjectService yearOfStudySubjectService;

	@GetMapping("/{id}")
	@JsonView(View.YearOfStudySubject.class)
	public YearOfStudySubject getUniversityById(@PathVariable int id) {
		return yearOfStudySubjectService.getAllYearOfStudySubjectById(id);
	}
}
