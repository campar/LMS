package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
