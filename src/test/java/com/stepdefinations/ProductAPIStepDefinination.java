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
	
	
	public RequestMembers requestMemberObj= new RequestMembers();
	//public static String userId ="637890f3d7778f5797354828";
	Response res= null;
	
	Map<String,String> multiPartValues= new HashMap<String,String>();
	Map<String,String> pathParamValues= new HashMap<String,String>();
	String apiName = null;
	public static String  productId= null;
	
	
	@Given("User has valid usertoken")
	public void user_has_valid_usertoken() {
	    // Write code here that turns the phrase above into concrete actions
		/*String userToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4OTBmM2Q3Nzc4ZjU3OTczNTQ4MjgiLCJ1c2VyRW1haWwiOiJhc2h3aW5pLnNwYXJlQGdtYWlsLmNvbSIsInVzZXJNb2JpbGUiOjg4NjcyNjIzNjcsInVzZXJSb2xlIjoiY3VzdG9tZXIiLCJpYXQiOjE2Nzg0MzA4NzIsImV4cCI6MTcwOTk4ODQ3Mn0.SoPfuATEdT-VqVBiA84H3A4AcIbR5GNBHdHsWgoeXf0";
		Map<String,String> headerValues= new HashMap<String,String>();
		headerValues.put("Authorization", userToken);
		requestMemberObj.setHeaderValues(headerValues);
		*/
		
		
	
	
		
		
			Map<String,String> headerValues= new HashMap<String,String>();
			headerValues.put("Authorization", LoginStepDefiniation.userToken);
			requestMemberObj.setHeaderValues(headerValues);
			user_gives_as("formParams", "productAddedBy", LoginStepDefiniation.userId);
			
		
		}
	
	@Given("User gives {string} {string} as {string}")
	public void user_gives_as(String paramType, String key,String value) {
	    // Write code here that turns the phrase above into concrete actions
	   if(paramType.equalsIgnoreCase("formParams")) {
		   
		   multiPartValues.put(key, value);
	   }
	   else if(paramType.equalsIgnoreCase("pathParams")) {
		   if(value.equalsIgnoreCase("value"))
			   pathParamValues.put(key,productId);
		   else
			   pathParamValues.put(key,value);
			   
	   }
	}
	@When("User calls the {string} {string} http request")
	public void user_calls_the_http_request(String methodName, String methodtype) {
		if(methodName.equalsIgnoreCase("createProduct")) 
		{
		requestMemberObj.setMultiPartValues(multiPartValues);
		requestMemberObj.setRequestMethod(methodtype);
		res = ProductAPI.createProduct(requestMemberObj);
		}
		
		if(methodName.equalsIgnoreCase("deleteProduct")) {
			
			requestMemberObj.setPathParams(pathParamValues);
			res = ProductAPI.delete(requestMemberObj);
		}
		GlobalStepdefination.response = res;
		apiName = methodName;
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	@Then("Response has {string}")
	public void response_has(String id) {
	    // Write code here that turns the phrase above into concrete actions
	    
	    if(apiName.equalsIgnoreCase("createProduct") && res.statusCode()==201) {
	    	JsonPath createProductJson = new JsonPath(res.asString());
	    	 productId = createProductJson.getString(id);
	    	
	    	Assert.assertNotNull(createProductJson.getString(id));
	    }
	}
	
@Then("API call has response status code {string}")
	
	public void api_call_has_response_status_code(String expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
	    String statusCode =  String.valueOf(res.getStatusCode());
	    Assert.assertEquals(expectedStatusCode, statusCode);
	    
	    
	    
	}




}
