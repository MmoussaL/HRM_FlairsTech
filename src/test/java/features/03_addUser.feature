Business Need: To add a new user to the system
Feature: Add User
As a user
I want to add a new user
So that he can access the application

  Background:
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And Clicks on the login button
    Then User should be navigated to the home page


  Scenario: Add a new user
    Given I am on the home page
    When I Navigate to Admin tab
    And I click on Add User button
    And I enter user details
    And I click on Save button
    Then I should see the user added successfully