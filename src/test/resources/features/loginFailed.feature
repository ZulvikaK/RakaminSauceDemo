Feature: Login functionality

  Scenario: User login using invalid username and valid password
    Given User should be open https://www.saucedemo.com/ in web browser
    When User enter the invalid username and password
    And User click login button
    Then User get error message