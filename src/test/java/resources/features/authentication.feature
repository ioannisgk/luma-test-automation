@UserAuthenticationFeature
Feature: User authentication
	A user should be able to create a new customer account and login with his email and password

Background:
	Given user navigates to "https://comquent.qa/magento2/" website

@RegisterLoginLogoutScenario
Scenario Outline: A user should be able to create a new customer account with valid data
	
	When user clicks on Create an Account link
	Then the Create New Customer Account page should be displayed
	When user enters a "<firstname>" firstname
	And user enters a "<lastname>" lastname
	And user enters a "<email>" email
	And user enters a "<password>" password
	And user enters a "<repeat_password>" repeat password
	And user clicks on Create an Account button
	Then the My Dashboard page should be displayed
	And the "<firstname>" firstname and "<lastname>" lastname should be displayed
	When user clicks on Sign Out button
	Then the Sign In link should be displayed
	And the Create an Account link should be displayed
	

	Examples: 
	| firstname		| lastname		| email					| password		| repeat_password	|
	| John         	| Smith         | ioannisgk25@live.com  | Aa12345678	| Aa12345678		|
	
	
@ValidLoginScenario
Scenario Outline: A user should be able to login with valid data

	When user clicks on Sign In link
	Then the Customer Login page should be displayed
	When user enters a "<email>" email to the login form
	And user enters a "<password>" password to the login form
	And user clicks on Sign In button
	Then the My Dashboard page should be displayed
	And the "<email>" email should be displayed
	
	
	Examples: 
	| email					 | password		|
	| ioannisgk25@live.com   | Aa12345678	|
	
	
@InvalidLoginScenario
Scenario Outline: A user should not be able to login with invalid data

	When user clicks on Sign In link
	Then the Customer Login page should be displayed
	When user enters a "<email>" email to the login form
	And user enters a "<password>" password to the login form
	And user clicks on Sign In button
	Then the Invalid login or password email should be displayed
	
	
	Examples: 
	| email					 | password		|
	| ioannisgk25@live.com   | Aa123456782	|
	