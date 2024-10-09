SELECT 
    CONCAT(first_name, ' ', last_name) AS full_name, 
    DATEDIFF('2024-01-01', start_date) AS days_of_experience 
FROM 
    workers
WHERE 
    TIMESTAMPDIFF(YEAR, start_date, '2024-01-01') > 5
ORDER BY 
    days_of_experience DESC 
LIMIT 10;
