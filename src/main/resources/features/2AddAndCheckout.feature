Feature: Add Products and Checkout Functionality

  #Test 005
  Scenario: Successfully added 2 products and checkout
    Given I am logged into SwagLabs
    When I added two products
    And I click my cart button
    And I fill the Name and Postal Code
    And I should be redirected to the checkout page and click finish
    Then I should see Thank you for your order

  #Test 006
  Scenario: After added products and emptying the postal code
    Given I am logged into SwagLabs
    And I click my cart button
    When I empty the postal code
    Then I should see Postal Code is required

  #Test 007
  Scenario: After added products and emptying the last name
    Given I am logged into SwagLabs
    And I click my cart button
    When  I empty the last name
    Then I should see Last Name is required