package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("FROM Student s JOIN s.studyProgrammeStudents s2  WHERE s.name LIKE %?1% AND s.lastName LIKE %?2% AND s2.index_number LIKE %?3% AND s2.yearOfEnrollment LIKE %?4%")
	List<Student> findBySearch(String name, String lastName, String index_number, String yearOfEnrollment);

}
