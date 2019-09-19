package com.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.ExamPeriod;
import com.lms.repository.ExamPeriodRepository;

@Service
public class ExamPeriodService {
	@Autowired
	ExamPeriodRepository examPeriodRepository;
	
	public Iterable<ExamPeriod> findAll(){
		return examPeriodRepository.findAll();
	}
	
	public ExamPeriod save(ExamPeriod examPeriod) {
		return examPeriodRepository.save(examPeriod);
	}
}
