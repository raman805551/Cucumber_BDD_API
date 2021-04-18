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

    protected Response postService(final String url) {
        try {
            response = RestAssured.
                    given()
                    .header("Content-type","application/json").header("Accept-Charset","UTF-8").contentType("application/json")
                    .body(BodyPayload.getPayload())
                    .when()
                    .post(url);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }


}
