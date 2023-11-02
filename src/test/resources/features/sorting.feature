Feature: Sorting

  Scenario: choose price (high to low)
    Given user launch saucedemo web app
    When user click Name (A to Z) in top right of page
    And user choose price (high to low)
    Then will display list product in home page will sorting based on price high to low