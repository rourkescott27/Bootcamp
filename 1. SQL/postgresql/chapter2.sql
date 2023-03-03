SELECT * FROM teachers;

SELECT first_name,last_name 
FROM teachers
WHERE last_name = 'Smith';

SELECT last_name, first_name, 
salary FROM teachers;

SELECT DISTINCT school
FROM teachers;

SELECT DISTINCT school, salary
FROM teachers;

SELECT first_name, last_name, salary
FROM teachers
ORDER BY salary DESC;

SELECT last_name, school, hire_date
FROM teachers
ORDER BY school ASC, hire_date DESC;

SELECT last_name, school, hire_date
FROM teachers
WHERE school = 'Myers Middle School';

SELECT first_name, last_name, school
FROM teachers
WHERE first_name = 'Janet';

SELECT school
FROM teachers
WHERE school != 'F.D. Roosevelt HS';

SELECT first_name, last_name, hire_date
FROM teachers
WHERE hire_date < '2000-01-01';

SELECT first_name, last_name, salary
FROM teachers
WHERE salary >= 43500;

SELECT first_name, last_name, school, salary
FROM teachers
WHERE salary BETWEEN 40000 AND 65000;

SELECT first_name 
FROM teachers
WHERE first_name LIKE 'sam%';

SELECT first_name
FROM teachers
WHERE first_name ILIKE 'sam%';

SELECT *
FROM teachers
WHERE school = 'Myers Middle School'
      AND salary < 40000;

SELECT *
FROM teachers
WHERE last_name = 'Cole'
      OR last_name = 'Bush';

SELECT *
FROM teachers
WHERE school = 'F.D. Roosevelt'
      AND (salary < 38000 OR salary > 40000);
	  
SELECT first_name, last_name, school, hire_date, salary
FROM teachers
WHERE school LIKE '%Roos%'
ORDER BY hire_date DESC;

--try it yourself 1
SELECT school, last_name
FROM teachers
ORDER BY school DESC, last_name ASC;

--try it yourself 2
SELECT *
FROM teachers
WHERE first_name ILIKE 's%'
AND salary > 40000;

--try it yourself 3
SELECT *
FROM teachers
WHERE hire_date >= '2010-01-01'
ORDER BY salary DESC;

