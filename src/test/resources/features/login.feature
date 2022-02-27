Feature: Users should be able to login

  Background:
    Given the user is on the page which has the title "Authorization"

  Scenario: Login as an authorized user
    When the user logins with a valid "username" and "password"
    Then the user should be able to reach the dashboard page with the username on the the top right

  Scenario: Login as an unauthorized user with wrong username
    When the user logins with invalid credential "any_username" username "UserUser" password
    Then the user should be able to have "Incorrect login or password" message

  Scenario: Login as an unauthorized user with wrong password
    When the user logins with invalid credential "hr12@cybertekschool.com" username "any_password" password
    Then the user should be able to have "Incorrect login or password" message

  Scenario: Login with blank credentials
    When the user logins with invalid credential "" username "" password
    Then the user should be able to have "Incorrect login or password" message

  Scenario: Remember user
    When the user logins with valid "username" and "password" clicking on Remember check box
    And the user logout
    Then the user is on the page which has the title "Authorization"
    Then the username remains on the username box


  Scenario: Forgot password retrieval with correct username
    When the user clicks on the Forgot your password? link
    And the user is on the page which has the title "Get Password"
    And Inserts login or email clicks to reset "Reset password"
    Then the user sees a message containing "sent to your e-mail address"


  Scenario Outline: Forgot password with retrieval incorrect username
    When the user clicks on the Forgot your password? link
    And the user is on the page which has the title "Get Password"
    Then Inserts incorrect "<login>" or "<email>" clicks to reset "Reset password" and sees "Login or E-mail not found"
    Examples:
      | login                   | email                   |
      |                         | wrongusername@gmail.com |
      | wrongusername@yahoo.com |                         |
      | wrongusername@gmail.com | wrongusername@yahoo.com |


