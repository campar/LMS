package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.model.Student;
import com.lms.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudents(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "lastName", required = false) String lastName,
			@RequestParam(value = "index_number", required = false) String index_number,
			@RequestParam(value = "yearOfEnrollment", required = false) String yearOfEnrollment) {
		if (name == null) {
			name = "";
		}
		if (lastName == null) {
			lastName = "";
		}
		if (index_number == null) {
			index_number = "";
		}
		if (yearOfEnrollment == null) {
			yearOfEnrollment = "";
		}
		return studentRepository.findBySearch(name, lastName, index_number, yearOfEnrollment);

	}
	
	public List<Student> getStudentsByYearBySubject(int subjectId, int yearId) {
		return studentRepository.getStudentsByYearBySubject(subjectId, yearId);
	}

	public Optional<Student> findById(Long id) {
		return studentRepository.findById(id);
	}
}
