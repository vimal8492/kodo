#Author: vimal.shukl84@gmail.com
Feature:  Search Functionality of AutomationPractice e-commerce website
	In order to search an item on automationpractice e-commerce website
	I should be able to search the item
	I should do checkout with that item
	
Scenario: Login Successful
Given I am in landing page of the e-commerce application
When I enter valid credentials
Then I should be taken to home page as logged in user

Scenario: Search for valid product

Given I am in landing page of the application
And Logged in as existing customer
When I enter a product name in search box
Then Results are displayed on search page

Scenario: Add item from search page
Given I am in landing page of the e-commerce application
And Logged in as existing customer
When Product is searched from search box
And Add to cart button is pressed
Then Item should be added to users cart


Scenario: View product decsription page
Given I am in landing page of the e-commerce application
And Logged in as existing customer
When Product is searched from search box
And first products image is clicked
Then Product description page for item is displayed

Scenario: Search for invalid product
Given I am in landing page of the e-commerce application
And Logged in as existing customer
When invalid product is searched from search box
Then an error message is displayed indicating about wrong product


Scenario: Sort feature for searched product
Given I am in landing page of the e-commerce application
And searched for a product from search box
When Sort By drop down is selected
And lowest option is clicked
Then product having lowest price is diplayed first

Scenario: Navigate to home page from search page
Given I am in landing page of the e-commerce application
And searched for a product from search box
When Seaerch result is displayed
And Application logo is clicked
And User is navigated back to home page

Scenario: Compare searched products
Given I am in landing page of the e-commerce application
And Logged in as existing customer
And searched for a product from search box
When Add to compare button is pressed for dispayed item
And Another item is selected for compare
Then Compare reult page is displayed with both products














