-- 1. -------------------------------------------------------------------------------------------------------------------  
        CREATE DATABASE gamebar;
        USE gamebar;
-- 2. -------------------------------------------------------------------------------------------------------------------   
        CREATE TABLE products (
            id INT PRIMARY KEY AUTO_INCREMENT,
            name VARCHAR(50) NOT NULL,
            category_id INT NOT NULL
        );

        CREATE TABLE categories (
            id INT PRIMARY KEY AUTO_INCREMENT,
            name VARCHAR(50) NOT NULL
        );  
    
        CREATE TABLE employees (
            id INT PRIMARY KEY AUTO_INCREMENT,
            first_name VARCHAR(50) NOT NULL,
            last_name VARCHAR(50) NOT NULL
        );
-- 3. -------------------------------------------------------------------------------------------------------------------  
        SELECT * FROM gamebar.employees;

        INSERT INTO employees (first_name, last_name) VALUES 
            ('Petrohan', 'Troharev'), 
            ('Palamud', 'Karakudov'), 
            ('Salzan', 'Naplakanov')
            ('Gosho', 'Muhamedov'),
            ('Ivan', 'Pleshkov'),
            ('Grogonil', 'Karakalkanov');

        INSERT INTO employees (first_name, last_name) VALUES 
            ('Petrohan', 'Troharev'), 
            ('Palamud', 'Karakudov'), 
            ('Salzan', 'Naplakanov')
            ('Gosho', 'Muhamedov'),
            ('Ivan', 'Pleshkov'),
            ('Grogonil', 'Karakalkanov');

        INSERT INTO employees (first_name, last_name) VALUES 
            ('Petrohan', 'Troharev'), 
            ('Palamud', 'Karakudov'), 
            ('Salzan', 'Naplakanov')
            ('Gosho', 'Muhamedov'),
            ('Ivan', 'Pleshkov'),
            ('Grogonil', 'Karakalkanov');
-- 4. -------------------------------------------------------------------------------------------------------------------  
        DELETE FROM employees
        WHERE id IN (1, 2, 3, 4, 5, 6, 7, 8, 9);

        DELETE FROM employees;
        TRUNCATE TABLE employees;

        ALTER TABLE employees AUTO_INCREMENT = 1;  
-- 5. -------------------------------------------------------------------------------------------------------------------  
        INSERT INTO employees (first_name, last_name) VALUES 
            ('Petrohan', 'Troharev'), 
            ('Palamud', 'Karakudov'), 
            ('Salzan', 'Naplakanov')
            ('Gosho', 'Muhamedov'),
            ('Ivan', 'Pleshkov'),
            ('Grogonil', 'Karakalkanov');

        ALTER TABLE employees
        ADD COLUMN middle_name VARCHAR(50);

        ALTER TABLE products
        ADD CONSTRAINT fk_category
        FOREIGN KEY (category_id) REFERENCES categories(id);
-- 6. -------------------------------------------------------------------------------------------------------------------  
        SELECT * FROM gamebar.employees;

        DESCRIBE employees;

        ALTER TABLE employees
        MODIFY middle_name VARCHAR(100);

        DESCRIBE employees;
-- 7. -------------------------------------------------------------------------------------------------------------------  
        ALTER TABLE employees
        MODIFY first_name VARCHAR(100),
        MODIFY last_name VARCHAR(100),

        DESCRIBE employees;

        SELECT * FROM gamebar.employees;

        ALTER TABLE employees
        DROP COLUMN middle_name

        SELECT * FROM gamebar.employees;

        ALTER TABLE employees
        ADD COLUMN middle_name VARCHAR(100);
-------------------------------------------------------------------------------------------------------------------------  
