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

