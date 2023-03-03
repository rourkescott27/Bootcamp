--Chapter 13--
--Formatting Text Using String Functions--
--Case Formatting--
SELECT upper('Hello');
SELECT lower('Hello');
SELECT initcap('rourke');

--Character Information--
SELECT length(' Pat ');
SELECT position(',' in 'Tan,Bella');

--Removing Characters--
SELECT trim ('s' from 'socks');
SELECT ltrim ('socks', 's');
SELECT rtrim ('socks', 's');

--Extracting and Replacing Characters--
SELECT left('703-555-1212', 3);
SELECT right('703-555-1212', 8);
SELECT REPLACE ('bat', 'b', 'c');

--Matching Text Patterns with Regular Expressions--
--Regular Expression Notation--
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from '\d{4}');
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from '.+');
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from '^\w+');
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from '\w+.$');
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from 'May|June');
SELECT substring('The game starts at 7 p.m. on May 2, 2019.' from 'May \d, \d{4}')

--Turning Text to Data with Regular Expression Functions--
--Creating a Table for Crime Reports--
CREATE TABLE crime_reports (
	crime_id bigserial PRIMARY KEY,
	date_1 timestamp with time zone,
	date_2 timestamp with time zone,
	street varchar(250),
	city varchar(100),
	crime_type varchar(100),
	description text,
	case_number varchar(50),
	original_text text NOT NULL
);

COPY crime_reports (original_text)
FROM 'C:\Users\Rourke Scott\Documents\Bootcamp\1. SQL\postgresql\practical-sql-main\Chapter_13\crime_reports.csv'
WITH (FORMAT CSV, HEADER OFF, QUOTE '"');

SELECT original_text FROM crime_reports;

--Matching Crime Report Date Patterns--
SELECT crime_id,
regexp_match(original_text, '\d{1,2}\/\d{1,2}\/\d{2}')
FROM crime_reports;

--Matching the Second Date When Present--
SELECT crime_id,
regexp_matches(original_text, '\d{1,2}\/\d{1,2}\/\d{2}', 'g')
FROM crime_reports;

SELECT crime_id,
regexp_match(original_text, '-\d{1,2}\/\d{1,2}\/\d{2}')
FROM crime_reports;

SELECT crime_id,
regexp_match(original_text, '-(\d{1,2}\/\d{1,2}\/\d{1,2})')
FROM crime_reports;

--Matching Additional Crime Report Elements--
-- First hour \/\d{2}\n(\d{4}) --
SELECT crime_id,
regexp_match(original_text, '\/\d{2}\n(\d{4})') AS Hour
FROM crime_reports;

-- Second hour \/\d{2}\n\d{4}-(\d{4}) --
SELECT crime_id,
regexp_match(original_text, '\/\d{2}\n\d{4}-(\d{4})') AS second_hour
FROM crime_reports;

-- Street hrs.\n(\d+ .+(?:Sq.|Plz.|Dr.|Ter.|Rd.)) --
SELECT crime_id,
regexp_match(original_text, 'hrs.\n(\d+ .+(?:Sq.|Plz.|Dr.|Ter.|Rd.))') AS street_address
FROM crime_reports;

-- City (?:Sq.|Plz.|Dr.|Ter.|Rd.)\n(\w+ \w+|\w+)\n --
SELECT crime_id,
regexp_match(original_text, '(?:Sq.|Plz.|Dr.|Ter.|Rd.)\n(\w+ \w+|\w+)\n') AS city
FROM crime_reports;

-- Crime type \n(?:\w+ \w+|\w+)\n(.*): --
SELECT crime_id,
regexp_match(original_text, '\n(?:\w+ \w+|\w+)\n(.*):') AS crime_type
FROM crime_reports;

-- Description :\s(.+)(?:C0|SO) --
SELECT crime_id,
regexp_match(original_text, ':\s(.+)(?:C0|SO)') AS description
FROM crime_reports;

-- Case number (?:C0|SO)[0-9]+ --
SELECT crime_id,
regexp_match(original_text, '(?:C0|SO)[0-9]+') AS case_number
FROM crime_reports;

-- All together --
-- Extra brackets added aswell as [] index position, which causes Postgre to take it out of the array --
SELECT
(regexp_match(original_text, '(?:C0|SO)[0-9]+'))[1] AS case_number,
(regexp_match(original_text, '\d{1,2}\/\d{1,2}\/\d{2}'))[1] AS date_1,
(regexp_match(original_text, '\n(?:\w+ \w+|\w+)\n(.*):'))[1] AS crime_type,
(regexp_match(original_text, '(?:Sq.|Plz.|Dr.|Ter.|Rd.)\n(\w+ \w+|\w+)\n'))[1] AS city
FROM crime_reports;

-- Extracting Text from the regexp_match() Result --
SELECT
crime_id,
(regexp_match(original_text, '(?:C0|SO)[0-9]+'))[1]
AS case_number
FROM crime_reports;

-- Updating the crime_reports Table with Extracted Data --
UPDATE crime_reports
SET date_1 =
(
	(regexp_match(original_text, '\d{1,2}\/\d{1,2}\/\d{2}'))[1]
		|| ' ' ||
	(regexp_match(original_text, '\/\d{2}\n(\d{4})'))[1]
		||' US/Eastern'
)::timestamptz;

SELECT crime_id,
	   date_1,
	   original_text
FROM crime_reports;
-----------------------------------------
SELECT * FROM crime_reports;           --
-----------------------------------------

-- Show and set date time to a new format --
SHOW datestyle;
SET datestyle = "ISO, MDY";

-- Using CASE to Handle Special Instances --
UPDATE crime_reports
SET date_1 =
	(
	  (regexp_match(original_text, '\d{1,2}\/\d{1,2}\/\d{2}'))[1]
		|| ' ' ||
	  (regexp_match(original_text, '\/\d{2}\n(\d{4})'))[1]
		||' US/Eastern'
	)::timestamptz,

date_2 =
CASE
	WHEN (SELECT regexp_match(original_text, '-(\d{1,2}\/\d{1,2}\/\d{1,2})') IS NULL)
		AND (SELECT regexp_match(original_text, '\/\d{2}\n\d{4}-(\d{4})') IS NOT NULL)
	THEN
	 ((regexp_match(original_text, '\d{1,2}\/\d{1,2}\/\d{2}'))[1]
		|| ' ' ||
	 (regexp_match(original_text, '\/\d{2}\n\d{4}-(\d{4})'))[1]
		||' US/Eastern'
	 )::timestamptz

	WHEN (SELECT regexp_match(original_text, '-(\d{1,2}\/\d{1,2}\/\d{1,2})') IS NOT NULL)
		AND (SELECT regexp_match(original_text, '\/\d{2}\n\d{4}-(\d{4})') IS NOT NULL)
	THEN
	 ((regexp_match(original_text, '-(\d{1,2}\/\d{1,2}\/\d{1,2})'))[1]
		|| ' ' ||
	 (regexp_match(original_text, '\/\d{2}\n\d{4}-(\d{4})'))[1]
		||' US/Eastern'
	 )::timestamptz
	ELSE NULL
END,
street = (regexp_match(original_text, 'hrs.\n(\d+ .+(?:Sq.|Plz.|Dr.|Ter.|Rd.))'))[1],
city = (regexp_match(original_text,'(?:Sq.|Plz.|Dr.|Ter.|Rd.)\n(\w+ \w+|\w+)\n'))[1],
crime_type = (regexp_match(original_text, '\n(?:\w+ \w+|\w+)\n(.*):'))[1],
description = (regexp_match(original_text, ':\s(.+)(?:C0|SO)'))[1],
case_number = (regexp_match(original_text, '(?:C0|SO)[0-9]+'))[1];

-------------------------------
SELECT * FROM crime_reports; --
-------------------------------

-- The Value of the Process --
-- Using Regular Expressions with WHERE --
SELECT geo_name
FROM us_counties_2010
WHERE geo_name ~* '(.+lade.+|.+lare.+)'
ORDER BY geo_name;

SELECT geo_name
FROM us_counties_2010
WHERE geo_name ~* '.+ash.+' AND geo_name !~ 'Wash.+'
ORDER BY geo_name;

-- Additional Regular Expression Functions --
SELECT regexp_replace('05/12/2018', '\d{4}', '2017');

-------------- Keep in mind for try it yourself ----------------------
SELECT regexp_split_to_table('Four,score,and,seven,years,ago', ',');--
----------------------------------------------------------------------

SELECT regexp_split_to_array('Phil Mike Tony Steve', ',');

SELECT array_length(regexp_split_to_array('Phil Mike Tony Steve', ' '), 1);

-- Full Text Search in PostgreSQL --
-- Text Search Data Types --
-- Storing Text as Lexemes with tsvector --
SELECT to_tsvector('I am walking across the sitting room to sit with you.');

-- Creating the Search Terms with tsquery --
SELECT to_tsquery('walking & sitting');

-- Using the @@ Match Operator for Searching --
SELECT to_tsvector('I am walking across the sitting room') @@ to_tsquery('walking & sitting');

SELECT to_tsvector('I am walking across the sitting room') @@ to_tsquery('walking & running');

-- Creating a Table for Full Text Search --
CREATE TABLE president_speeches (
	sotu_id serial PRIMARY KEY,
	president varchar(100) NOT NULL,
	title varchar(250) NOT NULL,
	speech_date date NOT NULL,
	speech_text text NOT NULL,
	search_speech_text tsvector
);

COPY president_speeches (president, title, speech_date, speech_text)
FROM 'C:\Users\Rourke Scott\Documents\Bootcamp\1. SQL\postgresql\practical-sql-main\Chapter_13\sotu-1946-1977.csv'
WITH (FORMAT CSV, DELIMITER '|', HEADER OFF, QUOTE '@');

UPDATE president_speeches
SET search_speech_text = to_tsvector('english', speech_text);

CREATE INDEX search_idx ON president_speeches USING gin(search_speech_text);

SELECT search_speech_text FROM president_speeches;

-- Searching Speech Text --
SELECT president, speech_date
FROM president_speeches
WHERE search_speech_text @@ to_tsquery('Vietnam')
ORDER BY speech_date;

-- Showing Search Result Locations --
SELECT president,
	   speech_date,
	   ts_headline(speech_text, to_tsquery('Vietnam'),
				   'StartSel = <,
				    StopSel = >,
				    MinWords=5,
					MaxWords=7,
					MaxFragments=1')
FROM president_speeches
WHERE search_speech_text @@ to_tsquery('Vietnam');

-- Using Multiple Search Terms --
SELECT president,
	   speech_date,
	   ts_headline(speech_text, to_tsquery('transportation & !roads'),
				   'StartSel = <,
					StopSel = >,
					MinWords=5,
					MaxWords=7,
					MaxFragments=1')
FROM president_speeches
WHERE search_speech_text @@ to_tsquery('transportation & !roads');

-- Searching for Adjacent Words --
SELECT president,
	   speech_date,
	   ts_headline(speech_text, to_tsquery('military <-> defense'),
				   'StartSel = <,
					StopSel = >,
					MinWords=5,
					MaxWords=7,
					MaxFragments=1')
FROM president_speeches
WHERE search_speech_text @@ to_tsquery('military <-> defense');

-- Ranking Query Matches by Relevance --
SELECT president,
	   speech_date,
	   ts_rank(search_speech_text,
			   to_tsquery('war & security & threat & enemy')) AS score

FROM president_speeches
WHERE search_speech_text @@ to_tsquery('war & security & threat & enemy')
ORDER BY score DESC
LIMIT 5
-------------------------------------------------------------------------
SELECT president,
	   speech_date,
	   ts_rank(search_speech_text,
			   to_tsquery('war & security & threat & enemy'), 2)::numeric
			   AS score
FROM president_speeches
WHERE search_speech_text @@ to_tsquery('war & security & threat & enemy')
ORDER BY score DESC
LIMIT 5;

-- try it yourself 1 --

-- try it yourself 2 --

-- try it yourself 3 --