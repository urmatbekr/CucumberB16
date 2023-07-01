@regression
Feature: Testing Order Creation Functionality
  Scenario: Creating order
    When User enters username and password and click login Button
    And User navigates to Order section from Bar
    And User chooses the 'MyMoney' and fills the '3'
    And User fills 'Joh', 'Main', 'NY', 'NY' and '10010'
    And User chooses the 'Visa' and fills '4200123120321', '12/25' and click Process Button
    Then User validates the given 'New order has been successfully added.'
    Then User validates the order info from View All Orders


