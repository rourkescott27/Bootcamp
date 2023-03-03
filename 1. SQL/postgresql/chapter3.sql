CREATE TABLE char_data_types (
varchar_column varchar(10),
char_column char(10),
text_column text
);

INSERT INTO char_data_types
VALUES
('abc', 'abc', 'abc'),
('defghi', 'defghi', 'defghi');

COPY char_data_types TO 'C:\Users\Rourke Scott\Desktop\postgresql\typetest.txt'
WITH (FORMAT CSV, HEADER, DELIMITER '|');

CREATE TABLE number_data_types (
numeric_column numeric(20,5),
real_column real,
double_column double precision
);

INSERT INTO number_data_types
VALUES
(.7, .7, .7),
(2.13579, 2.13579, 2.13579),
(2.1357987654, 2.1357987654, 2.1357987654);

SELECT * FROM number_data_types;

SELECT
numeric_column * 10000000 AS "Fixed",
real_column *  10000000 AS "Float",
double_column *  10000000 AS "Double"
FROM number_data_types
WHERE numeric_column = .7;

CREATE TABLE date_time_types (
	timestamp_column timestamp with time zone,
interval_column interval
);

DROP TABLE date_time_types;

INSERT INTO date_time_types
VALUES
('2018-12-31 01:00 EST','2 days'),
('2018-12-31 01:00 -8','1 month'),
('2018-12-31 01:00 Australia/Melbourne','1 century'),
(now(),'1 week');

SELECT * FROM date_time_types;

SELECT
timestamp_column,
interval_column,
timestamp_column - interval_column AS new_date
FROM date_time_types;

SELECT timestamp_column, CAST(timestamp_column AS varchar(30)) AS cast_to_varchar
FROM date_time_types;

SELECT * FROM char_data_types; 

SELECT numeric_column,
	CAST(numeric_column AS integer),
	CAST(numeric_column AS varchar(6))
FROM number_data_types;

SELECT CAST(char_column AS integer) FROM char_data_types;
	
SELECT timestamp_column, CAST(timestamp_column AS varchar(10))
FROM date_time_types;

SELECT timestamp_column::varchar(10)
FROM date_time_types;


--try it yourself 1
numeric(4,1),
--try it yourself 2
varchar(20),
--try it yourself 3
--Done in class 



