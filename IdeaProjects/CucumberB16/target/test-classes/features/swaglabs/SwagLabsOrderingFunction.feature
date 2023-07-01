@regression
Feature: Testing Ordering Function

  @outlineregression
  Scenario Outline: Creating Order with Outline
    Given User provides login and password and click login button
    When User choose '<item>' and add into Cart
    And User click Cart button and go to checkout
    And User provides '<firstname>', '<lastname>', '<postalCode>' and click continue button
    Then User validates the name of '<item>', '<price>', tax amount and total amount
    Then User clicks Finish Button, and validates message Thank you for your order message
    Examples:
      | item                              | firstname | lastname | postalCode | price |
      | Sauce Labs Backpack               | John      | Rock     | 123100     | 29.99 |
      | Sauce Labs Bike Light             | John      | Rock     | 123100     | 9.99  |
      | Sauce Labs Bolt T-Shirt           | John      | Rock     | 123100     | 15.99 |
      | Sauce Labs Fleece Jacket          | John      | Rock     | 123100     | 49.99 |
      | Sauce Labs Onesie                 | John      | Rock     | 123100     | 7.99  |
      | Test.allTheThings() T-Shirt (Red) | John      | Rock     | 123100     | 15.99 |


  @tableregression
  Scenario: Creating Order with Table
    Given User provides login and password and click login button
    When User choose item and add into Cart
      | item | Sauce Labs Backpack |
    And User click Cart button and go to checkout
    And User provides firstname, lastname, postalCode and click continue button
      | firstname  | John  |
      | lastname   | Rock  |
      | postalCode | 12001 |
    Then User validates the name of item, price, tax amount and total amount
      | item  | Sauce Labs Backpack |
      | price | 29.99               |
    Then User clicks Finish Button, and validates message Thank you for your order message
