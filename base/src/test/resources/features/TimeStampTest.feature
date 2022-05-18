Feature: Date Test
  What time is it?

  Scenario: toTimeStamp
    Given today is June 4
    When I try to make it a time stamp
    Then It should be 1275677100000L

  Scenario: toTimeStamp_nonSenseValue_wontCrash
    Given bad value
    When I try to make it a time stamp
    Then It should be 0L