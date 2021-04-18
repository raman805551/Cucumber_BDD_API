package com.restAssured.frameworks.stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import static org.junit.Assert.assertEquals;

import java.util.List;

import com.restAssured.frameworks.utils.RestOperations;

public class StepDefinitionfile extends RestOperations {
    private String endpointUrl;
    protected String postMessage;

    @When("I do a GET request for {string}")
    public void iDoAGETRequestFor(final String serviceUrl) throws Throwable {
        response = getService(serviceUrl);
    }

    @Given("I want to post a {string} on social network website")
    public void iWantToPostAOnSocialSite(String message) {
        this.postMessage = message;
    }

    @When("I do a POST request for {string}")
    public void iDoAPOSTRequestFor(String serviceUrl) {
        response = postService(serviceUrl);
        System.out.println(response);

    }
    
    @Given("I want to get the comments on the post")
    public void i_want_to_get_the_comments_on_the_post() {
    	System.out.println("Hello");
    }
    
    @Given("I want to get the list of all the users")
    public void iwantto_get_the_comments_on_the_post() {
    	System.out.println("Hello");
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
    
}
