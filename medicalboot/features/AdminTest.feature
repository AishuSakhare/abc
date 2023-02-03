@tagadmin
Feature: Testing Admin Portal


Background: 
	Given Open the chrome and launch the application 
	When Enter the valid email 
	When Enter the valid password 
	And click on login button 
	Then the ProductList page must be displayed 
	
	@tag1 
	Scenario: Add the products 
	When   Click on add Product link. 
	When   add all the Product information avaliable. 
	Then   It add present product details. 
	
	@tag2 
	Scenario: Update and delete product from product list 
	When   Click on update button 
	When   add all updated the Product information avaliable. 
	Then   It will add updated product details. 
	Then   Click on Cross Link 

	@tag3 
	Scenario:  delete product from product list 
	When   Click on delete button 
	
	