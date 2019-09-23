package com.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("FROM Student s JOIN s.studyProgrammeStudents s2  WHERE s.name LIKE %?1% AND s.lastName LIKE %?2% AND s2.index_number LIKE %?3% AND s2.yearOfEnrollment LIKE %?4%")
	List<Student> findBySearch(String name, String lastName, String index_number, String yearOfEnrollment);

	@Query(value = "SELECT DISTINCT us.*, st.* FROM year_of_study_subject as yoss JOIN subject as s ON yoss.subject_id = s.id JOIN student_year_of_study as syos ON syos.year_of_study_id = yoss.year_of_study_id JOIN student as st ON st.id = syos.student_id JOIN users as us ON us.id = st.id WHERE yoss.subject_id = ?1 AND syos.year_of_study_id = ?2", nativeQuery = true)
	List<Student> getStudentsByYearBySubject(int subjectId, int yearId);
}
