package com.lms.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.auth.security.services.UserPrinciple;
import com.lms.model.ExamPeriod;
import com.lms.model.ExamResults;
import com.lms.model.Student;
import com.lms.model.YearOfStudySubject;
import com.lms.service.ExamPeriodService;
import com.lms.service.ExamResultsService;
import com.lms.service.StudentService;
import com.lms.service.YearOfStudySubjectService;

@CrossOrigin
@RestController
@RequestMapping("/exam-period")
public class ExamPeriodController {
	@Autowired
	ExamPeriodService examPeriodService;
	
	@Autowired
	ExamResultsService examResultsService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	YearOfStudySubjectService yearOfStudySubjectService;
	
	@PostMapping
	@PreAuthorize("hasRole('EMPLOYEE')")
	public ExamPeriod createExamPeriod(@Valid @RequestBody ExamPeriod examPeriod) {
		return examPeriodService.save(examPeriod);
	}
	
	@PostMapping("/{periodId}/{syosId}/apply")
	@PreAuthorize("hasRole('STUDENT')")
	public void applyExamPeriod(@PathVariable("periodId") int periodId, @PathVariable("syosId") int syosId, UserPrinciple principal) {
		Optional<ExamPeriod> examPeriod = examPeriodService.findById(periodId);
		Optional<YearOfStudySubject> syos = yearOfStudySubjectService.findById(syosId);
		Student student = studentService.findById(principal.getId());

		if (examPeriod.isPresent() && syos.isPresent()) {
			ExamResults applyExam = new ExamResults();
			applyExam.setStudent(student);
			applyExam.setExamPeriod(examPeriod.get());
			applyExam.setYearOfStudySubject(syos.get());
			examResultsService.save(applyExam);
		}
	}
}
