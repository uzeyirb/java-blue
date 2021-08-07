package com.techelevator.springjdbc;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/*
	IMPORTANT:  While this is valid SpringJDBC Code to see all of the
	 parts together, it is not an example of the correct way to structure
	 code using SpringJDBC and here only as an example.

	 USE THE EXAMPLE IN THE com.techelevator.dao PACKAGE!
 */


/* Working with JDBC entails a lot of boilerplate code which can become 
 * tedious and error prone. The Spring JBDC framework can help eliminate 
 * much of the boilerplate code, and limit the tedium and mistakes. */
public class SpringJDBCExample {

	public static void main(String[] args) {

		/*
			1) MAKING A CONNECTION
		 */
		/* This datasource will be used for creating connections to the database.
		 * Below, we provide the information required to make database connections */
		BasicDataSource dvdstoreDataSource = new BasicDataSource();
		dvdstoreDataSource.setUrl("jdbc:postgresql://localhost:5432/dvdstore");
		dvdstoreDataSource.setUsername("postgres");
		dvdstoreDataSource.setPassword("postgres1");


		/*
			2) INSTANTIATE JdbcTemplate AND PASS IT THE DATASOURCE
		 */
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate dvdstoreJdbcTemplate = new JdbcTemplate(dvdstoreDataSource);
		


		/*
			3) CREATE YOUR QUERY AS A STRING USING ? FOR PARAMETERS
		 */
		/* The JdbcTemplate can be used to execute parameterized SQL statements */
		String sqlFilmsByCategory =  "SELECT film.title, film.release_year "+
									 "FROM film JOIN film_category ON film.film_id = film_category.film_id "+
									 "JOIN category ON category.category_id = film_category.category_id "+
									 "WHERE category.name = ?";


		/*
			4) FOR SELECT: use the queryForRowSet method passing it the values for the parameters
		 */
		/* The first parameter to the "queryForRowSet" method is a String containing a parameterized SQL statement
		 * Any following parameters are used to replace query placeholders (i.e. '?') in the order in which they appear */
		String category = "Comedy";
											//  queryForRowSet( sql, parameters )
		SqlRowSet results = dvdstoreJdbcTemplate.queryForRowSet(sqlFilmsByCategory, category);

		/*
			5) FOR SELECT: Get the Results using queryForRowSet()
		 */
		/*
		   queryForRowSet() returns a SqlRowSet that can be looped over using while (result.next()) to retrieve
		      the values from the results.  Each time through is a new row of data.  Data can be accessed using the
		      getter for the matching data type and passing it the column name.
		 */
		System.out.println(category+" Films:");
		while(results.next()) {  // The "next" method advances the cursor to the next row.  If a row exists, it returns true, otherwise false
			String filmTitle = results.getString("title");  // this is the title column from teh SELECT statment above
			int releaseYear = results.getInt("release_year");
			System.out.println(filmTitle+" ("+releaseYear+")");
		}



		/*
		  4) FOR UPDATE, INSERT, DELETE use the update() method passing it the values for the parameters
		 */
		/* use the "update" method to run INSERT, UPDATE, and DELETE statements */
		String sqlCreateActor = "INSERT INTO actor(actor_id, first_name, last_name) "+
								"VALUES (DEFAULT, ?, ?)";

		dvdstoreJdbcTemplate.update(sqlCreateActor,  "Craig", "Castelaz");





		/*
		  BELOW IS A SECOND EXAMPLE USING A DIFFERENT DATABASE THAT DEMONSTRATES
		  ONE WAY OF WORKING WITH SEQUENCES.
		 */

		/* The next example makes use of the world database, so we need a new 
		 * DataSource for creating connections to that database. */
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		/* The JdbcTemplate is the main interface we use to interact with databases using
		 * Spring JDBC. */
		JdbcTemplate worldJdbcTemplate = new JdbcTemplate(worldDataSource);


		/*
		  1) GET THE NEXT SEQUENCE VALUE
		 */
		/*
		 * Sequences are often used to generate a unique Id value prior to inserting
		 * a new record.
		 */
		String sqlGetNextId = "SELECT nextval('seq_city_id')";
		results = worldJdbcTemplate.queryForRowSet(sqlGetNextId);
		results.next(); // advances to the first row
		int id = results.getInt(1); // returns the integer value of the first column (i.e. index 1)
		System.out.println("New city id: "+id);


		/*
			2) USE THE SEQUENCE VALUE FOR THE INSERT
		 */
		/*
		 * Now create a new city record using the generated id returned from the sequence
		 */
		String sqlCreateNewCity = "INSERT INTO city(id, name, countrycode, district, population) "+
								  "VALUES(?, ?, ?, ?, ?)";
		
		worldJdbcTemplate.update(sqlCreateNewCity, id, "Smallville", "USA", "Kansas", 45001);


		/*
		 Getting a generated ID using RETURNING
		 */
		String sqlCreateNewCityWithReturning = "INSERT INTO city(id, name, countrycode, district, population) "+
				"VALUES(DEFAULT, ?, ?, ?, ?) RETURNING id";

		/*
			When using INSERT...RETURNING must use queryForRowSet() instead of update()
		 */
		SqlRowSet insertResult = worldJdbcTemplate.queryForRowSet(sqlCreateNewCityWithReturning,
				"Smallville", "USA", "Kansas", 45001);

		insertResult.next();
		int newCityId = insertResult.getInt("id");

		System.out.println("New City Id with Returning: " + newCityId);
	}
}
