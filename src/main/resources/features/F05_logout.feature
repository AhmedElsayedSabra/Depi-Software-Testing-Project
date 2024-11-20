Feature: Logout functionality
  As a logged-in user
  I want to be able to log out of the system
  So that my session is securely terminated

  Background:
    When enter valid username
    And enter valid password
    And click on login button
    Then verify to login page

  Scenario: User successfully logs out
3
    When I click on the logout button
    #Then I should be redirected to the login page
    And the login page should be displayed
