Feature: Check navigation through pages
  I want to easily navigate through pages

	Scenario: The application is running
		Given that the application is running from results page
		And I click the button Current vote counting
		Then the current number of votes for each option is showed
	
	Scenario: The application is running
		Given that the application is running from vote counting page
		And I click the button See results
		Then the provisional results are showed
	
	
