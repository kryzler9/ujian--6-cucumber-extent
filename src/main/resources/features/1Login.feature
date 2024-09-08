Feature: Login functionality

  #Test 001
  Scenario: Successful login with valid credentials
    Given I am on the SwagLabs login page
    When I enter a valid username and password
    And I click on the login button
    Then I should be redirected to the products page

  #Test 002
  Scenario: Unsuccessful login with wrong username or password
    Given I am on the SwagLabs login page
    When I enter an invalid username and password
    And I click on the login button
    Then I should see username and password do not match

  #Test 003
  Scenario: Unsuccessful login without password
    Given I am on the SwagLabs login page
    When I enter a valid username without password
    And I click on the login button
    Then I should see password required

  #Test 004
  Scenario: Unsuccessful login without username
    Given I am on the SwagLabs login page
    When I enter nothing on username and a valid password
    And I click on the login button
    Then I should see username required