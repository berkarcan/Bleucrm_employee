Feature: Default

	Background:
		#@BLEU-680
		Given the user is on the page which has the title "Authorization"
		

	
	@BLEU-682 @BLEU-681
	Scenario: Login as an authorized user
		When the user logins with a valid "username" and "password"
		Then the user should be able to reach the dashboard page with the username on the the top right	

	
	@BLEU-683 @BLEU-681
	Scenario: Login as an unauthorized user with wrong username
		When the user logins with invalid credential "any_username" username "UserUser" password
		Then the user should be able to have "Incorrect login or password" message	

	#{color:#cc7832}When {color}the user logins with invalid credential {color:#297bde}"hr12@cybertekschool.com"{color} username {color:#297bde}"any_password"{color} password
	#{color:#cc7832}Then {color}the user should be able to have {color:#297bde}"Incorrect login or password"{color} message
	@BLEU-684 @BLEU-681
	Scenario: Login as an unauthorized user with wrong password
		When the user logins with invalid credential "hr12@cybertekschool.com" username "any_password" password
		    Then the user should be able to have "Incorrect login or password" message	

	#{color:#cc7832}When {color}the user logins with invalid credential {color:#297bde}""{color} username {color:#297bde}""{color} password
	#{color:#cc7832}Then {color}the user should be able to have {color:#297bde}"Incorrect login or password"{color} message
	@BLEU-685 @BLEU-681
	Scenario: Login with blank credentials
		When the user logins with invalid credential "" username "" password
		    Then the user should be able to have "Incorrect login or password" message	

	#{color:#cc7832}When {color}the user logins with valid {color:#297bde}"username"{color} and {color:#297bde}"password"{color} clicking on Remember check box
	#{color:#cc7832}And {color}the user logout
	#{color:#cc7832}Then {color}the user is on the page which has the title {color:#297bde}"Authorization"
	#{color}{color:#cc7832}Then {color}the username remains on the username box
	@BLEU-686 @BLEU-681
	Scenario: Remember user
		When the user logins with valid "username" and "password" clicking on Remember check box
		And the user logout
		Then the user is on the page which has the title "Authorization"
		Then the username remains on the username box	

	#{color:#cc7832}When {color}the user clicks on the Forgot your password? link
	#{color:#cc7832}And {color}the user is on the page which has the title {color:#297bde}"Get Password"
	#{color}{color:#cc7832}And {color}Inserts login or email clicks to reset {color:#297bde}"Reset password"
	#{color}{color:#cc7832}Then {color}the user sees a message containing {color:#297bde}"sent to your e-mail address"{color}
	@BLEU-687 @BLEU-681
	Scenario: Forgot password retrieval with correct username
		When the user clicks on the Forgot your password? link
		And the user is on the page which has the title "Get Password"
		And Inserts login or email clicks to reset "Reset password"
		Then the user sees a message containing "sent to your e-mail address"	

	#{color:#cc7832}When {color}the user clicks on the Forgot your password? link
	#{color:#cc7832}And {color}the user is on the page which has the title {color:#297bde}"Get Password"
	#{color}{color:#cc7832}Then {color}Inserts incorrect {color:#297bde}"<login>"{color} or {color:#297bde}"<email>"{color} clicks to reset {color:#297bde}"Reset password"{color} and sees {color:#297bde}"Login or E-mail not found"
	#{color}{color:#cc7832}Examples{color}:
	#{color:#cc7832}| {color}{color:#9876aa}login {color}{color:#cc7832}| {color}{color:#9876aa}email {color}{color:#cc7832}|
	#{color}{color:#cc7832} | | {color}{color:#297bde}wrongusername@gmail.com {color}{color:#cc7832}|
	#{color}{color:#cc7832} | {color}{color:#297bde}wrongusername@yahoo.com {color}{color:#cc7832}| |
	#{color}{color:#cc7832} | {color}{color:#297bde}wrongusername@gmail.com {color}{color:#cc7832}| {color}{color:#297bde}wrongusername@yahoo.com {color}{color:#cc7832}|{color}
	@BLEU-688 @BLEU-681
	Scenario Outline: Forgot password with retrieval incorrect username
		When the user clicks on the Forgot your password? link
		    And the user is on the page which has the title "Get Password"
		    Then Inserts incorrect "<login>" or "<email>" clicks to reset "Reset password" and sees "Login or E-mail not found"
		    Examples:
		      | login                   | email                   |
		      |                         | wrongusername@gmail.com |
		      | wrongusername@yahoo.com |                         |
		      | wrongusername@gmail.com | wrongusername@yahoo.com |