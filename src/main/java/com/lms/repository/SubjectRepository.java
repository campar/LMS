package com.lms.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
	@Query(value = "select distinct subject.* from subject join year_of_study_subject on subject.id = year_of_study_subject.subject_id join year_of_study on year_of_study_subject.year_of_study_id = year_of_study.id join professor on year_of_study_subject.professor_id = professor.id where professor_id = ?2 and study_programme_id = ?1", nativeQuery = true)
	Set<Subject> allSubjectOfProfesorOnProgramme(int studyProgrammeId, Long professorId);
}
