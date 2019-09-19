package com.lms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.model.Role;
import com.lms.model.User;
import com.lms.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public Optional<User> findByRoleAndId(Role role, long id) {
		return userRepository.findByRoleAndId(role, id);
	}

	public Iterable<User> findAllByRole(Role role) {
		return userRepository.findAllByRole(role);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
}
