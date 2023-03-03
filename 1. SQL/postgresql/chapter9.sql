--Chapter 9
-- Importing data
CREATE TABLE meat_poultry_egg_inspect (
est_number varchar(50) CONSTRAINT est_number_key PRIMARY KEY,
company varchar(100),
street varchar(100),
city varchar(30),
st varchar(2),
zip varchar(5),
phone varchar(14),
grant_date date,
activities text,
dbas text
);

COPY meat_poultry_egg_inspect
FROM 'C:\Users\Rourke Scott\Desktop\postgresql\practical-sql-main\Chapter_09\MPI_Directory_by_Establishment_Name.csv'
WITH (FORMAT CSV, HEADER, DELIMITER ',');

CREATE INDEX company_idx ON meat_poultry_egg_inspect (company);

SELECT * FROM meat_poultry_egg_inspect;

--Interviewing the Date Set
SELECT company,
street,
city,
st,
count(*) AS address_count
FROM meat_poultry_egg_inspect
GROUP BY company, street, city, st
HAVING count(*) > 1
ORDER BY company, street, city, st;

--Check for missing values
SELECT st,
count(*) AS st_count
FROM meat_poultry_egg_inspect
GROUP BY st
ORDER BY st NULLS FIRST;

SELECT est_number,
company,
city,
st,
zip
FROM meat_poultry_egg_inspect
WHERE st IS NULL;

--Checking for Inconsistent Data Values
SELECT company,
count(*) AS company_count
FROM meat_poultry_egg_inspect
GROUP BY company
ORDER BY company ASC;

--Checking for Malformed Values Using length()
SELECT length(zip),
	count(*) AS length_count
FROM meat_poultry_egg_inspect
GROUP BY length(zip)
ORDER BY length(zip) ASC;

SELECT st,
	count(*) AS length_count
FROM meat_poultry_egg_inspect
WHERE length(zip) < 5
GROUP BY st
ORDER BY st ASC;

--Modifying Tables with ALTER TABLE pg 137
--The code for adding a column to a table looks like this:
--ALTER TABLE table ADD COLUMN column data_type;

--Similarly, we can remove a column with the following syntax:
--ALTER TABLE table DROP COLUMN column;

--To change the data type of a column, we would use this code:
--ALTER TABLE table ALTER COLUMN column SET DATA TYPE data_type;

--Adding a NOT NULL constraint to a column will look like the following:
--ALTER TABLE table ALTER COLUMN column SET NOT NULL;

--Removing the NOT NULL constraint looks like this:
--ALTER TABLE table ALTER COLUMN column DROP NOT NULL;


--Backup table
CREATE TABLE meat_poultry_egg_inspect_backup AS
SELECT * FROM meat_poultry_egg_inspect;

SELECT
(SELECT count(*) FROM meat_poultry_egg_inspect) AS original,
(SELECT count(*) FROM meat_poultry_egg_inspect_backup) AS backup;

ALTER TABLE meat_poultry_egg_inspect ADD COLUMN st_copy varchar(2);

UPDATE meat_poultry_egg_inspect
SET st_copy = st;

SELECT st,
st_copy
FROM meat_poultry_egg_inspect
ORDER BY st;

UPDATE meat_poultry_egg_inspect
SET st = 'MN'
WHERE est_number = 'V18677A';
UPDATE meat_poultry_egg_inspect
SET st = 'AL'
WHERE est_number = 'M45319+P45319';
UPDATE meat_poultry_egg_inspect
SET st = 'WI'
WHERE est_number = 'M263A+P263A+V263A';

UPDATE meat_poultry_egg_inspect original
SET st = backup.st
FROM meat_poultry_egg_inspect_backup backup
WHERE original.est_number = backup.est_number;

ALTER TABLE meat_poultry_egg_inspect DROP COLUMN st_copy ;

ALTER TABLE meat_poultry_egg_inspect ADD COLUMN company_standard varchar(100);
UPDATE meat_poultry_egg_inspect
SET company_standard = company;

SELECT company_standard, company
FROM meat_poultry_egg_inspect;

UPDATE meat_poultry_egg_inspect
SET company = 'Armour-Eckrich Meats'
WHERE company LIKE 'Armour%';

SELECT company, company_standard
FROM meat_poultry_egg_inspect
WHERE company LIKE 'Armour%';

ALTER TABLE meat_poultry_egg_inspect 
DROP COLUMN company_standard;

ALTER TABLE meat_poultry_egg_inspect ADD COLUMN zip_copy varchar(5);
UPDATE meat_poultry_egg_inspect
SET zip_copy = zip;

--Repairing ZIP codes using concatenation
UPDATE meat_poultry_egg_inspect
SET zip = '00' || zip
WHERE st IN('PR','VI') AND length(zip) = 3;

UPDATE meat_poultry_egg_inspect
SET zip = '0' || zip
WHERE st IN('CT','MA','ME','NH','NJ','RI','VT') AND length(zip) = 4;

--Updating Values Across Tables
CREATE TABLE state_regions (
st varchar(2) CONSTRAINT st_key PRIMARY KEY,
region varchar(20) NOT NULL
);

COPY state_regions
FROM 'C:\Users\Rourke Scott\Desktop\postgresql\practical-sql-main\Chapter_09\state_regions.csv'
WITH (FORMAT CSV, HEADER, DELIMITER ',');

SELECT * FROM state_regions;

ALTER TABLE meat_poultry_egg_inspect ADD COLUMN inspection_date date;

UPDATE meat_poultry_egg_inspect inspect
SET inspection_date = '2019-12-01'
WHERE EXISTS (SELECT state_regions.region
				FROM state_regions
				WHERE inspect.st = state_regions.st
					AND state_regions.region = 'New England');
					
SELECT * FROM meat_poultry_egg_inspect

SELECT st, inspection_date
FROM meat_poultry_egg_inspect
GROUP BY st, inspection_date
ORDER BY st;


SELECT inspection_date, count(*)
FROM meat_poultry_egg_inspect
GROUP BY inspection_date;

--DELETING unnecessary Data
DELETE FROM meat_poultry_egg_inspect
WHERE st IN('PR','VI');

--Using Transaction Blocks to Save or Revert changes
START TRANSACTION;

UPDATE meat_poultry_egg_inspect
SET company = 'AGRO Merchants Oakland LLC'
WHERE company = 'AGRO Merchantss Oakland, LLC';

SELECT company
FROM meat_poultry_egg_inspect
WHERE company LIKE 'AGRO%'
ORDER BY company;

ROLLBACK;

COMMIT;

--Improving performance when updating large Tables
CREATE TABLE meat_poultry_egg_inspect_backup AS
SELECT *,
'2018-02-07'::date AS reviewed_date
FROM meat_poultry_egg_inspect;

ALTER TABLE meat_poultry_egg_inspect RENAME TO meat_poultry_egg_inspect_temp;
ALTER TABLE meat_poultry_egg_inspect_backup
RENAME TO meat_poultry_egg_inspect;

ALTER TABLE meat_poultry_egg_inspect_temp
RENAME TO meat_poultry_egg_inspect_backup;

SELECT * FROM meat_poultry_egg_inspect_backup;

--try it yourself 1
ALTER TABLE meat_poultry_egg_inspect ADD COLUMN meat_processing boolean;
ALTER TABLE meat_poultry_egg_inspect ADD COLUMN poultry_processing boolean;

--try it yourself 2
UPDATE meat_poultry_egg_inspect
SET meat_processing = true
WHERE activities LIKE 'Meat Processing%';

UPDATE meat_poultry_egg_inspect
SET poultry_processing = true
WHERE activities LIKE 'Poultry Processing%';

SELECT * FROM meat_poultry_egg_inspect;

--try it yourself 3
SELECT 
COUNT (meat_processing), COUNT (poultry_processing)
FROM
meat_poultry_egg_inspect;
----------------------------------------------------------
--How many plants perform both activities?
SELECT COUNT(*) 
FROM meat_poultry_egg_inspect
WHERE meat_processing = true 
AND poultry_processing = true;
