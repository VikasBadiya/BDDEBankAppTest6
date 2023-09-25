Feature: login functionality

  Scenario: login functionality with empty fields
    Given I am on the EBankApp page with the Empty fields
    When I click the Login button
    Then The EBankApp page should be show the Error Message

   #Test the login functionality with an empty User ID field

  Scenario: login functionality with an empty User ID field
    Given I am on the EBankApp page
    When I am enter the pin in input field and with empty user Id
    And After given pin I click the Login button
    Then The EBankApp page should be show the Error Message Invalid user ID

  #Test the login functionality with an empty PIN field

  Scenario: login functionality with an empty PIN field
    Given I am on the EBankApp page Launch Browser
    When I am enter the user Id in input field and with empty PIN
    And After given User Id I click the Login button
    Then The EBankApp page should be show the Error Message Invalid PIN

   #Test the login functionality with an invalid PIN field
  Scenario: login functionality with an invalid PIN field
    Given I am on the EBankApp page Launch Browser invalid PIN field
    When I am enter the User Id And invalid PIN field in input field
    And After given User Id And Pin I click the Login button
    Then The EBankApp page should be show the Error Message Invalid PIN Text


    #Test the login functionality with a valid User ID and PIN
  Scenario: login functionality with a valid User ID and PIN
    Given I am on the EBankApp page Launch Browser valid User ID and PIN
    When I am enter the valid User ID and PIN in input field
    And After given valid User ID and PIN I click the Login button
    Then The EBankApp page should be show the Error Message valid User ID and PIN
