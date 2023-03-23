--chapter7
--Natural key example
CREATE TABLE natural_key_example (
license_id varchar(10) CONSTRAINT license_key PRIMARY KEY,
first_name varchar(50),
last_name varchar(50)
);

INSERT INTO natural_key_example (license_id, first_name, last_name)
VALUES ('T229901', 'Lynn', 'Malero');

--Composite primary key example
CREATE TABLE natural_key_composite_example (
student_id varchar(10),
school_day date,
present boolean,
CONSTRAINT student_key PRIMARY KEY (student_id, school_day)
);

INSERT INTO natural_key_composite_example (student_id, school_day, present)
VALUES(775, '2017/1/22', 'Y');

INSERT INTO natural_key_composite_example (student_id, school_day, present)
VALUES(775, '2017/1/23', 'Y');

INSERT INTO natural_key_composite_example (student_id, school_day, present)
VALUES(775, '2017/1/23', 'N');

--Auto incrementing surrogate key example
CREATE TABLE surrogate_key_example (
order_number bigserial,
product_name varchar(50),
order_date date,
CONSTRAINT order_key PRIMARY KEY (order_number)
);

INSERT INTO surrogate_key_example (product_name, order_date)
VALUES ('Beachball Polish', '2015-03-17'),
('Wrinkle De-Atomizer', '2017-05-22'),
('Flux Capacitor', '1985-10-26');

SELECT * FROM surrogate_key_example;

--Foreign key example
CREATE TABLE licenses (
license_id varchar(10),
first_name varchar(50),
last_name varchar(50),
CONSTRAINT licenses_key PRIMARY KEY (license_id)
);

CREATE TABLE registrations (
registration_id varchar(10),
registration_date date,
license_id varchar(10) REFERENCES licenses (license_id),
CONSTRAINT registration_key PRIMARY KEY (registration_id, license_id)
);

INSERT INTO licenses (license_id, first_name, last_name)
VALUES ('T229901', 'Lynn', 'Malero');

INSERT INTO registrations (registration_id, registration_date, license_id)
VALUES ('A203391', '2017/3/17', 'T229901');

INSERT INTO registrations (registration_id, registration_date, license_id)
VALUES ('A75772', '2017/3/17', 'T000001');

--CASCADE: Have not yet run this table
CREATE TABLE registrations (
registration_id varchar(10),
registration_date date,
license_id varchar(10) REFERENCES licenses (license_id) ON DELETE CASCADE,
CONSTRAINT registration_key PRIMARY KEY (registration_id, license_id)
);

--CHECK constraint example
CREATE TABLE check_constraint_example (
user_id bigserial,
user_role varchar(50),
salary integer,
CONSTRAINT user_id_key PRIMARY KEY (user_id),
CONSTRAINT check_role_in_list CHECK (user_role IN('Admin', 'Staff')),
CONSTRAINT check_salary_not_zero CHECK (salary > 0)
);

INSERT INTO check_constraint_example (user_role, salary)
VALUES('Admin', 0);

--UNIQUE constraint example
CREATE TABLE unique_constraint_example (
contact_id bigserial CONSTRAINT contact_id_key PRIMARY KEY,
first_name varchar(50),
last_name varchar(50),
email varchar(200),
CONSTRAINT email_unique UNIQUE (email)
);

INSERT INTO unique_constraint_example (first_name, last_name, email)
VALUES ('Samantha', 'Lee', 'slee@example.org');

INSERT INTO unique_constraint_example (first_name, last_name, email)
VALUES ('Betty', 'Diaz', 'bdiaz@example.org');

INSERT INTO unique_constraint_example (first_name, last_name, email)
VALUES ('Sasha', 'Lee', 'slee@example.org');

--NOT NULL constraint example
CREATE TABLE not_null_example (
student_id bigserial,
first_name varchar(50),
last_name varchar(50) NOT NULL,
CONSTRAINT student_id_key PRIMARY KEY (student_id)
);

INSERT INTO not_null_example(last_name)
VALUES ('Smith');

SELECT * FROM not_null_example;

--B-Tree Example
CREATE TABLE new_york_addresses (
longitude numeric(9,6),
latitude numeric(9,6),
street_number varchar(10),
street varchar(32),
unit varchar(7),
postcode varchar(5),
id integer CONSTRAINT new_york_key PRIMARY KEY
);

COPY new_york_addresses
FROM 'C:\Users\Rourke Scott\Desktop\postgresql\practical-sql-main\Chapter_07\city_of_new_york.csv'
WITH (FORMAT CSV, HEADER);

SELECT * FROM new_york_addresses;

EXPLAIN ANALYZE SELECT * FROM new_york_addresses
WHERE street = 'BROADWAY';

CREATE INDEX street_idx ON new_york_addresses (street);

--try it yourself 1
CREATE TABLE albums (
 album_id bigserial CONSTRAINT album_id_key PRIMARY KEY (album_id),
 album_catalog_code varchar(100),
 album_title text NOT NULL,
 album_artist text NOT NULL,
 album_release_date date CONSTRAINT release_date_check CHECK (album_release_date > '1/1/1925'),
 album_genre varchar(40),
 album_description text
);
CREATE TABLE songs (
 song_id bigserial CONSTRAINT song_id_key PRIMARY KEY (song_id),
 song_title text NOT NULL,
 song_artist text NOT NULL,
 album_id bigint REFERENCES albums (album_id)
);

----FROM TRY IT YOURSELF SOURCE CODE----
-- Answers:
-- a) Both tables get a primary key using surrogate key id values that are
-- auto-generated via serial data types.

-- b) The songs table references albums via a foreign key constraint.

-- c) In both tables, the title and artist columns cannot be empty, which
-- is specified via a NOT NULL constraint. We assume that every album and
-- song should at minimum have that information.

-- d) In albums, the album_release_date column has a CHECK constraint
-- because it would be likely impossible for us to own an LP made before 1925.

--try it yourself 2
-- Answer:
-- We could consider the album_catalog_code. We would have to answer yes to
-- these questions:
-- - Is it going to be unique across all albums released by all companies?
-- - Will we always have one?

--try it yourself 3
-- Answer:
-- Primary key columns get indexes by default, but we should add an index
-- to the album_id foreign key column in the songs table because we'll use
-- it in table joins. It's likely that we'll query these tables to search
-- by titles and artists, so those columns in both tables should get indexes
-- too. The album_release_date in albums also is a candidate if we expect
-- to perform many queries that include date ranges.