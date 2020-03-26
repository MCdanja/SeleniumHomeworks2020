@SteamHomePage @SmokeTest
Feature: Steam Home page

  Scenario Outline: Check that user can search game
    Given I navigate to the "Steam Home" page
    And The "Steam Home" page is opened
    When I type "<Game>" text in the search field
    And I click "Search" button
    Then The "Steam Search" page is opened
    And The first game is "<Game>" in results
    Examples:
      | Game               |
      | Grand Theft Auto V |

  Scenario: Check that user can go to Sign Up page
    Given I navigate to the "Steam Home" page
    And The "Steam Home" page is opened
    When I click "Sign up" button
    Then The "Steam Sign up" page is opened
