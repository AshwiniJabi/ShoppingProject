package com.stepdefinations;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GlobalStepdefination {
	public static Response response;
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String value, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
		JsonPath json = new JsonPath(response.asString());
		String message = json.getString(value);
		Assert.assertEquals(expectedValue, message);
		
	}
}
