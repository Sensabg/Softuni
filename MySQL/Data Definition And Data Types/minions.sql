-- 1. -------------------------------------------------------------------------------------    
        CREATE SCHEMA Minions;
        USE Minions;
-- 2. -------------------------------------------------------------------------------------   
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
-- 3. -------------------------------------------------------------------------------------        
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
-- 4. -------------------------------------------------------------------------------------         
        TRUNCATE TABLE minions;
-- 5. -------------------------------------------------------------------------------------      
        DROP TABLE IF EXISTS minions;

        DROP TABLE IF EXISTS towns;
-- 6. -------------------------------------------------------------------------------------
        CREATE TABLE people (
                id INT PRIMARY KEY AUTO_INCREMENT UNIQUE NOT NULL,
                name VARCHAR(200) NOT NULL,
                picture BLOB NULL,
		height DECIMAL(4, 2) NULL,
		weight DECIMAL(4, 2) NULL,
		gender CHAR(1) NOT NULL,
                birthdate DATE NOT NULL,
                biography TEXT NULL
        );
-------------------------------------------------------------------------------------------
