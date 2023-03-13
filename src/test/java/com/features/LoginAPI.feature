#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Validating Login API


Scenario Outline: Login with valid username and password
    Given User has the payload for login "<username>" "<password>"
    When User call the "LoginAPI" "POST" http request
    Then API call has status code "<statusCode>"
    And "message" in the response body is "<expectedMessage>"
    
 Examples:
 |username|password|statusCode|expectedMessage|
 |ashwini.spare@gmail.com|arj14rsj|200|Login Successfully|
 
 Scenario Outline: Login with invalid username and password
    Given User has the payload for login "<username>" "<password>"
    When User call the "LoginAPI" "POST" http request
    Then API call has status code "<statusCode>"
    And "message" in the response body is "<expectedMessage>"
    
  Examples:
 |username|password|statusCode|expectedMessage|
 |ashwini.sp|arj14rsj|400|Incorrect email or password.|
 