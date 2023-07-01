@outlineregression
Feature: Testing Search Functionality of Etsy Website

  Scenario Outline: Testing different product for Search Functionality
    When User searches for '<itemName>' for Esty
    Then User validates the '<title>' from Etsy
    Examples:
      | itemName | title      |
      | Hat      | Hat - Etsy |
      | Key      | Key - Etsy |
      | Pin      | Pin - Etsy |

