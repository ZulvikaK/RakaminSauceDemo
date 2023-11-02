Feature: Product detail

  Scenario: Product details are displayed
    Given user success login in https://www.saucedemo.com/
    When user click Name Product in first list product
    Then user should see product detail page