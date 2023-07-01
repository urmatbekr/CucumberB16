@regression
Feature: Testing Order Functionality

  Background:  Food order same steps
    When User provides login 'guest1@microworks.com' and password 'Guest1!' and click sign in button
    Then User click group order label and click Next
    And User texts in note invitees 'I LOVE SELENIUM' and provides InviteList 'email@gmail.com' and 'email2@gmail.com'

  Scenario: Creating Order Group
#    When User provides login 'guest1@microworks.com' and password 'Guest1!' and click sign in button
#    Then User click group order label and click Next
#    And User texts in note invitees 'I LOVE SELENIUM' and provides InviteList 'email@gmail.com' and 'email2@gmail.com'
    And User chooses the delivery option 'My House' and validate address '3137 Laguna' and click button group order
    Then User validates the header 'View Group Order' and the description which starts 'Your group order is now pending'

  Scenario: Testing Order Address for Office Food Order
#    When User provides login 'guest1@microworks.com' and password 'Guest1!' and click sign in button
#    Then User click group order label and click Next
#    And User texts in note invitees 'I LOVE Cucumber' and provides InviteList 'ahmet@gmail.com' and 'asd123@gmail.com'
    And User chooses the delivery option 'Office' and validate address 'EMPIRE BLVD' and click button group order
    Then User validates the header 'View Group Order' and the description which starts 'Your group order is now pending'
