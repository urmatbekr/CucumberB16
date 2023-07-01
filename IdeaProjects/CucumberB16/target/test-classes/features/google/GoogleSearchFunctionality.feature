@regression @apiregression
Feature: Testing the Google Search Functionality
#general description
  Scenario: HappyPath (positive) Testing for Search
  #test case
    Given User navigates to the Google
    When User searches for CodeFish
    Then User validates first page returns more than ten links

@smoke
  Scenario: HappyPath(positive) Testing Result for Search
    Given User navigates to the Google
    When User searches for Kyrgyz Food in USA
    Then User validates the result is then three hundred million

  Scenario: HappyPath Testing Result for Search
    Given User navigates to the Google
    When User searches for Turkish baklava
    Then User validates it loads less than one sec



