package com.restAssured.frameworks.stepDefinition;

import com.restAssured.frameworks.bodyBuilder.ReqBodyBuilder;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.restAssured.frameworks.utils.RestOperations;
import org.json.*;

public class StepDefinitionfile extends RestOperations {
    private String endpointUrl;
    protected String postMessage;
    String reqBody;
    Response response;
    JsonPath js;
    String id;
    ReqBodyBuilder reqBodyBuilder = new ReqBodyBuilder();

    @When("I do a GET request for {string}")
    public void iDoAGETRequestFor(final String serviceUrl) throws Throwable {
        response = getService(serviceUrl);
    }


    @Given("I want to add user having {string} , {string} , {string} , {string}")
    public void iWantToAddUserHaving(String name, String gender, String email, String status) {
        String updateEmail = email+ Math.random()*100+"@gmail.com";
        reqBody =  reqBodyBuilder.createUserReqBody(name,gender,updateEmail,status);
    }

    @Given("I want to update user having {string} , {string} , {string} , {string}")
    public void iWantToUpdateUserHaving(String name, String gender, String email, String status) {
        reqBody =  reqBodyBuilder.createUserReqBody(name,gender,email,status);
    }


    @Given("I want to add existing user having {string} , {string} , {string} , {string}")
    public void iWantToAddExistingUserHaving(String name, String gender, String email, String status) {
        reqBody =  reqBodyBuilder.createUserReqBody(name,gender,email,status);
    }

    @When("I do a POST request for {string}")
    public void iDoAPOSTRequestFor(String serviceUrl) {
        response = postService(serviceUrl, reqBody);
        JSONObject body = new JSONObject(response.asString());
        js = new JsonPath(body.get("data").toString());
        id = js.getString("id");
        System.out.println("Response : " + response.asString());
        System.out.println("id : " + id);

    }

    @When("I do a PUT request for {string}")
    public void iDoAPUTRequestFor(String serviceUrl) {
        String url = reqBodyBuilder.updateUserUrl(serviceUrl, id);
        System.out.println("URL : " + url);
        response = putService(url, reqBody);
        js = new JsonPath(response.asString());
        System.out.println("Response : " + response.asString());
    }

    @When("I do a DELETE request for {string}")
    public void iDoADELETERequestFor(String serviceUrl) {
        String url = reqBodyBuilder.updateUserUrl(serviceUrl, id);
        System.out.println("URL : " + url);
        response = deleteService(url);
        js = new JsonPath(response.asString());
        System.out.println("Response : " + response.asString());
    }
    

    @Then("I validate the response with status code {int}")
    public void iValidateTheResponseWithStatuscode(final int statusCode) throws Throwable {
        assertEquals(statusCode, response.getStatusCode());
    }
    
    @Then("I validate the Email in the response body is {string}")
    public void IValidateTheEmailInTheResponsebody(String Email) throws Throwable {
    	List<String> jsonResponse = response.jsonPath().getList("email");
    	if (jsonResponse != null)
        assertEquals(Email, jsonResponse.get(0));
    }

    @Then("I want to verify {string}")
    public void IValidateTheErrorMessage(String errorMsg) throws Throwable {
        String jsonResponse = response.jsonPath().get("code");
        System.out.println(jsonResponse);
        if (jsonResponse != null)
            assertEquals(errorMsg, jsonResponse);
    }
    
}
