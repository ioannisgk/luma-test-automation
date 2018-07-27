@ShoppingCartFeature
Feature: Shopping cart
	A user should be able to add an item to shopping cart and see the correct amount in cart area
	
	
Scenario Outline: A user should be able to select an item, add it to cart
				and see the correct amount in cart area
				
	Given user navigates to "https://comquent.qa/magento2/" website
	When user clicks on Sale link
	Then the Sale page should be displayed
	When user clicks on Hoodies and Sweatshirts link
	Then the Hoodies and Sweatshirts page should be displayed
	When user clicks on "<item_title>" item title
	Then the "<item_title>" item title page should be displayed
	When user clicks on Color
	And user clicks on Size
	And user enters "<quantity>" quantity
	And user clicks on Add to Cart button
	Then confirmation message "<item_title>" should appear
	When user clicks on Show Cart button
	Then the Cart Subtotal amount should be correct "<quantity>" X "<price>"
	
	Examples: 
	| item_title			| quantity	 | email					| password				 | price       | shipping_method	|
	| Mona Pullover Hoodlie | 10		 | roni_cost@example.com    | roni_cost3@example.com | 57  		   | Free Shipping  	|
	
