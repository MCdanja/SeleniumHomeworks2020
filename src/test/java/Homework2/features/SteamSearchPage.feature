@SteamSearchPage @SmokeTest
Feature: Steam Search page

  Scenario: Check that main logo redirect to the Home page
    Given I navigate to the "Steam Search" page
    And The "Steam Search" page is opened
    When I click main logo on the Search page
    Then The "Steam Home" page is opened

  Scenario Outline: Check that user can find games by OS
    Given I navigate to the "Steam Search" page
    When I click find by "<OS>" OS checkbox
    Then First "10" results support "<OS>" OS
    Examples:
      | OS      |
      | Mac     |
      | Windows |
      | Linux   |