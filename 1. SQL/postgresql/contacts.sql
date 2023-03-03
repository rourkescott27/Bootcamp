--contacts--

CREATE TABLE my_contacts (
	contact_id bigserial CONSTRAINT contact_id_key PRIMARY KEY,
	last_name varchar(30) NOT NULL,
	first_name varchar(30) NOT NULL,
	gender char(1) NOT NULL,
	phone varchar(10) UNIQUE NOT NULL,
	email varchar(30) UNIQUE NOT NULL,
	zip_code_id bigint REFERENCES zip_codes (zip_code_id) ON DELETE CASCADE,
	status_id bigint REFERENCES statuses (status_id) ON DELETE CASCADE,
	profession_id bigint REFERENCES professions (profession_id) ON DELETE CASCADE
);

INSERT INTO my_contacts
(	last_name,
	first_name,
	gender,
	phone,
	email,
	zip_code_id,
	status_id,
	profession_id
)

VALUES
	('Tom','Smith','F','0780615009','tom@gmail.com',1 ,1 ,1 ),
    ('Gugu','Ndaba','F','0780615012','gugu@gmail.com',2 ,2 ,2),
    ('Jo','Nala','M','0780615078','jo@gmail.com',1 ,1 ,3 ),
    ('Mary','Smith','F','0610615009','mary@gmail.com',2 ,2 ,4 ),
    ('Kyle','Koo','M','0710615009','kyle@gmail.com',1 ,2 ,1 ),
    ('Sizwe','Nchabe','M','0840615099','sizwe@gmail.com',3 ,1 ,3 ),
    ('Liz','Sun','F','0830777009','liz@gmail.com',3 ,1 ,2 );

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM my_contacts;  ---------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE my_contacts;     ---------------------------------------------------------------------------------------------------------------------------------------------------------
DELETE  FROM my_contacts;   ---------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE zip_codes;       ---------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE statuses;        ---------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE contact_seeking; ---------------------------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE contact_interest;---------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE zip_codes
(
	zip_code_id bigserial CONSTRAINT zip_code_id_key PRIMARY KEY,
	zip_code char(11) NOT NULL,
	city varchar(30) NOT NULL,
	state_name varchar(30) NOT NULL,
	state_abbr char(2)NOT NULL
);

INSERT INTO zip_codes
(
	zip_code,
	city,
	state_name,
	state_abbr 
)

VALUES
	('36013-36191','Mongomery','Alabama','AL'),
	('99703-99781','Fairbanks','Alaska','AK'),
	('85641-85705','Tucson','Arizona','AR');
	
SELECT 
FROM my_contacts AS mc
JOIN zip_codes AS zc
ON mc.zip_code_id = zc.zip_code_id;

SELECT mc.last_name, mc.first_name, zc.zip_code_id, zc.city, zc.state_name 
FROM my_contacts AS mc
JOIN zip_codes zc
ON mc.zip_code_id = zc.zip_code_id;
	
SELECT * FROM zip_codes;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE professions
(
	profession_id bigserial CONSTRAINT profession_id_key PRIMARY KEY,
	profession varchar(30) UNIQUE NOT NULL
);

INSERT INTO professions
(
	profession
)

VALUES
	('doctor'),
	('teacher'),
	('software developer'),
	('student');
	
SELECT mc.last_name, mc.first_name, prof.profession
FROM my_contacts AS mc
JOIN professions AS prof
ON mc.profession_id = prof.profession_id;

SELECT * FROM professions;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE statuses
(
	status_id bigserial CONSTRAINT status_id_key PRIMARY KEY,
	status varchar(30) UNIQUE NOT NULL
);

INSERT INTO statuses
(
	status
)

VALUES 
	('single'),
	('divorced');
	
SELECT mc.last_name, mc.first_name, sta.status
FROM my_contacts AS mc
JOIN statuses AS sta
ON mc.status_id = sta.status_id;

SELECT * FROM statuses;

DROP TABLE statuses;	

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE seekings
(
	seeking_id bigserial CONSTRAINT seeking_id_key PRIMARY KEY,
	seeking varchar(50) NOT NULL UNIQUE
)

INSERT INTO seekings
(
	seeking
)

VALUES
('single male'),
('single female'),
('same profession'),
('employed'),
('student'),
('retired'),
('over 50'),
('under 25'),
('under 50');

SELECT * FROM seekings;

---------------------------------------------------------------------------------------------

CREATE TABLE contact_seeking
(
	contact_id bigint NOT NULL REFERENCES my_contacts(contact_id) ON DELETE CASCADE,
	seeking_id bigint NOT NULL REFERENCES seekings(seeking_id) ON DELETE CASCADE
)
 
INSERT INTO contact_seeking
 (
	 contact_id,
	 seeking_id 
 )
 
VALUES
	(1,1),
	(1,3),
	(1,7),
	(2,1),
	(2,4),
	(3,1),
	(3,3),
	(3,5),
	(3,6),
	(4,1),
	(5,2),
	(6,1),
	(6,3),
	(7,2);

SELECT mc.first_name, mc.last_name, s.seeking
FROM my_contacts AS mc
JOIN contact_seeking AS cs
ON cs.contact_id = mc.contact_id
JOIN seekings AS s
ON s.seeking_id = cs.seeking_id;

SELECT * FROM contact_seeking;
DELETE FROM contact_seeking;
DROP TABLE contact_seeking;

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE interests
(
	interest_id bigserial CONSTRAINT interest_id_key PRIMARY KEY,
	interest varchar(50) NOT NULL UNIQUE
)

INSERT INTO interests
(
	interest
)
 
VALUES
	('hiking'),
	('reading'),
	('biking'),
	('cooking'),
	('running'),
	('diving'),
	('studying'),
	('cycling'),
	('art'),
    ('walking');

SELECT * FROM interests;

-----------------------------------------------------------------------------------------------

CREATE TABLE contact_interest
(
	contact_id bigint NOT NULL REFERENCES my_contacts(contact_id) ON DELETE CASCADE,
	interest_id bigint NOT NULL REFERENCES interests(interest_id) ON DELETE CASCADE
)

INSERT INTO contact_interest
(
	contact_id,
	interest_id
)

VALUES 
	(1,1),
	(1,3),
	(2,4),
	(2,5),
	(3,1),
	(3,3),
	(3,6),
	(4,2),
	(4,7),
	(5,9),
	(5,8),
	(6,1),
	(6,3),
	(7,10);
	
SELECT mc.first_name, mc.last_name, i.interest
FROM my_contacts AS mc
JOIN contact_interest AS ci
ON mc.contact_id = ci.contact_id
JOIN interests AS i
ON i.interest_id = ci.interest_id;	


SELECT * FROM  contact_interest;
DELETE FROM contact_interest;
DROP TABLE contact_interest;

    
    








