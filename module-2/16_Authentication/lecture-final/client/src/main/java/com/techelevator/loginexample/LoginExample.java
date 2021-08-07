package com.techelevator.loginexample;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


public class LoginExample {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        String username = "admin";
        String password = "admin";
        String url = "http://localhost:8080/";
        String token = "";

        /*
        Login and get the token
         */

        Credentials credentials = new Credentials();
        credentials.setUsername(username);
        credentials.setPassword(password);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Credentials> loginRequestEntity = new HttpEntity<Credentials>(credentials, headers);

        ResponseEntity<Map> loginResponseEntity = restTemplate.exchange(url + "login", HttpMethod.POST, loginRequestEntity, Map.class);
        token = (String) loginResponseEntity.getBody().get("token");

        System.out.println(token);

        /*
        Using the token with a request with no message body(GET/DELETE)
         */

        HttpHeaders getHeaders = new HttpHeaders();
        getHeaders.setBearerAuth(token);
        HttpEntity getRequestEntity = new HttpEntity<>(getHeaders);
        Hotel hotel = restTemplate.exchange(url + "hotels/1", HttpMethod.GET, getRequestEntity, Hotel.class).getBody();
        //with exchange must call getBody() to deserialize the object

        System.out.println(hotel);


        /*
        Using the token with request with a message body (post/put)

         */

        Reservation reservation = new Reservation();
        reservation.setHotelID(1);
        reservation.setFullName("test");
        reservation.setCheckinDate("1/12/2021");
        reservation.setCheckoutDate("1/14/2021");
        reservation.setGuests(2);


        HttpHeaders postHeaders = new HttpHeaders();
        postHeaders.setContentType(MediaType.APPLICATION_JSON);
        postHeaders.setBearerAuth(token);
        HttpEntity<Reservation> postRequestEntity = new HttpEntity<>(reservation, postHeaders);
        Reservation returnedReservation = restTemplate.exchange(url + "hotels/1/reservations", HttpMethod.POST,
                postRequestEntity, Reservation.class).getBody();

        System.out.println(returnedReservation);




    }


}
