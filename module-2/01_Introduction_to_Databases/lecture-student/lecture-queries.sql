-- SELECT ... FROM
-- Selecting the names for all countries

SELECT name    -- SELECT is the columns to return data for (filters the columns to be returned) 

FROM country;  -- FROM is the table to get the data from



-- Selecting the name and population of all countries

SELECT name, population
FROM country;
-- Selecting all columns from the city table
SELECT *
FROM city;

-- commands can be written on 1 line or multiple 
-- SELECT * FOM city;
SELECT DISTINCT district   --DISTINCT with a column will only return the unique values from that column
FROM city;

SELECT name AS city_name FROM city;  -- AS can alias a column so it has a different name in the results

-- SELECT ... FROM ... WHERE
-- Selecting the cities in Ohio
SELECT * 
FROM city
WHERE district = 'Ohio';

-- Selecting countries that gained independence in the year 1776
SELECT * FROM country Where indepyear = 1776;


-- Selecting countries not in Asia

SELECT * 
FROM country
Where continent != 'Asia';

-- Selecting countries that do not have an independence year
SELECT *
FROM country
WHERE indepyear IS NUll;

-- Selecting countries that do have an independence year
SELECT *
FROM country
WHERE continent IS NOT NULL;

-- Selecting countries that have a population greater than 5 million

SELECT *
FROM country
WHERE population > 5000000;

-- SELECT ... FROM ... WHERE ... AND/OR
-- Selecting cities in Ohio and Population greater than 400,000
SELECT *
FROM city WHERE district = 'Ohio' AND population > 400000;

-- Selecting country names on the continent North America or South America
SELECT name
FROM country WHERE continent = 'North America' or continent = 'South America';

-- Above query could also be written as 
SELECT name
FROM country WHERE continent IN ('North America', 'South America');

--Between allows to selection between 2 values

SELECT * FROM country WHERE population BETWEEN 1000000 AND 2000000;

--Select all countries that Begin with the letter A

SELECT * 
FROM country
WHERE name LIKE 'A%';

--Select all countries that end with the letter d
SELECT *
FROM country
WHERE name LIKE '%d';

--SELECT all countries that contain the letter L
SELECT *
FROM country
WHERE name LIKE '%la%';

--Like is case sensitive, ILIKE is not case sensitive(ILIKE is Postgres only)

SELECT *
FROM country
WHERE name ILIKE '%a%';

-- SELECTING DATA w/arithmetic
-- Selecting the population, life expectancy, and population per area
--	note the use of the 'as' keyword
SELECT population, lifeexpectancy, (population / surfacearea) AS population_density FROM country; 


