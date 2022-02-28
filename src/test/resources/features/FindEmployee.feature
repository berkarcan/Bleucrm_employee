
Feature: User can find employees by Alphabet or Searchbox and export employee list
  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

    Scenario: User can find employees by surname initial character
      When the user click on Find Employee menu
      Then "Find Employee" title is displayed with the user list
      When the user clicks Search By Alphabet button
      And the user clicks the initial character "U" of the searched user
      Then the information of the user with initial "U" is displayed

  Scenario: User can find employees by an initial character of a user without surname
    When the user click on Find Employee menu
    Then "Find Employee" title is displayed with the user list
    When the user clicks Search By Alphabet button
      And the user clicks the initial character "M" of the searched user
    Then the information of the user with initial "M" is displayed

  Scenario Outline: User can find employees by searchbox
    When the user click on Find Employee menu
    Then "Find Employee" title is displayed with the user list
    When the user inserts "<characters>" and click enter
    Then the information of the usernames containing "<characters>" is displayed
    Examples:
      | characters |
      | han        |
      | tek        |
      | help       |

  Scenario: User should be able to export employee list
    When the user click on Find Employee menu
    And the user clicks on More
    Then the user clicks Export to Excel to save users.xls successfully

