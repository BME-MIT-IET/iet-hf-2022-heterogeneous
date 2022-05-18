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

  Scenario: Instant plus 30 second
    Given an instant
    When giving it plusz 30 sec
    Then it has to be 30L

  Scenario: A period between 2 days
    Given one day what is 2017 "NOVEMBER" 16
    When the other day is 2017 "DECEMBER" 24
    Then the period has 1 months
    And 8 days


