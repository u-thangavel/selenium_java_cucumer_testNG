Feature: Google Homepage

  Scenario: Launch the app and verify title
    Given I launch the browser
    When I navigate to "https://www.google.com"
    Then get the page title
