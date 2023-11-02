Feature: Login functionality

  Scenario: User login using invalid username and valid password
    Given user access swag labs login page
    When user input invalid username and password
    And click button login
    Then user get error message