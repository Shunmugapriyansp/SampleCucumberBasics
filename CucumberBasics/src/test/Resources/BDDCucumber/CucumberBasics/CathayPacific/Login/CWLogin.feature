
Feature: Logging into CathayPacific

  Scenario: Logging into CathayPacific
    Given I go to "URL" on "CHROME"
    And I enter "UserName" as "Priyan"
    And I enter "Password" as "P@ssw0rd"
    And I Click on "Login" button
    Then Login should be "Successfull"
