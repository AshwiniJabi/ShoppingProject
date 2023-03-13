package com.stepdefinations;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;

import com.PojoClasses.RequestMembers;
import com.ShoppingAPI.ProductAPI;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ProductAPIStepDefinination{
	
	
	public static RequestMembers requestMemberObj= new RequestMembers();
	//public static String userId ="637890f3d7778f5797354828";
	Response res= null;
	LoginStepDefiniation login = new LoginStepDefiniation();
	Map<String,String> multiPartValues= new HashMap<String,String>();
	@Given("User has valid usertoken")
	public void user_has_valid_usertoken() {
	    // Write code here that turns the phrase above into concrete actions
		/*String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4OTBmM2Q3Nzc4ZjU3OTczNTQ4MjgiLCJ1c2VyRW1haWwiOiJhc2h3aW5pLnNwYXJlQGdtYWlsLmNvbSIsInVzZXJNb2JpbGUiOjg4NjcyNjIzNjcsInVzZXJSb2xlIjoiY3VzdG9tZXIiLCJpYXQiOjE2Nzg0MzA4NzIsImV4cCI6MTcwOTk4ODQ3Mn0.SoPfuATEdT-VqVBiA84H3A4AcIbR5GNBHdHsWgoeXf0";
		Map<String,String> headerValues= new HashMap<String,String>();
		headerValues.put("Authorization", userToken);
		requestMemberObj.setHeaderValues(headerValues);
		*/
		
		String username = "ashwini.spare@gmail.com";
		String password ="arj14rsj";
		
		login.user_has_the_payload_for_login(username, password);
		login.user_call_the_http_request("loginAPI", "POST");
		Response loginResponse = login.loginAPI;
		JsonPath loginJson= new JsonPath(loginResponse.asString());
		if(loginResponse.statusCode() == 200) {
			String userToken = loginJson.getString("token");
			String userId = loginJson.getString("userId");
			Map<String,String> headerValues= new HashMap<String,String>();
			headerValues.put("Authorization", userToken);
			requestMemberObj.setHeaderValues(headerValues);
			user_gives_as("formParams", "productAddedBy", userId);
			
		}
	    
	}
	@Given("User gives {string} {string} as {string}")
	public void user_gives_as(String paramType, String key,String value) {
	    // Write code here that turns the phrase above into concrete actions
	   if(paramType.equalsIgnoreCase("formParams")) {
		   multiPartValues.put(key, value);
	   }
	}
	@When("User calls the {string} {string} http request")
	public void user_calls_the_http_request(String methodName, String methodtype) {
		requestMemberObj.setMultiPartValues(multiPartValues);
		res = ProductAPI.createProduct(requestMemberObj);
		GlobalStepdefination.response = res;
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Then("Response has {string}")
	public void response_has(String id) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    if(res.getStatusCode() ==201) {
	    	JsonPath responseJson = new JsonPath(res.asString());
	    	Assert.assertNotNull(responseJson.getString(id));
	    }
	}
	
@Then("API call has response status code {string}")
	
	public void api_call_has_response_status_code(String expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    String statusCode =  String.valueOf(res.getStatusCode());
	    Assert.assertEquals(expectedStatusCode, statusCode);
	    JsonPath json = new JsonPath(res.asString());
	    
	    
	}




}
