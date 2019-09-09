package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {

}
