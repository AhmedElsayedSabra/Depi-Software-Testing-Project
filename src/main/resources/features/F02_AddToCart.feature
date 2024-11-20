@Test
Feature: F03_login |User log_ed out

  Background:
    When enter valid username
    And enter valid password
    And click on login button
    Then verify to login page

  Scenario:postive scenario
    When Click on Add to cart
    Then verify that remove is displayed
    When click on shop icon
    Then verify that the product is added to cart




