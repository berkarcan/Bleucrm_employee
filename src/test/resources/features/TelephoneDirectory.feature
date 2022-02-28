Feature:Telephone Directory

  Background:
    Given the user is on the page which has the title "Authorization"
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right
    And the user clicks on on "Employees" tab on the Dashboard page

  Scenario: User can display telephone directory
    When User clicks on Telephone Directory tab next to Find Employee tab
    Then "Telephone Directory" title is displayed with the following columns for the information of users
      | Full Name        |
      | E-Mail           |
      | Position         |
      | Work Phone       |
      | Extension number |
      | Skype            |

  Scenario: User should be able to send a text message to employee from the telephone directory
    When User clicks on Telephone Directory tab next to Find Employee tab
    And User clicks on an any info of a user e.g. "John Terry" in the directory
    And User clicks Send message
    And User inserts a message e.g. "Ciao. Come butta?" into the textbox where there is Enter message note
    Then the inserted message "Ciao. Come butta?" is displayed on the messages screen
  @wip
  Scenario: User should be able to send a gif message to employee from the telephone directory
    When User clicks on Telephone Directory tab next to Find Employee tab
    And User clicks on an any info of a user e.g. "John Terry" in the directory
    And User clicks Send message
    And User clicks Browse and select relevant GIF images below the textbox
    Then the user will not have "Error getting signature. Please contact the Helpdesk." message