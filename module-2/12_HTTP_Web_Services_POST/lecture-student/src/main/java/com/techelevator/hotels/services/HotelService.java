package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
    // TODO: Implement method
    // need to build the reservation object this is just
    // for this app and has nothing to do with how to do a post
    Reservation reservation = makeReservation(newReservation);
    if (reservation == null){
      return null;
    }
    // 1. Create a header for the content type application/json
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    // 2. Put the reservation in the message body

    HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation, headers); //(objectForTheMessageBody, headers)
    // 3. Send the Post with the header and message body
    try{
      reservation = restTemplate.postForObject(BASE_URL + "reservations" , entity, Reservation.class); //(url, httpEntityWithHeaderAndBody, classToDeserialization
    }catch (ResourceAccessException e){
      console.printError(e.getMessage());
    }catch (RestClientResponseException e){
      console.printError(e.getRawStatusCode() + " " + e.getStatusText());
    }
    return reservation;
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param updateReservation
   * @return
   */
  public Reservation updateReservation(String updateReservation) {
    // TODO: Implement method
    Reservation reservation = makeReservation(updateReservation);
    if(reservation == null){
      return null;
    }

    // 1, Create the header
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    // 2. Create the Message body

    HttpEntity<Reservation> entity = new HttpEntity<Reservation>(reservation, headers);

    // 3. Put using the header and message body

    String endpoint = BASE_URL + "reservation/" + reservation.getId(); // as we are not doing deserialization we do not need .class

    try{
      restTemplate.put(endpoint, entity);
    }catch (ResourceAccessException e){
      console.printError(e.getMessage());
    }catch (RestClientResponseException e){
      console.printError(e.getRawStatusCode() + " " + e.getStatusText());
    }
    return null;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    // TODO: Implement method
    String endpointUrl = BASE_URL + "reservations/" + id;
    try{
      restTemplate.delete(endpointUrl);
    }catch (ResourceAccessException e){
      console.printError(e.getMessage());
    }catch (RestClientResponseException e){
      console.printError(e.getRawStatusCode() + " " + e.getStatusText() );
    }
  }

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    // TODO: Implement method
    try {
      String endpoint = BASE_URL + "hotels";
      hotels = restTemplate.getForObject(endpoint, Hotel[].class);
    } catch (ResourceAccessException e){
      /*
      ResourceAccessException
	  Catches connection errors when the server cannot be reached.

       */
      console.printError(e.getMessage());
      /*
      Connection refused happens when internet is down and server is down

       */
    } catch (RestClientResponseException e){
      /*
       RestClientResponseException is thrown when the server returns an error status code
      like 4xx(400, 404, etc) or a 5xx(500)
       */
      // handle server response errors
      // rawStatusCode contains the HTTP  status code (404)
      // statusText contains the HTTP status message (Not found)
      //
      console.printError(e.getRawStatusCode() + " " + e.getStatusText());
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
  // TODO: Implement method
    String endpoint = BASE_URL + "hotels" + id;
    try {
      hotel = restTemplate.getForObject(endpoint, Hotel.class);
    }catch (ResourceAccessException e){
      console.printError(e.getMessage());
    }catch (RestClientResponseException e){
      if(e.getRawStatusCode() == 404){
        console.printError("The endpoint was not found");
      }else{
        console.printError(e.getRawStatusCode() + " " + e.getStatusText());
      }
    }
    return hotel;
  }


  

    /* DON'T MODIFY ANY METHODS BELOW */
  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
