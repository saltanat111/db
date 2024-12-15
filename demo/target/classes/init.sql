CREATE SCHEMA IF NOT EXISTS markJoulnal;
USE markJoulnal;

DROP TABLE IF EXISTS admins;
CREATE TABLE admins (id BIGINT PRIMARY KEY AUTO_INCREMENT,admin_username VARCHAR(80),admin_password VARCHAR(80));
INSERT INTO admins (admin_username,admin_password) VALUES ('admin','admin123');

DROP TABLE IF EXISTS teachers;
CREATE TABLE teachers (id BIGINT PRIMARY KEY AUTO_INCREMENT,teacher_username VARCHAR(80),teacher_password VARCHAR(80),teacher_course VARCHAR(80),teacher_course_id INTEGER);
INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES ('Nadejda Kirillovna','teacher123N','history',1);
INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES ('Jazgul Annazarova','teacher123J','biology',2);
INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES ('Elchibek Kerimbaev','teacher123E','physics',3);
INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES ('Diana Nusratullaeva','teacher123D','math',4);
INSERT INTO teachers (teacher_username,teacher_password,teacher_course,teacher_course_id) VALUES ('Aygerim Melisovna','teacher123A','geography',5);


DROP TABLE IF EXISTS parents;
CREATE TABLE parents (id BIGINT PRIMARY KEY AUTO_INCREMENT,parent_username VARCHAR(80),parent_password VARCHAR(80),student_id INTEGER);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Andrey Bolkonskiy','parent123A',1);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Pyer Bezuhov','parent123P',2);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Natasha Rostova','parent123N',3);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Chadskiy Alecksandr','parent123C',4);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Grigoriy Pechorin','parent123G',5);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Tatyana Larina','parent123T',6);
INSERT INTO parents (parent_username,parent_password,student_id) VALUES ('Elizabet Bennet','parent123E',7);


DROP TABLE IF EXISTS  students;
CREATE TABLE students (id BIGINT PRIMARY KEY AUTO_INCREMENT,student_id INTEGER,student_username VARCHAR(80),student_password VARCHAR(80));
INSERT INTO students (student_id,student_username,student_password) VALUES (1,'Arina Petrovna','student123A');
INSERT INTO students (student_id,student_username,student_password) VALUES (2,'Irina Lisitsina','student123I');
INSERT INTO students (student_id,student_username,student_password) VALUES (3,'Nastya Alekseevna','student123N');
INSERT INTO students (student_id,student_username,student_password) VALUES (4,'Elen Kuragina','student123E');
INSERT INTO students (student_id,student_username,student_password) VALUES (5,'Vera Nickolaevna','student123V');
INSERT INTO students (student_id,student_username,student_password) VALUES (6,'Mariya Ostrovskaya','student123M');
INSERT INTO students (student_id,student_username,student_password) VALUES (7,'Sofya Kovalevskaya','student123S');

DROP TABLE IF EXISTS marks;
CREATE TABLE marks (id BIGINT PRIMARY key AUTO_INCREMENT,student_id INTEGER,teacher_course VARCHAR(80),mark INT);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (1,'history',89);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (1,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (1,'biology',92);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (1,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (1,'geography',97);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (2,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (2,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (2,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (2,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (2,'geography',91);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (3,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (3,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (3,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (3,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (3,'geography',91);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (4,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (4,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (4,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (4,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (4,'geography',91);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (5,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (5,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (5,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (5,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (5,'geography',91);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (6,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (6,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (6,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (6,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (6,'geography',91);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (7,'history',96);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (7,'physics',100);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (7,'biology',94);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (7,'math',98);
INSERT INTO marks (student_id,teacher_course,mark) VALUES (7,'geography',91);