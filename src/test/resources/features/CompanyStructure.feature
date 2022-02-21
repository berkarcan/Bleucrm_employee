
Feature: Users should be able to see and edit company structure

  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right

  Scenario: user can see company structure
    When the user clicks on on "Employees" tab on the Dashboard page
    Then the user should be able to see "Company Structure" title

  Scenario: user can edit company structure
    When the user clicks on on "Employees" tab on the Dashboard page
    And the user click on Add department button
    Then the user should be able insert department name and click ADD