Feature: Validating Urbanladder Website
Scenario Outline: Adding a product to cart as guest
	Given User is searching for a <product>  
	When User selecting on the particular product 
	Then  User adding the product to cart
	Examples:
	|product  |
	|Sofas    |
Scenario: Validating the cart page
	Given User click on the cart 
	When User wait for the page to load
	Then  Validating the text shown
Scenario: Validating Customer Stories page
	Given User scroll down 
	When User click on customer stories
	Then  Validating the images shown
Scenario Outline: Validating track page
	Given User click on track order icon
	When User enter the <orderno> and <phonenumber>
	Then  User click on submit
	Examples:
	|orderno|phonenumber|
	|4567   |7397556789 |
Scenario Outline: Validating Subscription page
	Given User scroll down and send <email> in the box
	When User click on the subscription button
	Then  Verifying the <text>
	Examples:
	|email                   |text                    |
	|nivethas120@gmail.com   |Thanks for subscribing! |
Scenario Outline: Automating signup page 
	Given User open the browser and enters the <email> 
	When User enters <password>
	Then  User clicking on submit
	Examples:
	|email                   |password |
	|nivethas120@gmail.com   |Nivetha7 |
Scenario Outline: Validating Q and A page
	Given User clicks on the help button
	When User asks for a <question>
	Then  verifing the obtained <data>
	Examples:
	|question       |data                                                   |
	|Warranty       |What warranty does Urban Ladder have for its products? |
Scenario Outline: Automating login page
	Given User selects the login icon
	When User gives the <email> and <password>
	Then  User clicks on login
	Examples:
	|email                       |password |
	|nivethas120@gmail.com       |Nivetha7 |
Scenario Outline: Validating search page
	Given User searches for a <product>
	When User select the search button
	Then <product> is validated
	Examples:
	|product   |
	|Sofas     |		
Scenario Outline: Validating gift card page
	Given User selecting the required gift card
	When User entering the details in the gift card
	Then Checking the next button 
	Examples:
	|message                                  |
	|Delivered via email as soon as now, or any other day you’d like    |	
