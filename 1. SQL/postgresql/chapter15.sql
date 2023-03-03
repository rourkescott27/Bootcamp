-- Chapter 15--
-- Using Views to Simplify Queries --
-- Creating and Querying Views --
CREATE OR REPLACE VIEW nevada_counties_pop_2010 AS
	SELECT geo_name,
		   state_fips,
		   county_fips,
		   p0010001 AS pop_2010
	FROM us_counties_2010
	WHERE state_us_abbreviation = 'NV'
	ORDER BY county_fips;
	
SELECT *
FROM nevada_counties_pop_2010;

--------------------------------------------
CREATE OR REPLACE VIEW county_pop_change_2010_2000 AS
	SELECT c2010.geo_name,
		   c2010.state_us_abbreviation AS st,
		   c2010.state_fips,
		   c2010.county_fips,
		   c2010.p0010001 AS pop_2010,
		   c2000.p0010001 AS pop_2000,
		   round( (CAST(c2010.p0010001 AS numeric(8,1)) - c2000.p0010001)
				/ c2000.p0010001 * 100, 1 ) AS pct_change_2010_2000
FROM us_counties_2010 c2010 INNER JOIN us_counties_2000 c2000
ON c2010.state_fips = c2000.state_fips
AND c2010.county_fips = c2000.county_fips
ORDER BY c2010.state_fips, c2010.county_fips;

SELECT geo_name,
	   st,
	   pop_2010,
	   pct_change_2010_2000
FROM county_pop_change_2010_2000
WHERE st = 'NV'
LIMIT 5;

-- Inserting, Updating, and Deleting Data Using a View --
-- Creating a View of Employees --
CREATE OR REPLACE VIEW employees_tax_dept AS
	SELECT emp_id,
		   first_name,
		   last_name,
		   dept_id
FROM employees
WHERE dept_id = 1
ORDER BY emp_id
WITH LOCAL CHECK OPTION;

SELECT * FROM employees_tax_dept;
SELECT * FROM employees;

-- Inserting Rows Using the employees_tax_dept View --
INSERT INTO employees_tax_dept (first_name, last_name, dept_id)
VALUES ('Suzanne', 'Legere', 1);

INSERT INTO employees_tax_dept (first_name, last_name, dept_id)
VALUES ('Jamil', 'White', 2);

-- Updating Rows Using the employees_tax_dept View --
UPDATE employees_tax_dept
SET last_name = 'Le Gere'
WHERE emp_id = 5;

SELECT * FROM employees_tax_dept;

-- Deleting Rows Using the employees_tax_dept View --
DELETE FROM employees_tax_dept
WHERE emp_id = 5;

-- Programming Your Own Functions --
-- Creating the percent_change() Function --
CREATE OR REPLACE FUNCTION
percent_change(new_value numeric,
			   old_value numeric,
			   decimal_places integer DEFAULT 1)
RETURNS numeric AS
'SELECT round(
		((new_value - old_value) / old_value) * 100, decimal_places
);'
LANGUAGE SQL
IMMUTABLE
RETURNS NULL ON NULL INPUT;

-- Using the percent_change() Function --
SELECT percent_change(110, 108, 2);
---- Percentage part of this SELECT is no longer needed 
---- as we created a function to do that for us
SELECT c2010.geo_name,
	   c2010.state_us_abbreviation AS st,
	   c2010.p0010001 AS pop_2010,
	   percent_change(c2010.p0010001, c2000.p0010001) AS pct_chg_func,
	   round( (CAST(c2010.p0010001 AS numeric(8,1)) - c2000.p0010001)
			/ c2000.p0010001 * 100, 1 ) AS pct_chg_formula
FROM us_counties_2010 c2010 INNER JOIN us_counties_2000 c2000
ON c2010.state_fips = c2000.state_fips
	AND c2010.county_fips = c2000.county_fips

ORDER BY pct_chg_func DESC
LIMIT 5;

-- Updating Data with a Function --
ALTER TABLE teachers ADD COLUMN personal_days integer;

SELECT first_name,
	   last_name,
	   hire_date,
	   personal_days
FROM teachers;

CREATE OR REPLACE FUNCTION update_personal_days()
RETURNS void AS $$
BEGIN
	UPDATE teachers
	SET personal_days =
		CASE WHEN (now() - hire_date) BETWEEN '5 years'::interval
									  AND '10 years'::interval THEN 4
		WHEN (now() - hire_date) > '10 years'::interval THEN 5
		ELSE 3
	END;
RAISE NOTICE 'personal_days updated!';
END;
$$ LANGUAGE plpgsql;

SELECT update_personal_days();

SELECT * FROM teachers;

-- Automating Database Actions with Triggers --
-- Logging Grade Updates to a Table --
-- Creating Tables to Track Grades and Updates --
CREATE TABLE grades (
	student_id bigint,
	course_id bigint,
	course varchar(30) NOT NULL,
	grade varchar(5) NOT NULL,
PRIMARY KEY (student_id, course_id)
);

INSERT INTO grades
VALUES
	(1, 1, 'Biology 2', 'F'),
	(1, 2, 'English 11B', 'D'),
	(1, 3, 'World History 11B', 'C'),
	(1, 4, 'Trig 2', 'B');

CREATE TABLE grades_history (
	student_id bigint NOT NULL,
	course_id bigint NOT NULL,
	change_time timestamp with time zone NOT NULL,
	course varchar(30) NOT NULL,
	old_grade varchar(5) NOT NULL,
	new_grade varchar(5) NOT NULL,
PRIMARY KEY (student_id, course_id, change_time)
);

-- Creating the Function and Trigger --
CREATE OR REPLACE FUNCTION record_if_grade_changed()
	RETURNS trigger AS
$$
BEGIN
	IF NEW.grade <> OLD.grade THEN
	INSERT INTO grades_history (
		student_id,
		course_id,
		change_time,
		course,
		old_grade,
		new_grade)
	VALUES
		(OLD.student_id,
		 OLD.course_id,
		 now(),
		 OLD.course,
		 OLD.grade,
		 NEW.grade);
	END IF;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER grades_update
 AFTER UPDATE
  ON grades
 FOR EACH ROW
 EXECUTE PROCEDURE record_if_grade_changed();
 
SELECT * FROM grades;

SELECT * FROM grades_history;

-- Testing the Trigger --
UPDATE grades
SET grade = 'C'
WHERE student_id = 1 AND course_id = 1;

-- Automatically Classifying Temperatures --
CREATE TABLE temperature_test (
	station_name varchar(50),
	observation_date date,
	max_temp integer,
	min_temp integer,
	max_temp_group varchar(40),
PRIMARY KEY (station_name, observation_date)
);

CREATE OR REPLACE FUNCTION classify_max_temp()
	RETURNS trigger AS
$$
BEGIN
	CASE
		WHEN NEW.max_temp >= 90 THEN
			NEW.max_temp_group := 'Hot';
		WHEN NEW.max_temp BETWEEN 70 AND 89 THEN
			NEW.max_temp_group := 'Warm';
		WHEN NEW.max_temp BETWEEN 50 AND 69 THEN
			NEW.max_temp_group := 'Pleasant';
		WHEN NEW.max_temp BETWEEN 33 AND 49 THEN
			NEW.max_temp_group := 'Cold';
		WHEN NEW.max_temp BETWEEN 20 AND 32 THEN
			NEW.max_temp_group := 'Freezing';
		ELSE NEW.max_temp_group := 'Inhumane';
	END CASE;
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER temperature_insert
	BEFORE INSERT
	ON temperature_test
	FOR EACH ROW
	EXECUTE PROCEDURE classify_max_temp();
	
INSERT INTO temperature_test (station_name, observation_date, max_temp, min_temp)
VALUES
	('North Station', '1/19/2019', 10, -3),
	('North Station', '3/20/2019', 28, 19),
	('North Station', '5/2/2019', 65, 42),
	('North Station', '8/9/2019', 93, 74);
	
SELECT * FROM temperature_test;

SHOW datestyle;

SET datestyle = "ISO, MDY";
----------------------------------------------------------------------------
----------------------------------------------------------------------------
--try it yourself 1--                                                    ---
CREATE OR REPLACE VIEW taxi_trips_per_hour AS                            ---
SELECT                                                                   ---
	date_part('hour', tpep_pickup_datetime) AS trip_hour,
 	count(*)
FROM nyc_yellow_taxi_trips_2016_06_01
GROUP BY trip_hour
ORDER BY trip_hour;

SELECT * FROM taxi_trips_per_hour;

--try it yourself 2--
-- rates_per_thousand = (observed_number/base_number) * 1000
CREATE OR REPLACE FUNCTION
rates_per_thousand(observed_number numeric,
			       base_number numeric,
			   	   decimal_places integer DEFAULT 1)
RETURNS numeric AS
'SELECT round(
		(observed_number / base_number)  * 1000, decimal_places
);'
LANGUAGE SQL
IMMUTABLE
RETURNS NULL ON NULL INPUT;

SELECT rates_per_thousand(1534, 500000, 2);

SELECT
	st,
	city,
	population,
	rates_per_thousand(burglary::numeric, population) AS burglary_per_thousand
FROM fbi_crime_data_2015
WHERE population >= 500000
ORDER BY burglary_per_thousand DESC;


--try it yourself 3--
ALTER TABLE meat_poultry_egg_inspect ADD COLUMN inspection_date date;

CREATE OR REPLACE FUNCTION add_inspection_date
RETURN trigger AS
$$
BEGIN
	NEW.inspection_date = now() + ('6 months'::interval)
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER inspection_date_update
BEFORE INSERT
ON inspection_date
FOR EACH ROW 
EXECUTE PROCEDURE add_inspection_date();

INSERT INTO meat_poultry_egg_inspect(est_number, company)
VALUES ('test123', 'testcompany');

SELECT * FROM meat_poultry_egg_inspect
WHERE company = 'testcompany';




























SELECT * FROM meat_poultry_egg_inspect;
