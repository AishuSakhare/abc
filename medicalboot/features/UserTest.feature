@taguser
Feature: Testing Admin Portal


Background: 
	Given Open the chrome and open the appliaction 
	When Enter the valid user email 
	When Enter the valid user password 
	And click on user login  button 
	Then the user ProductList page must be displayed 
	
	@tag4 
	Scenario: Add the products to cart 
	When   Click on add button.
	When   Enter quantity in textfield. 
	And   Click on add button of popup. 
	And Click on cross link.
	Then Open user cart link
	And Click on Buy Button
	And Click on Pay Button
	And Click on cross link of that popup
	Then Add product logout
	
	@tag5 
	Scenario: Discussion Board 
	When   Click discussion board link
	When  Enter message on text field 
	Then   Click on Message Button. 
	Then Add product logout

	
	