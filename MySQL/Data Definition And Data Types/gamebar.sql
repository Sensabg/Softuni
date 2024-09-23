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
    ('Salzan', 'Naplakan')

SELECT * FROM gamebar.employees;

INSERT INTO employees (first_name, last_name) VALUES
('Gosho', 'Muhamedov'),
('Ivan', 'Pleshkov'),
('Grogonil', 'Karakalkanov');
