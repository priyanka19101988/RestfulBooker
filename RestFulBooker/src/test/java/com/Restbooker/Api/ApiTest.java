package com.Restbooker.Api;

import org.testng.annotations.*;

import com.restfulbooker.api.api.AuthAPI;
import com.restfulbooker.api.api.BookingAPI;
import com.restfulbooker.api.api.PingApi;
import com.restfulbooker.api.payload.Auth;
import com.restfulbooker.api.payload.Booking;
import com.restfulbooker.api.payload.BookingDates;
import com.restfulbooker.util.Global;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
public class ApiTest {
	
	
	@Test
    public void testHealthCheckReturns201() {
        Response response = PingApi.healthCheck();

        assertThat(response.getStatusCode() == 201).isTrue();
    }
	

   @Test
   public void testCreateTokenReturns200() {
         Auth auth = new Auth.Builder()
            .setUserName(Global.Default_username)
            .setPassword(Global.Default_password)
            .build();

    Response response = AuthAPI.createToken(auth);
    ResponseBody body = response.getBody();
    body.prettyPrint();
    assertThat(response.getStatusCode() == 200).isTrue();
}
	
   @Test
   public void testGetBookingIdsReturns200() {
       Response response = BookingAPI.getBookingIds();

       assertThat(response.getStatusCode() == 200).isTrue();
   }
   
   @Test(enabled=false)
   public void testGetBookingReturns200() {
       Response response = BookingAPI.getBooking(1, "application/json");
       assertThat(response.getStatusCode() == 200).isTrue();
       ResponseBody body = response.getBody();
       body.prettyPrint();
   }
   
   @Test(enabled=false)
   public void createBooking() {
	   BookingDates dates = new BookingDates.Builder()
               .setCheckin(new Date())
               .setCheckout(new Date())
               .build();

       Booking payload = new Booking.Builder()
               .setFirstName("Priya")
               .setLastName("Active")
               .setTotalPrice(260)
               .setDepositPaid(true)
               .setBookingDates(dates)
               .setAdditionalNeeds("None")
               .build();

       Response response = BookingAPI.createBooking(payload);
       ResponseBody body = response.getBody();
       body.prettyPrint();
       System.out.println("status code" +response.getStatusCode());
       assertThat(response.getStatusCode() == 200).isTrue();
   }
   
   @Test
   public void updateBookingTest() {
	   
	   Booking payload = new Booking.Builder()
               .setFirstName("Priya")
               .build();  
	   Response response = BookingAPI.updateBooking(payload,1);
       ResponseBody body = response.getBody();
       body.prettyPrint();
       System.out.println("status code" +response.getStatusCode());
       assertThat(response.getStatusCode() == 200).isTrue();

	   
   }
   
}


