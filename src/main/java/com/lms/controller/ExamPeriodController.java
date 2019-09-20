package com.lms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.ExamPeriod;
import com.lms.service.ExamPeriodService;

@CrossOrigin
@RestController
@RequestMapping("/exam-period")
public class ExamPeriodController {
	@Autowired
	ExamPeriodService examPeriodService;
	
	@PostMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ExamPeriod createExamPeriod(@Valid @RequestBody ExamPeriod examPeriod) {
		return examPeriodService.save(examPeriod);
	}
}
