package com.stepdefinations;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import com.PojoClasses.LoginRequest;
import com.PojoClasses.LoginResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginStepDefiniation  {
	RequestSpecification loginRequest = null;
	LoginResponse loginResponseObj = null;
	public static Response response;
	Response loginAPI = null;
	
	
	@Given("User has the payload for login {string} {string}")
	public void user_has_the_payload_for_login(String userName, String password) {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		LoginRequest login = new LoginRequest();
		login.setUserEmail(userName);
		login.setUserPassword(password);
		RequestSpecification req = new RequestSpecBuilder().addHeader("Content-Type", "application/json").build();
		loginRequest = given().spec(req).log().all().body(login);
	}
	@When("User call the {string} {string} http request")
	public void user_call_the_http_request(String methodName, String methodType) {
	    // Write code here that turns the phrase above into concrete actions
		loginAPI = loginRequest.when().post("api/ecom/auth/login").then().log().all().extract().response();
	   
	}
	@Then("API call has status code {string}")
	public void api_call_has_status_code(String expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    String statusCode =  String.valueOf(loginAPI.getStatusCode());
	    Assert.assertEquals(expectedStatusCode, statusCode);
	    GlobalStepdefination.response = loginAPI;
	    
	    
	}
	
	
}
