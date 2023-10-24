Feature: Login Functionality

  Scenario:User login using registered user and password
    Given User should be open https://www.saucedemo.com/ in web browser
    When User input valid username and password
    And User click on login button
    Then User should navigate to swag labs home page