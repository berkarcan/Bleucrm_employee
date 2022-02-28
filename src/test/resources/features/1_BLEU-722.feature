Feature: Telephone Directory functionality tests

	Background:
		#@BLEU-690
		Given the user is on the page which has the title "Authorization"
		When the user logins with a valid "username" and "password"
		Then the user should be able to reach the dashboard page with the username on the the top right
		And the user clicks on on "Employees" tab on the Dashboard page
		

	#*User Story:* As a user, I should be able to use functions under Employee menu
	#
	# *Acceptance Criteria:*
	# # User should be able to display company structure. 
	# # User should be able to add a department.
	# # User should be able to find employees by search box.
	# # User should be able to find employees by search by Alphabet.
	# # User should be able to export the employee list.
	# # *User should be able to display telephone directory.*
	# # User should be able to send message to employee from the telephone directory.
	@BLEU-719 @BLEU-722
	Scenario: User can display telephone directory.
		When User clicks on Telephone Directory tab next to Find Employee tab
		    Then "Telephone Directory" title is displayed with the following columns for the information of users
		      | Full Name        |
		      | E-Mail           |
		      | Position         |
		      | Work Phone       |
		      | Extension number |
		      | Skype            |

	@BLEU-720 @BLEU-722
	Scenario: User should be able to send a text message to employee from the telephone directory
		When User clicks on Telephone Directory tab next to Find Employee tab
		And User clicks on an any info of a user e.g. "John Terry" in the directory
		And User clicks Send message
		And User inserts a message e.g. "Ciao. Come butta?" into the textbox where there is Enter message note
		Then the inserted message "Ciao. Come butta?" is displayed on the messages screen

	#*User Story:* As a user, I should be able to use functions under Employee menu
	#
	# 
	#
	#*Acceptance Criteria:*
	# # User should be able to display company structure. 
	# # User should be able to add a department.
	# # User should be able to find employees by search box.
	# # User should be able to find employees by search by Alphabet.
	# # User should be able to export the employee list.
	# # User should be able to display telephone directory
	# # *User should be able to send message to employee from the telephone directory*
	@BLEU-721 @BLEU-722
	Scenario: User should be able to send a gif message to employee from the telephone directory
		When User clicks on Telephone Directory tab next to Find Employee tab
		And User clicks on an any info of a user e.g. "John Terry" in the directory
		And User clicks Send message
		And User clicks Browse and select relevant GIF images below the textbox
		Then the user will not have "Error getting signature. Please contact the Helpdesk." message