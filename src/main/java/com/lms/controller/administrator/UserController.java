package com.lms.controller.administrator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lms.model.Professor;
import com.lms.model.Role;
import com.lms.model.User;
import com.lms.service.ProfessorService;
import com.lms.service.UserService;
import com.lms.utils.View;

@CrossOrigin
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

	@Autowired
	ProfessorService professorService;

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@JsonView(View.Professor.class)
	@GetMapping("/professor")
	public List<Professor> listProfessor() {
		List<Professor> professors = new ArrayList<Professor>();
		professorService.findAll().forEach(professors::add);

		return professors;
	}

	@JsonView(View.Professor.class)
	@GetMapping("/professor/{id}")
	public Optional<Professor> getProfessor(@PathVariable("id") long id) {
		return professorService.findById(id);
	}

	@PostMapping("/professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		professor.setRole(Role.ROLE_PROFESSOR);
		professor.setPassword(encoder.encode(professor.getPassword()));
		return professorService.save(professor);
	}

	@PutMapping("/professor/{id}")
	public Professor updateProfessor(@PathVariable("id") long id, @RequestBody Professor professor) {
		Optional<Professor> p = professorService.findById(id);
		if (p.isPresent()) {
			professor.setRole(Role.ROLE_PROFESSOR);
			return professorService.save(professor);
		}
		return null;
	}

	@PutMapping("/employee")
	public User createEmployee(@RequestBody User user) {
		user.setRole(Role.ROLE_EMPLOYEE);
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.save(user);
	}
}
