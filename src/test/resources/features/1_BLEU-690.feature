Feature: Default

	Background:
		#@BLEU-690
		Given the user is on the page which has the title "Authorization"
		When the user logins with a valid "username" and "password"
		Then the user should be able to reach the dashboard page with the username on the the top right
		
		

	#{color:#cc7832}When {color}the user clicks on on {color:#297bde}"Employees"{color} tab on the Dashboard page
	#{color:#cc7832}Then {color}the user should be able to see {color:#297bde}"Company Structure"{color} title
	@BLEU-692 @BLEU-691
	Scenario: user can see company structure
		When the user clicks on on "Employees" tab on the Dashboard page
		Then the user should be able to see "Company Structure" title	

	#{color:#cc7832}When {color}the user clicks on on {color:#297bde}"Employees"{color} tab on the Dashboard page
	#{color:#cc7832}And {color}the user click on Add department button
	#{color:#cc7832}Then {color}the user should be able insert department name and click ADD
	@BLEU-693 @BLEU-691
	Scenario: user can edit company structure
		When the user clicks on on "Employees" tab on the Dashboard page
		And the user click on Add department button
		Then the user should be able insert department name and click ADD