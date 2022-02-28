
Feature: User should be able to export employee list
  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

    Scenario:
      When the user click on Find Employee menu
      And the user clicks on More
      Then the user clicks Export to Excel to save users.xls successfully

