Feature: Local date Test
  What local time is it?

  Scenario: Compare
    Given Today's date
    When I get tomorrow's date
    Then It should be after today

  Scenario: Local date adjustment
    Given Date is 2017 "NOVEMBER" 16
    Then It is "THURSDAY"
    And Next monday is on 20 th

  Scenario: Local date midnight
    Given Date is 2017 "NOVEMBER" 16 time: 19 12
    Then It is before midnight

  Scenario: Days display
    Given The day is "FRIDAY"
    Then It should display "Friday"
    And "F"

  Scenario: Zone Data time from La to Tokyo
    Given Date time of "America/Los_Angeles" and "Asia/Tokyo"
    When we get the timezones
    Then Tokyo time is plus 10 hours and 50 minutes
