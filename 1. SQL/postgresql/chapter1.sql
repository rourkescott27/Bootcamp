CREATE DATABASE analysis;

CREATE TABLE teachers (
	id bigserial,
	first_name varchar(25),
	last_name varchar(50),
	school varchar(50),
	hire_date date,
	salary numeric
);

INSERT INTO teachers (first_name, last_name, school, hire_date, salary)
  VALUES ('Janet', 'Smith', 'F.D. Roosevelt HS', '2011-10-30', 36200),
('Lee', 'Reynolds', 'F.D. Roosevelt HS', '1993-05-22', 65000),
('Samuel', 'Cole', 'Myers Middle School', '2005-08-01', 43500),
('Samantha', 'Bush', 'Myers Middle School', '2011-10-30', 36200),
('Betty', 'Diaz', 'Myers Middle School', '2005-08-30', 43500),
('Kathleen', 'Roush', 'F.D. Roosevelt HS', '2010-10-22', 38500);

DROP TABLE teachers;

--try it yourself 1
CREATE TABLE animal_types (
	id bigserial CONSTRAINT animal_types_key PRIMARY KEY,
	common_name varchar(50),
	scientific_name varchar(50),
	conservation_status varchar(25)
);

CREATE TABLE menagerie (
	menagerie_id id bigserial CONSTRAINT menagerie_key PRIMARY KEY,
	animal_types_id id bigint REFERENCES animal_types(animal_types_id),
	date_acquired date NOT NULL,
	gender varchar(1),
	acquired_from varchar(100),
	name varchar(100),
	notes text
);


--try it yourself 2


INSERT INTO animal_characteristics (mammals_specification, birds_specification, reptile_specification, amphibians_specification, invertebrates_specification)
	VALUES ('Can produce milk', 'Have feathers', 'Covered with scales', 'Skin is smooth and slimy', 'Lack internal skeleton'),
	('Possess specilized teeth', 'Lightweight skeleton', 'Cold-Blooded', 'Amphibians vocalize', 'Less complex nervous system' ),
	('Have sweat glands', 'Beaked Jaws', 'Fertilize eggs internally', 'Breathe through their skin', 'Intracellular digestion'),
	('Warm blooded', 'High metabolic rate', 'Produce shelled eggs', 'Complex life cycle', 'Do not possess lungs'),
	('Typically have fur', 'Toothless', 'Reptiles are vertebrates', 'Cold-Blooded', 'Typically very small');



SELECT * FROM kinds_of_animals;

DROP TABLE kinds_of_animals;

DROP TABLE animal_characteristics;

SELECT * FROM animal_characteristics;


INSERT INTO kinds_of_animals (mammals, birds, reptiles, amphibians, invertebrates)
	VALUES ('Lion', 'Parrot', 'Crocodile', 'Frog', 'Snail'),
	('Elephant', 'Dove', 'Black mamba', 'Newt', 'Praying Mantis'),
	('Cheetah', 'Peacock', 'Caiman', 'Salamander', 'Butterfly'),
	('Buffalo', 'Stork', 'Turtle', 'Axolotl', 'Crab'),
	('Kudu', 'Hornbill', 'Iguana', 'Toad', 'Worm');







