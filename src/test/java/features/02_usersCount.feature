Business Need: To get the count of users
Feature: Users Count
As a user
I want to get the count of users
So that I can know how many users are there in the application

  Background:
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And Clicks on the login button
    Then User should be navigated to the home page

  Scenario: count the current records
    Given I am on the home page
    When I Navigate to Admin tab
    Then I should see the current records