package com.PojoClasses;

import java.util.Map;

public class RequestMembers {
	String requestMethod;
	String endpoint;
	String baseURL;
	Map<String,String> queryParams;
	Map<String,String> pathParams;
	Map<String,String> headerValues;
	String contentType;
	Map<String,String> bodyValues;
	Map<String,String> multiPartValues;
	public String getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getBaseURL() {
		return baseURL;
	}
	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}
	public Map<String, String> getQueryParams() {
		return queryParams;
	}
	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}
	public Map<String, String> getPathParams() {
		return pathParams;
	}
	public void setPathParams(Map<String, String> pathParams) {
		this.pathParams = pathParams;
	}
	public Map<String, String> getHeaderValues() {
		return headerValues;
	}
	public void setHeaderValues(Map<String, String> headerValues) {
		this.headerValues = headerValues;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public Map<String, String> getBodyValues() {
		return bodyValues;
	}
	public void setBodyValues(Map<String, String> bodyValues) {
		this.bodyValues = bodyValues;
	}
	public Map<String, String> getMultiPartValues() {
		return multiPartValues;
	}
	public void setMultiPartValues(Map<String, String> multiPartValues) {
		this.multiPartValues = multiPartValues;
	}
}
