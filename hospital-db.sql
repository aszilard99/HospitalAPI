Drop Table doctor;
Drop Table nurse;
Drop Table patient;
Drop Table room;
CREATE TABLE  doctor (
	id serial PRIMARY KEY,
	name VARCHAR (255) NOT NULL,
	specialization VARCHAR(255) NOT NULL
);
CREATE TABLE nurse (
	id serial PRIMARY KEY,
	name VARCHAR (255) NOT NULL
);
CREATE TABLE patient (
	id serial PRIMARY KEY NOT NULL,
	name VARCHAR (255) NOT NULL,
	symptom VARCHAR (255) NOt NULL
);
CREATE TABLE room (
	id serial PRIMARY KEY,
	beds_total integer NOT NULL,
	beds_available integer NOT NULL
);
