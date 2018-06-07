
Feature: Logging into ClientWorks
 
  Scenario: Logging into ClientWorks
    Given I go to "URL" on "CHROME"
    And I enter "UserName" as "Vaishali.Zachrich"
    And I enter "Password" as "P@ssw0rd"
    And I Click on "Login" button
    Then Login should be "Successfull"
    
