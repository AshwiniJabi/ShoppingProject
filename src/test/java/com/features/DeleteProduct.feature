#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
Feature: validate delete product API 
@DeleteProduct
Scenario: With the usertoken user should be able to delete a exsisting product using DeleteProductAPI
Given User has valid usertoken
And User gives "pathParams" "productId" as "value"
When User calls the "deleteProduct" "DELETE" http request 
Then API call has response status code "200"
And "message" in the response body is "Product Deleted Successfully"


Scenario: With the usertoken user is trying to delete a non exsisting product
Given User has valid usertoken
And User gives "pathParams" "productId" as "640f0be0568c3e9fb130b6b5"
When User calls the "deleteProduct" "DELETE" http request 
Then API call has response status code "400"
And "message" in the response body is "Product not foundd"

Scenario: With the usertoken user is trying to delete a product added by another user
Given User has valid usertoken
And User gives "pathParams" "productId" as "6262e9d9e26b7e1a10e89c04"
When User calls the "deleteProduct" "DELETE" http request 
Then API call has response status code "403"
And "message" in the response body is "You are not authorize to delete this product"
