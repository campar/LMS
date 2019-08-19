	#===================
	#LOCATION INSERTS
	#===================
INSERT INTO `country` (`id`, `name`) VALUES (NULL, 'Serbia');
INSERT INTO `country` (`id`, `name`) VALUES (NULL, 'Montenegro');

INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'NS', '1');
INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'BG', '1');
INSERT INTO `city` (`id`, `name`, `country_id`) VALUES (NULL, 'PG', '2');

INSERT INTO `address` (`id`, `number`, `street`, `city_id`) VALUES (NULL, '13', 'Nova BB', '1');


INSERT INTO `year_of_study` (`id`, `godina`, `study_programme_id`) VALUES (NULL, '1', '1');
INSERT INTO `year_of_study` (`id`, `godina`, `study_programme_id`) VALUES (NULL, '2', '1');

	#===================
	#SUBJECT INSERTS
	#===================
INSERT INTO `subject` (`id`, `different_kind_of_lectures`, `espb`, `name`, `number_of_exercises`, `number_of_lectures`, `other_classes`, `required`, `research_work`) VALUES (NULL, '5', '8', 'Racunarkse mreze', '99', '99', '99', b'1', '10');



INSERT INTO `year_of_study_subject` (`year_of_study_id`, `subject_id`) VALUES ('1', '1');


INSERT INTO `syllabus_outcome` (`id`, `description`, `period`, `sort`, `subject_id`) VALUES (NULL, 'Uvodna priča o predmetu. Tehnologija i mi', 'I nedelja ', '1', '1'), (NULL, 'Hardver', 'II nedelja ', '2', '1');


	#===================
	#PROFESSOR STUFF INSERTS
	#===================
INSERT INTO `users` (`id`, `email`, `password`, `role`, `username`) VALUES (NULL, 'email@gmail.com', 'profesor', 'ROLE_PROFESSOR', 'zvonko123');
INSERT INTO `scientific_field` (`id`, `name`) VALUES ('1', 'Matematicke Nauke');
INSERT INTO `professor_title` (`id`, `date_end`, `date_start`, `name`, `field_id`) VALUES ('1', '2019-08-01 00:00:00', '2019-08-02 00:00:00', 'Master matematicar', '1');
INSERT INTO `professor` (`biography`, `jmbg`, `name`, `id`, `title_id`) VALUES ('Cao, ja sam zvonko i master sam matematika', '9999999999', 'Zvonko', '1', '1');




	#===================
	#UNIVERSITY INSERTS
	#===================
INSERT INTO `university` (`id`, `date_of_establishment`, `description`, `name`, `phone_number`, `address_id`, `rector`) VALUES (NULL, '2017-12-06 00:00:00', 'OPIS UNIVERZITETA', 'UNIVERZITET SINGIDUNUM', '+381 11 262 6474', '1', '1');


	#===================
	#FACULTY INSERTS
	#===================
INSERT INTO `faculty` (`id`, `description`, `name`, `phone_number`, `dean`, `university_id`) VALUES (NULL, 'opis fakulteta', 'SII', '+381000000', '1', '1');					
INSERT INTO `faculty` (`id`, `description`, `name`, `phone_number`, `dean`, `university_id`) VALUES (NULL, 'kada savladate fakultet internet tehnologija znacete da korisite internete', 'IT', '+381640000', '1', '1');

	#===================
	#STUDY_PROGRAMME  INSERTS
	#===================
INSERT INTO `study_programme` (`id`, `description`, `name`, `director`, `faculty_id`) VALUES (NULL, 'Struka softversko inženjerstvo je mlada - prvi put se termin softversko inženjerstvo pojavio 1968. godine, ali je danas u međunarodnim okvirima jasno definisana kao posebna struka za kojom postoji izuzetno velika potražnja na međunarodnom i domaćem tržištu rada. ', 'Softversko inženjerstvo i informacione tehnologije', '1', '1');



	#===================
	#YEAR_OF_STUDY  INSERTS
	#===================
INSERT INTO `year_of_study` (`id`, `godina`, `study_programme_id`) VALUES (NULL, '1', '1');

INSERT INTO `year_of_study_subject` (`year_of_study_id`, `subject_id`) VALUES ('3', '1');

