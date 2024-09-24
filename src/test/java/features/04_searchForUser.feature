Business Need: To search for a user
Feature: Search For User
As a user
I want to search for a user
So that I can find the user

  Background:
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And Clicks on the login button
    Then User should be navigated to the home page

  Scenario: Search for a user
    Given I am on the home page
    When I Navigate to Admin tab
    And I add username to search with
    And I click on Search button
    Then I should see the user details