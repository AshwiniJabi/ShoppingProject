package com.ShoppingAPI;

import static io.restassured.RestAssured.given;

import com.PojoClasses.RequestMembers;
import com.utils.RequestBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ProductAPI {
 public static Response createProduct(RequestMembers requestMemObj ) {
	 requestMemObj.setBaseURL("https://rahulshettyacademy.com/");
	 requestMemObj.setContentType("multipart/form-data");
		requestMemObj.setRequestMethod("POST");
		requestMemObj.setEndpoint("api/ecom/product/add-product");
	 RequestSpecBuilder requestSpecObj = RequestBuilder.buildRequest(requestMemObj);
		//RequestSpecification request= requestSpecObj.build();
		RequestSpecification createProduct = given().spec(requestSpecObj.build()).log().all();
		Response res = createProduct.when().post(requestMemObj.getEndpoint()).then().log().all().extract().response();
	return res;
}
}
