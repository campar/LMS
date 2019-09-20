#===================
#LOCATION INSERTS
#===================
INSERT INTO `country` (`id`, `name`) VALUES (NULL, 'Serbia');
INSERT INTO `country` (`id`, `name`) VALUES (NULL, 'Montenegro');

INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'NS', '1');
INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'BG', '1');
INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'PG', '2');

INSERT INTO `address` (`id`, `number`, `street`, `city_id`) VALUES (NULL, '13', 'Nova BB', '1');


#===================
#USER INSERTS
#===================

INSERT INTO `users` (`id`, `email`, `password`, `role`, `username`) VALUES (NULL, 'admin1@lms.com', '$2a$10$Q7sQxPEZugGSmiOHqy6LNOEXlHBs/syeZlEe2B1frMJpdtWs1B/L.', 'ROLE_ADMIN', 'admin1');
INSERT INTO `users` (`id`, `email`, `password`, `role`, `username`) VALUES (NULL, 'profa1@lms.com', '$2a$10$APc9riVj5qek9jz/i1yNWO5TVC8.knWnAkAEJ2LD7BHfB.7Ts9.r.', 'ROLE_PROFESSOR', 'profa1');
INSERT INTO `users` (`id`, `email`, `password`, `role`, `username`) VALUES (NULL, 'student1@lms.com', '$2a$10$QHl3XqVlHNwyMhlZfHtE..uZoUYwQPwz/ZHRcJ6CsOShtyM6ZPvUK', 'ROLE_STUDENT', 'student1');
INSERT INTO `users` (`id`, `email`, `password`, `role`, `username`) VALUES (NULL, 'employee1@lms.com', '$2a$10$o2PUqWRzyCncCMuQUiWMieAd6z.bEOhLMdyTyXUMAs5tdzRKQi4t6', 'ROLE_EMPLOYEE', 'employee1');


#===================
#STUDENT STUFF INSERTS
#===================
INSERT INTO `student` (`jmbg`, `name`, `id`, `last_name`) VALUES ('1234567891234', 'Blago', '3', 'Colic');

#===================
#PROFESSOR STUFF INSERTS
#===================

INSERT INTO `scientific_field` (`id`, `name`) VALUES (NULL, 'Matematicke Nauke');
INSERT INTO `professor` (`biography`, `jmbg`, `name`, `id`) VALUES ('Cao, ja sam zvonko i master sam matematika', '1234567891235', 'Zvonko', '2');
INSERT INTO `title` (`id`, `date_end`, `date_start`, `name`, `field_id`, `professor_id`) VALUES ('1', '2019-08-01 00:00:00', '2019-08-02 00:00:00', 'Master matematicar', '1', '2');


#===================
#UNIVERSITY INSERTS
#===================
INSERT INTO `university` (`id`, `date_of_establishment`, `description`, `name`, `phone_number`, `address_id`, `rector`) VALUES (NULL, '2017-12-06 00:00:00', 'OPIS UNIVERZITETA', 'UNIVERZITET SINGIDUNUM', '+381 11 262 6474', '1', '2');


#===================
#FACULTY INSERTS
#===================
INSERT INTO `faculty` (`id`, `description`, `name`, `phone_number`, `dean`, `university_id`) VALUES (NULL, 'opis fakulteta', 'Informacioni fakultet', '+381000000', '2', '1');
INSERT INTO `faculty` (`id`, `description`, `name`, `phone_number`, `dean`, `university_id`) VALUES (NULL, 'opis faxa ', 'Hotelijerstvo', '+381640000', '2', '1');


#===================
#STUDY_PROGRAMME INSERTS
#===================
INSERT INTO `study_programme` (`id`, `description`, `name`, `director`, `faculty_id`) VALUES (NULL, 'Struka softversko inzenjerstvo je mlada - prvi put se termin softversko inzenjerstvo pojavio 1968. godine, ali je danas u medjunarodnim okvirima jasno definisana kao posebna struka za kojom postoji izuzetno velika potražnja na medjunarodnom i domacem trzistu rada. ', 'Softversko inženjerstvo i informacione tehnologije', '2', '1');
INSERT INTO `study_programme` (`id`, `description`, `name`, `director`, `faculty_id`) VALUES (NULL, 'Neki tamo opis za IT smer', 'Informacione tehnologije', '2', '1');


#===================
#YEAR_OF_STUDY INSERTS
#===================
INSERT INTO `year_of_study` (`id`, `year`, `study_programme_id`) VALUES (NULL, '1', '1');
INSERT INTO `year_of_study` (`id`, `year`, `study_programme_id`) VALUES (NULL, '2', '1');

#===================
#SUBJECT INSERTS
#===================
INSERT INTO `subject` (`id`, `different_kind_of_lectures`, `espb`, `name`, `number_of_exercises`, `number_of_lectures`, `other_classes`, `required`, `research_work`) VALUES (NULL, '5', '8', 'Racunarkse mreze', '99', '99', '99', b'1', '10');

INSERT INTO `year_of_study_subject` (`professor_id`, `year_of_study_id`, `subject_id`) VALUES ('2', '1', '1');
INSERT INTO `year_of_study_subject` (`professor_id`, `year_of_study_id`, `subject_id`) VALUES ('2', '2', '1');

INSERT INTO `syllabus_outcome` (`id`, `description`, `period`, `sort`, `subject_id`) VALUES (NULL, 'Uvodna prica o predmetu. Tehnologija i mi', 'I nedelja ', '1', '1'), (NULL, 'Hardver', 'II nedelja ', '2', '1');


#===================
#STUDENT_YEAR_OF_STUDY INSERTS
#===================
INSERT INTO `student_year_of_study` (`id`, `student_id`, `year_of_study_id`) VALUES (NULL, 3, 1);


#===================
#EXAM_TYPE INSERTS
#===================
INSERT INTO `exam_type` (`id`, `name`) VALUES (NULL, 'Kolokvijum');
INSERT INTO `exam_type` (`id`, `name`) VALUES (NULL, 'Ispit');


#===================
#EXAM_PERIOD INSERTS
#===================
INSERT INTO `exam_period` (`id`, `name`, `start_time`, `end_time`, `exam_type_id`) VALUES (NULL, 'Februar I', '2019-02-01', '2019-02-07', 1);
INSERT INTO `exam_period` (`id`, `name`, `start_time`, `end_time`, `exam_type_id`) VALUES (NULL, 'Mart II', '2019-03-01', '2019-03-07', 1);
INSERT INTO `exam_period` (`id`, `name`, `start_time`, `end_time`, `exam_type_id`) VALUES (NULL, 'Jun I', '2019-06-01', '2019-06-07', 2);

