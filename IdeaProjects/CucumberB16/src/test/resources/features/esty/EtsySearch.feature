@regression
Feature: Testing the Search Functionality of the Etsy Website

  Scenario: Search Functionality Happy Path for Esty Hat
    When User searches for 'Hat' for Esty
    Then User validates the 'Hat - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Esty Key
    When User searches for 'Key' for Esty
    Then User validates the 'Key - Etsy' from Etsy

  Scenario: Search Functionality Happy Path for Esty Pin
    When User searches for 'Pin' for Esty
    Then User validates the 'Pin - Etsy' from Etsy

