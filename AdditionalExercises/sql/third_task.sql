-- Show first name of patients that start with the letter 'C'

SELECT
  first_name AS first_name 
FROM patients
WHERE SUBSTRING(first_name, 1, 1) = 'C';
