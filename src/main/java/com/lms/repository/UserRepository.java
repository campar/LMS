package com.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lms.model.Role;
import com.lms.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Optional<User> findByRole(Role role);

	Optional<User> findByRoleAndId(Role role, long id);

	List<User> findAllByRole(Role role);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}