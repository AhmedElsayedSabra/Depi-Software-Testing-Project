Feature: Product Sorting and Filtering

  Background:
    When enter valid username
    And enter valid password
    And click on login button
    Then verify to login page

  Scenario: Sorting products by price from high to low
    # Given I am on the products page
    When I select the sorting option
    Then the products should be sorted by price in descending order