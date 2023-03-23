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

--Show the province_id(s), sum of height; where the total sum of its patient's height is greater than or equal to 7,000.
SELECT 
	province_id, 
    SUM(height) AS sum_height
FROM patients
GROUP BY province_id
HAVING sum_height >= 7000;

--Show the difference between the largest weight and smallest weight for patients with the last name 'Maroni'
SELECT MAX(weight) - MIN(weight) AS weight_diff
FROM patients
WHERE last_name = 'Maroni';

--Show all of the days of the month (1-31) and how many admission_dates occurred on that day. Sort by the day with most admissions to least admissions.
SELECT
	DAY(admission_date) AS day_number,
    COUNT(*) as number_of_admissions
FROM admissions
GROUP by day_number
ORDER BY number_of_admissions DESC;

--Show all columns for patient_id 542's most recent admission_date.
SELECT *
FROM admissions
WHERE patient_id = 542
GROUP BY patient_id
HAVING 
	admission_date = MAX(admission_date);
	

--Show patient_id, attending_doctor_id, and diagnosis for admissions that match one of the two criteria:
--1. patient_id is an odd number and attending_doctor_id is either 1, 5, or 19.
--2. attending_doctor_id contains a 2 and the length of patient_id is 3 characters.
SELECT
	patient_id,
    attending_doctor_id,
    diagnosis
FROM admissions
WHERE 
	(
      attending_doctor_id IN (1, 5, 19)
      AND patient_id %2 !=0
      )
      or
      (
        attending_doctor_id LIKE '%2%'
        AND LEN(patient_id) = 3
      );
	  
--Show first_name, last_name, and the total number of admissions attended for each doctor. Every admission has been attended by a doctor.
SELECT 
	first_name,
    last_name,
    COUNT (*) AS total_admissions
FROM admissions adms
	INNER JOIN doctors dc
    ON dc.doctor_id = adms.attending_doctor_id
GROUP BY attending_doctor_id;

--For each doctor, display their id, full name, and the first and last admission date they attended.
SELECT 
	doctor_id,
	(first_name || ' '|| last_name),
    MIN(admission_date) AS first_admission,
    MAX(admission_date) AS last_admission
FROM admissions a 
	INNER JOIN doctors d
    ON a.attending_doctor_id = d.doctor_id
GROUP BY doctor_id;

--Display the total amount of patients for each province. Order by descending.
SELECT 
	province_name,
    COUNT(*) as patient_count
FROM patients pid
	JOIN province_names pn
    ON pn.province_id = pid.province_id
GROUP BY pid.province_id
ORDER BY patient_count DESC;

--For every admission, display the patient's full name, their admission diagnosis, and their doctor's full name who diagnosed their problem
SELECT 
	CONCAT(pid.first_name,' ',pid.last_name) AS patient_name,
    CONCAT(dr.first_name,' ', dr.last_name) AS docter_name,
    diagnosis 
FROM patients pid
	INNER join admissions adms
    ON adms.patient_id = pid.patient_id
    INNER JOIN doctors dr
    ON dr.doctor_id = adms.attending_doctor_id;

--Display the number of duplicate patients based on their first_name and last_name.
SELECT 
	first_name, 
    last_name,
    COUNT(*) AS num_of_duplicates
FROM patients
GROUP BY 
	first_name,
    last_name
HAVING COUNT(*) > 1;

--Display patient's full name,
--height in the units feet rounded to 1 decimal,
--weight in the unit pounds rounded to 0 decimals,
--birth_date,
--gender non abbreviated.

--Convert CM to feet by dividing by 30.48.
--Convert KG to pounds by multiplying by 2.205.
SELECT CONCAT(first_name, ' ', last_name) AS full_name,
ROUND(height/30.48, 1) AS height_in_feet,
ROUND(weight*2.205, 0) AS weight_in_pounds,
birth_date,
CASE
    WHEN gender = 'M' THEN 'Male'
    WHEN gender = 'F' THEN 'Female'
    ELSE 'Other'
END AS gender
FROM patients;





