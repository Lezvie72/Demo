# language: en
@mainPage

Feature: Check Main Page

  @test @id-1
  @Severity(Critical)
  Scenario: Check Search Google
    Given user is on the main page
    And all elements of page is displayed
    When user input "Selenium" to search field
    Then results page is displayed