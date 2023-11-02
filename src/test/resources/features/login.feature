Feature: Login Functionality

  Scenario:User login using registered user and password
    Given user launch swag labs web
    When user input valid username and password
    And user click on login button
    Then user should navigate to swag labs home page