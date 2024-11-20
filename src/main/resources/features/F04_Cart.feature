Feature: Cart functionality

  Background:
    When enter valid username
    And enter valid password
    And click on login button
    Then verify to login page

  Scenario: Add a product to the cart
    When I add a product to the cart
    Then the product should be added to the cart
    And I click on the cart icon
    Then I should see the cart page
    And the product "Sauce Labs Backpack" should be in the cart

  Scenario: Remove a product from the cart
    When I remove the product from the cart
    Then the cart should be empty