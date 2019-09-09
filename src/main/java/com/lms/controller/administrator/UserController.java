package com.lms.controller.administrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lms.model.Professor;
import com.lms.model.Role;
import com.lms.model.User;
import com.lms.service.ProfessorService;
import com.lms.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

	@Autowired
	ProfessorService professorService;

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder encoder;

	@PutMapping("/professor")
	public Professor createProfessor(@RequestBody Professor professor) {
		professor.setRole(Role.ROLE_PROFESSOR);
		professor.setPassword(encoder.encode(professor.getPassword()));
		return professorService.save(professor);
	}

	@PutMapping("/employee")
	public User createEmployee(@RequestBody User user) {
		user.setRole(Role.ROLE_EMPLOYEE);
		user.setPassword(encoder.encode(user.getPassword()));
		return userService.save(user);
	}
}
