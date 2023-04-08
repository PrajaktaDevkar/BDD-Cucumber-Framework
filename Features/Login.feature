Feature: Login
Scenario: Sucessful Login with valid credentials

Given User launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/login"
And user enter Email as "admin@yourstore.com" and password as "admin"
And click on login
Then page title should be "Dashboard / nopCommerce administration"
When user click on log out link
Then page title should be "Your store. Login"
And close browser


Scenario Outline: Login with Data Driven
Given User launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/login"
And user enter Email as "<email>" and password as "<password>"
And click on login
Then page title should be "Dashboard / nopCommerce administration"
When user click on log out link
Then page title should be "Your store. Login"
And close browser

Examples: 
	| email | password |
	| admin@yourstore.com | admin |
	| admin123@yourstore.com | admin123 |