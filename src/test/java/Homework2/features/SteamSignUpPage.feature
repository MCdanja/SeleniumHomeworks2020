@SteamSignUpPage @SmokeTest
Feature: Steam Sign Up page

  Scenario: Check that main logo redirect to the Home page
    Given I navigate to the "Steam Sign up" page
    And The "Steam Sign up" page is opened
    When I click main logo on the Sign up page
    Then The "Steam Home" page is opened

  Scenario: Check that user can't register without check captcha
    Given I navigate to the "Steam Sign up" page
    When I fill "Random" email
    And I agree with terms
    And I click register button
    Then Error message shown