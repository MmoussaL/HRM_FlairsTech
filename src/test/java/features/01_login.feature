Business Need: To verify the login functionality of the application
Feature: Login
    As a user
    I want to login to the application
    So that I can access the application

  @login @smoke @regression @sanity @functional
  Scenario: Verify the login functionality with valid credentials
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And Clicks on the login button
    Then User should be navigated to the home page