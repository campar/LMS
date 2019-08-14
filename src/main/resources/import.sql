
#LOCATION INSERTS
INSERT INTO country (id, name) VALUES (NULL, 'Serbia');
INSERT INTO city (id, name, country_id) VALUES (NULL, 'Novi Sad', 1);
INSERT INTO address (id, number, street, city_id) VALUES (NULL, '4a', 'Bulevar Mihajla Pupina', 1);

#UNIVERSITY INSERTS
INSERT INTO university (id, date_of_establishment, description, name, phone_number, address_id) VALUES (NULL, '2019-08-15 00:00:00', 'OPIS UNIVERZITETA', 'UNIVERZITET SINGIDUNUM', '+381 11 262 6474', 1);

#FACULTY INSERTS
INSERT INTO faculty (id, description, name, phone_number, university_id) VALUES (NULL, 'OPIS FAKULTETA', 'SII', '+381 11 262 6474', 1);
INSERT INTO faculty (id, description, name, phone_number, university_id) VALUES (NULL, 'OPIS FAKULTETA', 'IT', '+381 11 262 6474', 1);