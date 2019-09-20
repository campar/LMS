package com.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.service.ExamResultsService;

@CrossOrigin
@RestController
@RequestMapping("/exam-results")
public class ExamResultsController {
	@Autowired
	ExamResultsService examResultsService;
}
