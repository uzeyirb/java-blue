-- Write queries to return the following:
-- The following changes are applied to the "dvdstore" database.**
SELECT * FROm actor;
-- 1. Add actors, Hampton Avenue, and Lisa Byway to the actor table.
INSERT INTO actor(first_name, last_name)
VALUES('Hampton', 'Avenue');
INSERT INTO actor(first_name, last_name)
VALUES('Lisa', 'Byway');

-- 2. Add "Euclidean PI", "The epic story of Euclid as a pizza delivery boy in
-- ancient Greece", to the film table. The movie was released in 2008 in English.
-- Since its an epic, the run length is 3hrs and 18mins. There are no special
-- features, the film speaks for itself, and doesn't need any gimmicks.
SELECT * FROM film
WHERE title = 'Euclidean PI'
ORDER BY title

START TRANSACTION;

INSERT INTO film(title, description, release_year, language_id, length)
VALUES('Euclidean PI', 'The epic story of Euclid as a pizza delivery boy in ancient Greece', 2008, 1, 198 );

COMMIT;
ROLLBACK;

SELECT * FROm film;

-- 3. Hampton Avenue plays Euclid, while Lisa Byway plays his slightly
-- overprotective mother, in the film, "Euclidean PI". Add them to the film.
SELECT * FROM film
WHERE description LIKE 'The epic%'
ORDER BY description


SELECT * FROM actor
WHERE first_name ='Hampton';

SELECT actor_id
FROM actor
WHERE first_name = 'Hampton' ANd last_name = 'Avenue';

SELECT film_id
FROM film
WHERE title = 'Euclidean PI';

START TRANSACTION;


INSERT INTO film_actor(actor_id, film_id)
VALUES((SELECT actor_id FROM actor WHERE first_name = 'Hampton' ANd last_name = 'Avenue'), (SELECT film_id FROM film WHERE title = 'Euclidean PI'))



ROLLBACK;
START TRANSACTION;

DELETE FROM actor
WHERE actor_id = 215 AND first_name = 'Lisa';

COMMIT;
ROLLBACK;
START TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI' AND film_id = 1003;
ROLLBACK;
START TRANSACTION;

SELECT *
FROM actor
WHERE first_name = 'Lisa' ANd last_name = 'Byway';

SELECT * FROM film WHERE title = 'Euclidean PI';

START TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI' AND film_id = 1007;

START TRANSACTION;


--ERROR: more than one row returned by a subquery used as an expression  delete duplicate entries

INSERT INTO film_actor(actor_id, film_id)  --  Lisa Byway
VALUES ((SELECT actor_id FROM actor WHERE first_name = 'Lisa' AND last_name = 'Byway'), (SELECT film_id FROM film WHERE title = 'Euclidean PI'))


ROLLBACK;
COMMIT;
-- 4. Add Mathmagical to the category table.
SELECT * FROM film_actor
ORDER BY film_id DESC

START TRANSACTION;
INSERT INTO category (name) VALUES ('Mathmagical')



ROLLBACK;

-- 5. Assign the Mathmagical category to the following films, "Euclidean PI",
-- "EGG IGBY", "KARATE MOON", "RANDOM GO", and "YOUNG LANGUAGE"
SELECT * FROM film WHERE title = 'Euclidean PI';
SELECT * FROM film WHERE title = 'EGG IGBY';
SELECT * FROM film WHERE title = 'RANDOM GO';
SELECT * FROM film WHERE title = 'YOUNG LANGUAGE';
SELECT * FROM category WHERE name = 'Mathmagical';
-- Error when using * instead of single column subquery must return only one column 


START TRANSACTION;
INSERT INTO film_category(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'Euclidean PI'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'EGG IGBY'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'RANDOM GO'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));

INSERT INTO film_category(film_id, category_id)
VALUES ((SELECT film_id FROM film WHERE title = 'YOUNG LANGUAGE'), (SELECT category_id FROM category WHERE name = 'Mathmagical'));
ROLLBACK;

-- 6. Mathmagical films always have a "G" rating, adjust all Mathmagical films
-- accordingly.
-- (5 rows affected)
SELECT * FROM category WHERE name = 'Mathmagical';
SELECT rating FROM film;
SELECT category_id FROM category WHERE name = 'Mathmagical';

--ERROR: column "rating" of relation "category" does not exist

START TRANSACTION;
UPDATE film
SET rating = 'G'
WHERE film_id IN (SELECT film_id FROM film_category WHERE category_id = (SELECT category_id FROM category WHERE name = 'Mathmagical'));
ROLLBACK;
SELECT * FROM film;
SELECT * FROM film_category;



SELECT * FROM film_category;
SELECT category_id FROM category WHERE name = 'Mathmagical';
SELECT * FROM category WHERE name = 'Mathmagical';

-- 7. Add a copy of "Euclidean PI" to all the stores.
SELECT * FROM film;
SELECT film_id FROM film WHERE title = 'Euclidean PI';

START TRANSACTION;
INSERT INTO inventory(film_id, store_id)
VALUES((SELECT film_id FROM film WHERE title = 'Euclidean PI') , 1);

INSERT INTO inventory(film_id, store_id)
VALUES((SELECT film_id FROM film WHERE title = 'Euclidean PI') , 2);
ROLLBACK;
-- 8. The Feds have stepped in and have impounded all copies of the pirated film,
-- "Euclidean PI". The film has been seized from all stores, and needs to be
-- deleted from the film table. Delete "Euclidean PI" from the film table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--When I try to delete the following ERROR: update or delete on table "film" violates foreign key constraint "film_actor_film_id_fkey" on table "film_actor" pops up
-- which is part of foreign key contrain that only allows values where the value exists on the related table
--Does not allow the related value to be removed from the related table as long as the foreign key value is in use.


START TRANSACTION;
DELETE FROM film
WHERE title = 'Euclidean PI';
ROLLBACK;


-- 9. Delete Mathmagical from the category table.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--When I try to delete the following ERROR: update or delete on table "film" violates foreign key constraint "film_actor_film_id_fkey" on table "film_actor" pops up
-- which is part of foreign key contrain that only allows values where the value exists on the related table
--Does not allow the related value to be removed from the related table as long as the foreign key value is in use.


START TRANSACTION;
DELETE FROM category
WHERE name = 'Mathmagical';
ROLLBACK;
-- 10. Delete all links to Mathmagical in the film_category tale.
-- (Did it succeed? Why?)
-- <YOUR ANSWER HERE>
--while trying to delete  ERROR: column "title" does not exist which means which has nothing to do with constrains
--simply it does not exists
START TRANSACTION;
DELETE FROM film_category
WHERE name = 'Mathmagical';
ROLLBACK;
-- 11. Retry deleting Mathmagical from the category table, followed by retrying
-- to delete "Euclidean PI".
-- (Did either deletes succeed? Why?)
-- <YOUR ANSWER HERE>
--while trying to delete  ERROR: column "title" does not exist which means which has nothing to do with constrains
--simply it does not exists
START TRANSACTION;
DELETE FROM category
WHERE title = 'Euclidean PI';
ROLLBACK;
START TRANSACTION;
DELETE FROM film_category
WHERE name = 'Mathmagical';
ROLLBACK;
-- 12. Check database metadata to determine all constraints of the film id, and
-- describe any remaining adjustments needed before the film "Euclidean PI" can
-- be removed from the film table.
--film_id is linked to film_actor, film_category and invemtory the only way I can guess it deleting
--"Euclidean PI" from all of this tables at the same timeSELECT transfer_type_id, transfer_type_desc FROM transfer_types;
SELECT transfer_type_id FROM transfer_types WHERE transfer_type_id = 1;

START TRANSACTION
ROLLBACK
INSERT INTO transfers ( transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount ) 
VALUES ( DEFAULT, ( SELECT transfer_type_id FROM transfer_types WHERE transfer_type_id = ? ),
( SELECT transfer_status_id FROM transfer_statuses WHERE transfer_status_id = ? ), 
( SELECT account_id FROM accounts WHERE account_id = ? ), 
(SELECT account_id FROM accounts WHERE account_id = ?), ?) ;





SELECT transfer_status_id FROM transfer_statuses WHERE transfer_status_id = 1;
SELECT account_id FROM accounts WHERE account_id = 2001;
SELECT account_id, user_id, balance FROM accounts;
SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to, amount FROM transfers;
