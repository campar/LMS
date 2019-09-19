package com.lms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Student;
import com.lms.response.StudentResponse;
import com.lms.service.StudentService;

@CrossOrigin
@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping(path = "/{id}/download", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public StudentResponse exportStudent(@PathVariable Long id) {
		Student student = studentService.findById(id);
		StudentResponse response = new StudentResponse();

		response.setId(student.getId());
		response.setName(student.getName());
		response.setUsername(student.getUsername());
		response.setEmail(student.getEmail());
		response.setJmbg(student.getJmbg());

		return response;
	}

	@GetMapping("/find")
	public List<Student> getAllStudents(String name, String lastName) {
		return studentService.getAllStudents(name, lastName);
	}
}