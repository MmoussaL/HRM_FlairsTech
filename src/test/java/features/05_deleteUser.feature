Business Need: To delete a user from the system
Feature: Delete User
As a user
I want to delete a user
So that he can no longer access the application

  Background:
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And Clicks on the login button
    Then User should be navigated to the home page
    Given I am on the home page
    When I Navigate to Admin tab
    Then I should see the current records
    Given I am on the home page
    When I Navigate to Admin tab
    And I click on Add User button
    And I enter user details
    And I click on Save button
    Then I should see the user added successfully
    Given I am on the home page
    When I Navigate to Admin tab
    And I add username to search with
    And I click on Search button
    Then I should see the user details


  @task
  Scenario: Delete a user
    Given I am on the home page
    When I Navigate to Admin tab
    And I add username to search with
    And I click on Search button
    And I click on Delete User button
    Then I should see the user deleted successfully
    Then close the browser