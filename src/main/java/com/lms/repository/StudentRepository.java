package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("FROM Student s WHERE s.name LIKE %?1% AND s.lastName LIKE %?2%")
	List<Student> findBySearch(String name, String lastName);
}
