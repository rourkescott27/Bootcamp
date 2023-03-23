--********************************************************************--
                          --Easy questions--
--********************************************************************--

--Show first name, last name, and gender of patients who's gender is 'M'
SELECT 
	first_name,
    last_name,
    gender
FROM patients
WHERE gender = 'M';

--Show first name and last name of patients who does not have allergies. (null)
SELECT 
	first_name,
    last_name
FROM patients
WHERE allergies IS NULL;

--Show first name of patients that start with the letter 'C'
SELECT 
	first_name
FROM patients
WHERE first_name LIKE 'C%';

--Show first name and last name of patients that weight within the range of 100 to 120 (inclusive)
SELECT
	first_name,
    last_name
FROM patients
WHERE weight BETWEEN 100 AND 120;

--Update the patients table for the allergies column. If the patient's allergies is null then replace it with 'NKA'
UPDATE patients
SET allergies = 'NKA'
WHERE allergies IS NULL;

--Show first name and last name concatinated into one column to show their full name.
SELECT 
	CONCAT(first_name, ' ', last_name) AS full_name
FROM patients;

--Show first name, last name, and the full province name of each patient. Example: 'Ontario' instead of 'ON
SELECT first_name, last_name, province_name
FROM patients
INNER JOIN province_names ON patients.province_id = province_names.province_id;

--Show how many patients have a birth_date with 2010 as the birth year.
SELECT COUNT(birth_date) AS total_patients
FROM patients
WHERE YEAR(birth_date) = 2010;

--Show the first_name, last_name, and height of the patient with the greatest height.
SELECT 
	first_name,
    last_name,
    MAX(height)
FROM patients;

--Show all columns for patients who have one of the following patient_ids: 1,45,534,879,1000
SELECT * FROM patients
WHERE patient_id IN (1, 45, 534, 879, 1000);

--Show the total number of admissions
SELECT COUNT(*) AS total_admissions
FROM admissions
WHERE YEAR(admission_date);

--Show all the columns from admissions where the patient was admitted and discharged on the same day.
SELECT *
FROM admissions
WHERE admission_date = discharge_date;

--Show the patient id and the total number of admissions for patient_id 579.
SELECT COUNT(*) AS total_admissions, 
	patient_id
FROM admissions
WHERE patient_id = 579;

--Based on the cities that our patients live in, show unique cities that are in province_id 'NS'?
SELECT DISTINCT city
FROM patients
WHERE province_id = 'NS';

--Write a query to find the first_name, last name and birth date of patients who has height greater than 160 and weight greater than 70
SELECT 
	first_name,
    last_name,
    birth_date
FROM patients
WHERE height > 160 AND weight > 70;

--Write a query to find list of patients first_name, last_name, and allergies from Hamilton where allergies are not null
SELECT 
	first_name,
    last_name,
    allergies
FROM patients
WHERE city = 'Hamilton' AND allergies IS not NULL;

--Based on cities where our patient lives in, write a query to display the list of unique city starting with a vowel (a, e, i, o, u). 
--Show the result order in ascending by city.
SELECT DISTINCT city
FROM patients
WHERE city LIKE 'A%'
OR	city LIKE 'E%'
OR 	city LIKE 'I%'
OR 	city like 'O%'
OR  city LIKE 'U%'
ORDER BY city ASC;


--********************************************************************--
                          --Medium questions--
--********************************************************************--

--Show unique birth years from patients and order them by ascending.
SELECT DISTINCT YEAR(birth_date)
FROM patients
ORDER BY birth_date ASC;

--Show unique first names from the patients table which only occurs once in the list.
--For example, if two or more people are named 'John' in the first_name column then don't include their name in the output list. 
--If only 1 person is named 'Leo' then include them in the output.
SELECT first_name
FROM patients
GROUP BY first_name 
HAVING COUNT(first_name) = 1;

--Show patient_id and first_name from patients where their first_name start and ends with 's' and is at least 6 characters long.
SELECT patient_id, first_name 
FROM patients 
WHERE first_name LIKE 's____%s';

--Show patient_id, first_name, last_name from patients whos diagnosis is 'Dementia'. Primary diagnosis is stored in the admissions table.
SELECT patients.patient_id, first_name, last_name
FROM patients
INNER JOIN admissions
ON patients.patient_id = admissions.patient_id
WHERE diagnosis LIKE 'Dementia';

--Display every patient's first_name. Order the list by the length of each name and then by alphbetically
SELECT first_name
FROM patients
ORDER by LENGTH(first_name),
	first_name ASC;
	
--Show the total amount of male patients and the total amount of female patients in the patients table. Display the two results in the same row.
SELECT
(SELECT count(*) from patients WHERE gender = 'M') as male_count,
(SELECT count(*) from patients WHERE gender = 'F') as female_count;

--Show first and last name, allergies from patients which have allergies to either 'Penicillin' or 'Morphine'. 
--Show results ordered ascending by allergies then by first_name then by last_name.
SELECT first_name, last_name, allergies
FROM patients
WHERE allergies IN('Penicillin', 'Morphine')
ORDER BY allergies, first_name ASC, last_name ASC;

--Show patient_id, diagnosis from admissions. Find patients admitted multiple times for the same diagnosis.
SELECT diagnosis, patient_id 
FROM admissions
GROUP BY patient_id, diagnosis
HAVING COUNT(*) > 1;

--Show the city and the total number of patients in the city. Order from most to least patients and then by city name ascending.
SELECT city, 
	   count(*) as total_patients
FROM patients
GROUP By city
ORDER BY total_patients DESC, city ASC;

--Show first name, last name and role of every person that is either patient or doctor. The roles are either "Patient" or "Doctor"
SELECT first_name, last_name, 'Patient' AS ROLE FROM patients
UNION ALL
SELECT first_name, last_name, 'Doctor' AS ROLE FROM doctors;

--Show all allergies ordered by popularity. Remove NULL values from query.
SELECT 
allergies,
COUNT(*) as total_diagnosis
FROM patients
WHERE 
	allergies IS NOT NULL
GROUP BY allergies
ORDER BY total_diagnosis DESC;

--Show all patient's first_name, last_name, and birth_date who were born in the 1970s decade. Sort the list starting from the earliest birth_date.
SELECT first_name, last_name, birth_date
FROM patients
WHERE 
	YEAR(birth_date) BETWEEN 1970 AND 1979
ORDER BY birth_date;

--We want to display each patient's full name in a single column. Their last_name in all upper letters must appear first, then first_name in all lower case letters. 
--Separate the last_name and first_name with a comma. Order the list by the first_name in decending order EX: SMITH,jane
SELECT 
CONCAT(UPPER(last_name), ',', LOWER(first_name)) AS new_name
FROM patients
ORDER BY first_name DESC;






















