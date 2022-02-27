@wip
Feature: User should be able to find employees by searchbox

  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

  Scenario Outline: User can find employees by surname initial character
    When the user click on Find Employee menu
    Then "Find Employee" title is displayed with the user list
    When the user inserts "<characters>" and click enter
    Then the number of retrieved users equals to the number users containing "<characters>"
    And the information of the usernames containing "<characters>" is displayed
    Examples:
      | characters |
      | han        |
      | tek        |
      | help       |

