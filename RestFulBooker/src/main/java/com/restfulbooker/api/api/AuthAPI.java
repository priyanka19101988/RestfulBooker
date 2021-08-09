package com.restfulbooker.api.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import com.restfulbooker.api.payload.Auth;


public class AuthAPI extends BaseAPI {
	
	protected static String Auth_endpoint = Base_endpoint + "auth/";
	
	public static Response createToken(Auth payload) {
        return given()
               .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Auth_endpoint);
    }
	

}
