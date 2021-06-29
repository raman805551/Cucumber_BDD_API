package com.restAssured.frameworks.utils;

import io.restassured.RestAssured;
import files.BodyPayload;
import io.restassured.response.Response;

import java.util.Properties;

/**
 * Contains reusable methods related to REST endpoints.
 * Includes major operations like, GET, POST and PUT operations
 */
public class RestOperations {


    public static Properties getProp() {
        return prop;
    }

    public static void setProp(Properties prop) {
        RestOperations.prop = prop;
    }

    protected static Properties prop;
    protected Response response;

    /**
     * Hits the GET rest endpoint
     * @param url - service endpoint url
     * @return endpoint response
     */
    protected Response getService(final String url) {
        try {
            response = RestAssured.
                    given().headers("Content-type","application/json","charset","UTF-8")
                    .when()
                    .get(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public Response postService(final String url, String bodyPayload) {
        try {
            response = RestAssured.
                    given()
                    .header("Content-type","application/json").header("Accept-Charset","UTF-8").contentType("application/json")
                    .header("Authorization", "Bearer decedb9c7a0430ddb6c3c78164898d39bdd5f00b315c3158032932ea5727997f")
                    .body(bodyPayload)
                    .when()
                    .post(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    protected Response putService(final String url, String bodyPayload) {
        try {
            response = RestAssured.
                    given()
                    .header("Content-type","application/json").header("Accept-Charset","UTF-8").contentType("application/json")
                    .header("Authorization", "Bearer decedb9c7a0430ddb6c3c78164898d39bdd5f00b315c3158032932ea5727997f")
                    .body(bodyPayload)
                    .when()
                    .put(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    protected Response deleteService(final String url) {
        try {
            response = RestAssured.
                    given()
                    .header("Content-type","application/json").header("Accept-Charset","UTF-8").contentType("application/json")
                    .header("Authorization", "Bearer decedb9c7a0430ddb6c3c78164898d39bdd5f00b315c3158032932ea5727997f")
                    .when()
                    .delete(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
