package com.restfulbooker.api.api;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class PingApi extends BaseAPI {
    protected static final String PING_ENDPOINT = Base_endpoint + "ping/";

    public static Response healthCheck() {
        return given()
                .get(PING_ENDPOINT);
    }
}

