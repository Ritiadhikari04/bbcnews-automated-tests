Feature: BBC News Automated Tests
  Automated tests for Search, SignIn/SignOut and 
	
  Background: Browser is started and opened website is bbc.co.uk/news
  	Given Browser has BBC News website opened
		
  @Search
  Scenario: Search Works
    When Search Exists
    Then We are able to search
      
  @SignInSignOut
  Scenario: Perform Sign-in/Sign-Out
    When Has SignIn Option
    Then Perform SignIn
    And SignedIn
    When I click SignOut
    Then I should SignOut
    
  @SearchNewsByRegion
  Scenario: News By Region 
    When Open news of selected Region
    Then all news are of selected region
    