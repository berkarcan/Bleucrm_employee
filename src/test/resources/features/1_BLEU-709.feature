Feature: Find Employee

	Background:
		#@BLEU-690
		Given the user is on the page which has the title "Authorization"
		When the user logins with a valid "username" and "password"
		Then the user should be able to reach the dashboard page with the username on the the top right
		And the user clicks on on "Employees" tab on the Dashboard page
		

	#*User Story:* As a user, I should be able to use functions under Employee menu
	#
	#*Acceptance Criteria:* User should be able to find employees by search by Alphabet.
	@BLEU-707 @BLEU-709
	Scenario: User can find employees by surname initial character
		When the user click on Find Employee menu
		Then "Find Employee" title is displayed with the user list
		When the user clicks Search By Alphabet button
		And the user clicks the initial character "U" of the searched user
		Then the information of the user with initial "U" is displayed	

	#*User Story:* As a user, I should be able to use functions under Employee menu
	#
	#{*}Acceptance Criteria:{*}User should be able to find employees by search box.
	#
	# 
	@BLEU-708 @BLEU-709
	Scenario Outline: User should be able to find employees by searchbox
		When the user click on Find Employee menu
		    Then "Find Employee" title is displayed with the user list
		    When the user inserts "<characters>" and click enter
		   Then the information of the usernames containing "<characters>" is displayed
		    Examples:
		      | characters |
		      | han        |
		      | tek        |
		      | help       |

	@BLEU-711 @BLEU-709
	Scenario: User can find employees by an initial character of a user without surname
		When the user click on Find Employee menu
		Then "Find Employee" title is displayed with the user list
		When the user clicks Search By Alphabet button
		And the user clicks the initial character "M" of the searched user
		Then the information of the user with initial "M" is displayed

	@BLEU-718 @BLEU-709
	Scenario:User should be able to export employee list
		When the user click on Find Employee menu
		And the user clicks on More
		Then the user clicks Export to Excel to save users.xls successfully