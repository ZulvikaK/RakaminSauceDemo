Feature: Sorting

  Scenario: choose price (high to low)
    Given user success login in https://www.saucedemo.com/
    When user click Name (A to Z) in top right of page
    And user choose price (high to low)
    Then will display list product in home page will sorting based on price high to low