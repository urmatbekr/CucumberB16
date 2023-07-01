@regression @uiregression
Feature: Testing the Google Search Functionality Parameters
#general description

  Background: navigate to the website same step
    Given User navigates to the 'https://www.google.com/'

  Scenario: HappyPath (positive) Testing for Search Parameters
  #test case
#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'CodeFish'
    Then User validates first page returns more than 10 links

  Scenario: HappyPath(positive) Testing Result for Search Parameters

#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Kyrgyz Food in USA'
    Then User validates the result is then 300000000

  @smoke
  Scenario: HappyPath Testing Result for Search Parameters

#    Given User navigates to the 'https://www.google.com/'
    When User searches for 'Turkish baklava'
    Then User validates it loads less than 1 sec





