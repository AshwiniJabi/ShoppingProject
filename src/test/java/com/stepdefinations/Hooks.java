package com.stepdefinations;

import java.io.IOException;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;




public class Hooks {
@Before(order =1)
public void loginScenario() throws IOException {
	System.out.println();
	LoginStepDefiniation login = new LoginStepDefiniation();
	if(LoginStepDefiniation.userToken == null) {
		String userName = "ashwini.spare@gmail.com";
		String password = "arj14rsj";
		login.user_has_the_payload_for_login(userName, password);
		login.user_call_the_http_request("LoginAPI", "POST");
		login.api_call_has_status_code("200");
		System.out.println(LoginStepDefiniation.userId);
		System.out.println(LoginStepDefiniation.userToken);
	
		
	}
	
}	
@Before("@DeleteProduct")
public void createProduct() throws IOException {
if(ProductAPIStepDefinination.productId == null) {
	
	ProductAPIStepDefinination product = new ProductAPIStepDefinination();
	product.user_has_valid_usertoken();
	product.user_gives_as("formParams","productName","Mango") ;
	product.user_gives_as("formParams","productCategory","Fashion") ;
	product.user_gives_as("formParams","productSubCategory","Tops") ;
	product.user_gives_as("formParams","productPrice","1000") ;
	product.user_gives_as("formParams","productDescription","Must Have") ;
	product.user_gives_as("formParams","productFor", "Women") ;
	product.user_gives_as("formParams", "productImage","/Users/anupamkumarmeti/Desktop/Ashwini/EclipseWorkspace/eCommerceRest/src/test/resources/images/babyFrock.jpeg") ;
	product.user_calls_the_http_request("createProduct", "POST");
	product.response_has("productId");
}
	
}

}