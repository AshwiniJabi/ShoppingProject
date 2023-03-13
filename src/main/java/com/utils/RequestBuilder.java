package com.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.PojoClasses.RequestMembers;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
	RequestSpecification requestObj = null;
	static RequestSpecBuilder requestSpecObj = null;
	public static RequestSpecBuilder buildRequest(RequestMembers requestMemberObj) {
		
		
		String contentType = requestMemberObj.getContentType();
		String baseurl = requestMemberObj.getBaseURL();
		
		requestSpecObj = new RequestSpecBuilder().setBaseUri(baseurl);
		if(!(requestMemberObj.getHeaderValues() == null)) {
			requestSpecObj.addHeaders(requestMemberObj.getHeaderValues());
		}
	
		if(!(requestMemberObj.getQueryParams()== null)) {
			//build the query param
			requestSpecObj.addQueryParams(requestMemberObj.getQueryParams());
		}
		if(!(requestMemberObj.getPathParams() == null)) {
			//build the query param
			requestSpecObj.addPathParams(requestMemberObj.getPathParams());
		}
		
		if(contentType.equalsIgnoreCase("multipart/form-data") && !(requestMemberObj.getMultiPartValues() == null)) {
			//build multipart values
			addMultiPart(requestMemberObj.getMultiPartValues());
		}
		
		
		return requestSpecObj;
	}
	private static void addMultiPart(Map<String, String> multiPartValues) {
		 Map<String,String> myMap= new HashMap<String,String>();
		 myMap = multiPartValues;
		 String a = ".jpeg";
		 for (Map.Entry<String,String> entry : myMap.entrySet()) {
			 if(entry.getValue().toLowerCase().contains(a.toLowerCase())) {
				 requestSpecObj.addMultiPart(entry.getKey(), new File(entry.getValue()));
			 }
			 	  requestSpecObj.addMultiPart(entry.getKey(), entry.getValue());
		 }
	}

}
