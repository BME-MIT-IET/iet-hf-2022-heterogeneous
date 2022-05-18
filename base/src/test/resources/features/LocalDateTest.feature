Feature: Local date Test
  What local time is it?

  Scenario: Compare
    Given Today's date
    When I get tomorrow's date
    Then It should be after today

