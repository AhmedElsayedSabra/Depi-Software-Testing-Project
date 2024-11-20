@Test
Feature: F03_Checout and payment

  Background:
    When enter valid username
    And enter valid password
    And click on login button
    Then verify to login page
    When Click on Add to cart
    Then verify that remove is displayed
    When click on shop icon
    Then verify that the product is added to cart

  Scenario: checkout
    When your cart page is visible successfully
    Then Click on checkout button
    And enter your first name
    And enter your last name
    And enter your postal code
    Then Verify that form data is valid
    And click on continue button
    Then Verify that detail of payment is visible
    When click on finish button
    And Checkout: Complete! page is displayed
    And Click on Back Home
    Then Verify that Login page is visible






