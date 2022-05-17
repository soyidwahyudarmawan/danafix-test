CREATE DATABASE "danafix-test";

CREATE TABLE IF NOT EXISTS employee (
	id varchar(36) NOT NULL,
	"name" varchar(255) NOT NULL,
	birth_date date NOT NULL,
	birth_place varchar(100) NOT NULL,
	address varchar(255) NOT NULL,
	mobile_phone varchar(15) NOT NULL,
	CONSTRAINT employee_pk PRIMARY KEY (id)
);