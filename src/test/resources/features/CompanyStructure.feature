
Feature: Users should be able to see and edit company structure

  Background: The user reaches to the Employees section successfully
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

  Scenario: user can see company structure
    Then the user should be able to see "Company Structure" title

  Scenario: user can edit company structure
    And the user click on Add department button
    Then the user should be able insert department name and click ADD