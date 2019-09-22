package com.lms.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lms.model.Professor;
import com.lms.model.StudyProgramme;
import com.lms.model.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
	@Query("FROM Subject s join YearOfStudySubject syos on s.id = syos.subject join YearOfStudy yos on syos.yearOfStudy = yos.id join Professor p on syos.professor = p.id where syos.professor = ?2 and yos.studyProgramme = ?1")
	Set<Subject> allSubjectOfProfesorOnProgramme(StudyProgramme studyProgrammeId, Professor professorId);
}
