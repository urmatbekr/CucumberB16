@regression
Feature: Testing Login Functionality

  @smoke
  Scenario: HappyPath (positive) login
    When User provides login 'guest1@microworks.com' and password 'Guest1!' and click sign in button
    Then Validate title of website 'ORDER DETAILS - Weborder'

  Scenario: Negative - no login
    When User provides login 'main@gmail.com' and password 'Guest1!' and click sign in button
    Then User validate error message 'Sign in Failed'
  @smoke
  Scenario: Negative - no password
    When User provides login 'guest1@microworks.com' and password 'asdasd' and click sign in button
    Then User validate error message 'Sign in Failed'

  Scenario: Negative - incorrect login and password
    When User provides login '' and password '' and click sign in button
    Then User validate error message 'Sign in Failed'

