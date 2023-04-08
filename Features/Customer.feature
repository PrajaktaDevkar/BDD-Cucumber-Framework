Feature: Customer
Scenario: Add a new user

Given User launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/login"
And user enter Email as "admin@yourstore.com" and password as "admin"
And click on login
Then User can view Dashboard
When User click on customers Menu
And click on customer Menu Item
And click on Add new button
Then User can view add new customer page
When User enter customer info
And click on save button
Then User can view confirmation message "The new customer has been added successfully."
And close browser



Scenario: Search by customer Email

Given User launch chrome browser
When user open URL "https://admin-demo.nopcommerce.com/login"
And user enter Email as "admin@yourstore.com" and password as "admin"
And click on login
Then User can view Dashboard
When User click on customers Menu
And click on customer Menu Item
And Enter customer Email
When click on search button
Then user should found email in the search table
And close browser




