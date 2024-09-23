CREATE DATABASE gamebar;

USE gamebar;

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    category_id INT NOT NULL
);

CREATE TABLE categories (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL
);

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES 
    ('Petrohan', 'Troharev'), 
    ('Palamud', 'Karakudov'), 
    ('Salzan', 'Naplakanov')

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES
    ('Gosho', 'Muhamedov'),
    ('Ivan', 'Pleshkov'),
    ('Grogonil', 'Karakalkanov');

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES 
    ('Petrohan', 'Troharev'), 
    ('Palamud', 'Karakudov'), 
    ('Salzan', 'Naplakanov')

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES
    ('Gosho', 'Muhamedov'),
    ('Ivan', 'Pleshkov'),
    ('Grogonil', 'Karakalkanov');

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES 
    ('Petrohan', 'Troharev'), 
    ('Palamud', 'Karakudov'), 
    ('Salzan', 'Naplakanov')

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES
    ('Gosho', 'Muhamedov'),
    ('Ivan', 'Pleshkov'),
    ('Grogonil', 'Karakalkanov');

USE gamebar;

DELETE FROM employees
WHERE id IN (1, 2, 3, 4, 5, 6, 7, 8, 9);

DELETE FROM employees;
TRUNCATE TABLE employees;

ALTER TABLE employees AUTO_INCREMENT = 1;  

INSERT INTO employees (first_name, last_name) VALUES
    ('Petrohan', 'Troharev'), 
    ('Palamud', 'Karakudov'), 
    ('Salzan', 'Naplakanov'),
    ('Gosho', 'Muhamedov'),
    ('Ivan', 'Pleshkov'),
    ('Grogonil', 'Karakalkanov');

