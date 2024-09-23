CREATE SCHEMA Minions;

CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);

CREATE TABLE towns (
    town_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

ALTER TABLE minions
ADD COLUMN town_id INT,
ADD CONSTRAINT fk_town
FOREIGN KEY (town_id) REFERENCES towns(id);

DROP TABLE IF EXISTS minions;
DROP TABLE IF EXISTS towns;

CREATE TABLE towns (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(50) NOT NULL
);

CREATE TABLE minions (
    id INT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(50) NOT NULL, 
    age INT, 
    town_id INT,
    CONSTRAINT fk_town FOREIGN KEY (town_id) REFERENCES towns(id)
);

INSERT INTO towns (name) VALUES 
    ('Sofia'), 
    ('Plovdiv'), 
    ('Varna');

INSERT INTO minions (name, age, town_id) VALUES 
    ('Kevin', 22, 1), 
    ('Bob', 15, 3), 
    ('Steward', NULL, 2);

TRUNCATE TABLE minions;
