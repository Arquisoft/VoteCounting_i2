Feature: See results
  I want to see the results of the votation
  
  Scenario: See general results
	Given that I have the application initialized
	When I get in
	Then the provisional general results are showed
	
  Scenario: See results by region
	Given that I have the application initialized
	When I choose the region's option 
	And choose the one we want to see
	Then the provisional result of the region is showed

  Scenario: See results by polling station
	Given that I have the application initialized
	When I choose the polling station's option 
	And choose the one we want to see
	Then the provisional result of the polling station is showed
	
  Scenario: See results by district
	Given that I have the application initialized
	When I choose the district's option 
	And choose the one we want to see
	Then the provisional result of the district is showed
	
  Scenario: Upload result
	Given that I have the application initialized
	When I click the upload button 
	Then an uploaded version the provisional general results are showed 
