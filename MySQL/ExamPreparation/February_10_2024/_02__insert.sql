INSERT INTO preserves (name, latitude, longitude, area, type, established_on)
SELECT CONCAT(name, ' is in South Hemisphere'),
    latitude,
    longitude,
    area * id,
    LOWER(type),
    established_on
FROM preserves
WHERE latitude < 0;
