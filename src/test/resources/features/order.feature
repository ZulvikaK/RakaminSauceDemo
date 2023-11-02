Feature: place an order

  Scenario Outline: Success place an order
    Given user in home page
    When user enters login credentials "<username>" and "<password>"
    And user click on "login" button
    Then user verifies the "product" page
    And user select a product "<productName>"
    And user verifies the product title on "product details" page
    And user click on "add to cart" button
    And user click on "go to cart" button
    And user verifies the "cart" page
    And user verifies the product title on "cart" page
    And user click on "checkout" button
    And user verifies the "checkout information" page
    And user enters checkout information "<firstname>" "<lastname>" and "<zipcode>"
    And user click on "continue" button
    And user verifies the "checkout overview" page
    And user verifies the product title on "checkout overview" page
    And user click on "finish" button
    And user verifies the "checkout complete" page
    And user verifies the success message on checkout complete page

    Examples:
    |username|password|productName|firstname|lastname|zipcode|
    |standard_user|secret_sauce|Sauce Labs Fleece Jacket|umar|sadam|12345|


