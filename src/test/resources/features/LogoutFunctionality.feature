Feature:  logout functionality

  Scenario: Test the logout functionality
    Given I am on the EBankApp page Launch Browser valid User ID ,Pin And logout
    When I am enter the valid User ID and PIN in input field in Logout test
    And After given valid User ID and PIN I click the Login button in logout test
    And  After click on the login and Wait for the page to be redirected to Homepage
    And After redirected to homepage and Click on Logout Button
    Then  After ClickOn Logout I should be Show the Login Page
