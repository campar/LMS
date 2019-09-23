package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("FROM Student s WHERE s.name LIKE %?1% AND s.lastName LIKE %?2%")
	List<Student> findBySearch(String name, String lastName);

	@Query(value = "SELECT DISTINCT st.* FROM year_of_study_subject as yoss JOIN subject as s ON yoss.subject_id = s.id JOIN student_year_of_study as syos ON syos.year_of_study_id = yoss.year_of_study_id JOIN student as st ON st.id = syos.student_id WHERE yoss.subject_id = ?1 AND syos.year_of_study_id = ?2", nativeQuery = true)
	List<Student> getStudentsByYearBySubject(int subjectId, int yearId);
}
