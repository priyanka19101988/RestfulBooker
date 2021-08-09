package com.restfulbooker.api.api;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import com.restfulbooker.api.payload.Booking;

public class BookingAPI extends BaseAPI {
    protected static final String BOOKING_ENDPOINT = Base_endpoint + "booking/";

    public static Response getBookingIds() {
        return given()
                .get(BOOKING_ENDPOINT);
    }

    public static Response getBooking(int id, String mediaType) {
        return given()
                .header("Accept", mediaType)
                .get(BOOKING_ENDPOINT + Integer.toString(id));
    }
    
    public static Response createBooking(Booking payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(BOOKING_ENDPOINT);
    }
    public static Response updateBooking(Booking payload,int id) {
    	return given()
    			.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
    			.put(BOOKING_ENDPOINT + Integer.toString(id));
    			
    }
    
}

