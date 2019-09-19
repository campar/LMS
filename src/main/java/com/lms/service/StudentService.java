package com.lms.service;

import java.util.List;

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
			@RequestParam(value = "lastName", required = false) String lastName) {
		if (name == null) {
			name = "";
		}
		if (lastName == null) {
			lastName = "";
		}
		return studentRepository.findBySearch(name, lastName);

	}

	public Student findById(Long id) {
		return studentRepository.findById(id).get();
	}
}
