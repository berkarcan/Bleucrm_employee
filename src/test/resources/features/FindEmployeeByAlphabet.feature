
Feature: User should be able to find employees by search by Alphabet
  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

    Scenario: User can find employees by surname initial character
      When the user click on Find Employee menu
      Then "Find Employee" title is displayed with the user list
      When the user  clicks Search By Alphabet button
      And the user clicks the initial character "U" of the searched user
      Then the information of the user with initial "U" is displayed

  Scenario: User can find employees by an initial character of a user without surname
    When the user click on Find Employee menu
    Then "Find Employee" title is displayed with the user list
    When the user  clicks Search By Alphabet button
      And the user clicks the initial character "M" of the searched user
    Then the information of the user with initial "M" is displayed

