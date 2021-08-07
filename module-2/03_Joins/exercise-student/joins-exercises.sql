-- The following queries utilize the "dvdstore" database.

-- 1. All of the films that Nick Stallone has appeared in
-- (30 rows)
SELECT *
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
WHERE last_name = 'STALLONE' AND first_name = 'NICK';

-- 2. All of the films that Rita Reynolds has appeared in
-- (20 rows)
SELECT actor.*, film_actor.film_id, film.title
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
WHERE actor.first_name = 'RITA';


-- 3. All of the films that Judy Dean or River Dean have appeared in
-- (46 rows)
SELECT actor.*, film_actor.film_id, film.title
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
WHERE actor.first_name = 'JUDY' OR actor.first_name = 'RIVER';

-- 4. All of the the ‘Documentary’ films
-- (68 rows)
SELECT film.*
FROM film
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Documentary';


-- 5. All of the ‘Comedy’ films
-- (58 rows)
SELECT film.*, category.name
FROM film
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Comedy';

-- 6. All of the ‘Children’ films that are rated ‘G’
-- (10 rows)
SELECT film.*, category.name
FROM film
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Children' AND film.rating = 'G';

-- 7. All of the ‘Family’ films that are rated ‘G’ and are less than 2 hours in length
-- (3 rows)

SELECT film.*, category.name
FROM film
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE category.name = 'Family' AND film.rating = 'G' AND film.length < 120;

-- 8. All of the films featuring actor Matthew Leigh that are rated ‘G’
-- (9 rows)

SELECT actor.*, film_actor.film_id, film.*
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
WHERE actor.first_name = 'MATTHEW' AND actor.last_name = 'LEIGH'AND film.rating = 'G';

-- 9. All of the ‘Sci-Fi’ films released in 2006
-- (61 rows)
SELECT film.*, category.*
FROM film
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE film.release_year = 2006 AND category.name = 'Sci-Fi';


-- 10. All of the ‘Action’ films starring Nick Stallone
-- (2 rows)
SELECT actor.*, film_actor.film_id, film.*, category.*
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
WHERE actor.first_name = 'NICK' AND actor.last_name = 'STALLONE' AND category.name = 'Action';

-- 11. The address of all stores, including street address, city, district, and country
-- (2 rows)

SELECT store.address_id, address.address, address.district, city.city, country.country 
FROM store
JOIN address ON store.address_id = address.address_id
JOIN city ON address.city_id = city.city_id
JOIN country ON city.country_id = country.country_id;


-- 12. A list of all stores by ID, the store’s street address, and the name of the store’s manager
-- (2 rows)
SELECT store.store_id, address.address, staff.first_name, staff.last_name  
FROM store
JOIN staff ON staff.staff_id = store.manager_staff_id
JOIN address ON store.address_id = address.address_id
;


-- 13. The first and last name of the top ten customers ranked by number of rentals
-- (#1 should be “ELEANOR HUNT�? with 46 rentals, #10 should have 39 rentals)
SELECT customer.first_name, customer.last_name, COUNT(customer.customer_id) AS number_of_rents
FROM customer
JOIN rental ON rental.customer_id = customer.customer_id
GROUP BY customer.first_name, customer.last_name
ORDER BY number_of_rents DESC LIMIT 10;





-- 14. The first and last name of the top ten customers ranked by dollars spent
-- (#1 should be “KARL SEAL�? with 221.55 spent, #10 should be “ANA BRADLEY�? with 174.66 spent)

SELECT customer.first_name, customer.last_name, SUM(payment.amount) as total_spent
FROM customer
JOIN rental ON rental.customer_id = customer.customer_id
JOIN payment ON payment.rental_id = rental.rental_id
GROUP BY customer.first_name, customer.last_name
ORDER BY total_spent DESC LIMIT 10;



-- 15. The store ID, street address, total number of rentals, total amount of sales (i.e. payments), and average sale of each store.
-- (NOTE: Keep in mind that while a customer has only one primary store, they may rent from either store.)
-- (Store 1 has 7928 total rentals and Store 2 has 8121 total rentals)

SELECT store.store_id, address.address, COUNT(payment.amount), SUM(payment.amount), AVG(payment.amount)
FROM rental
JOIN payment ON rental.rental_id = payment.rental_id
JOIN inventory ON rental.inventory_id = inventory.inventory_id
JOIN store ON inventory.store_id = store.store_id
JOIN address ON store.address_id = address.address_id
GROUP BY store.store_id, address.address;


-- 16. The top ten film titles by number of rentals
-- (#1 should be “BUCKET BROTHERHOOD�? with 34 rentals and #10 should have 31 rentals)

SELECT film.title, count(rental.rental_id) As top_number_of_rentals
FROM film
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY film.title
ORDER BY top_number_of_rentals DESC LIMIT 10;

-- 17. The top five film categories by number of rentals
-- (#1 should be “Sports�? with 1179 rentals and #5 should be “Family�? with 1096 rentals)
SELECT film.*, count(rental.rental_id) As top_number_of_rentals
FROM film
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
GROUP BY film.title
ORDER BY top_number_of_rentals DESC LIMIT 10;

-- 18. The top five Action film titles by number of rentals
-- (#1 should have 30 rentals and #5 should have 28 rentals)
SELECT film.title, COUNT(rental.rental_id) AS rental_rank
FROM film
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
JOIN film_category ON film.film_id =film_category.film_id
JOIN category ON film_category.category_id = category.category_id
GROUP BY film.title
ORDER BY rental_rank DESC Limit 5; 
-- 19. The top 10 actors ranked by number of rentals of films starring that actor
-- (#1 should be “GINA DEGENERES�? with 753 rentals and #10 should be “SEAN GUINESS�? with 599 rentals)
SELECT actor.actor_id, actor.first_name, actor.last_name, film_actor.film_id, COUNT(rental.rental_id) AS rental_rank
FROM actor
JOIN film_actor ON actor.actor_id = film_actor.actor_id
JOIN film ON film_actor.film_id = film.film_id
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON inventory.inventory_id = rental.rental_id
GROUP BY actor.actor_id, actor.first_name, actor.last_name, film_actor.film_id
ORDER BY rental_rank DESC LIMIT 10;

-- 20. The top 5 “Comedy�? actors ranked by number of rentals of films in the “Comedy�? category starring that actor
-- (#1 should have 87 rentals and #5 should have 72 rentals)

SELECT actor.first_name, actor.last_name, COUNT(rental.rental_id) AS rental_rank
FROM actor 
JOIN film_actor  ON film_actor.actor_id= actor.actor_id
JOIN film  ON film.film_id = film_actor.film_id
JOIN inventory ON inventory.film_id = film.film_id
JOIN rental ON rental.inventory_id = inventory.inventory_id
JOIN film_category ON film_category.film_id = film.film_id
JOIN category  ON category.category_id = film_category.category_id
WHERE category.name='Comedy'
GROUP BY actor.actor_id, actor.first_name, actor.last_name
ORDER BY rental_rank DESC LIMIT 5;




























