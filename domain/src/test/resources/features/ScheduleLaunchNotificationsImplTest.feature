Feature: ScheduleLaunchNotificationsImplTest
  Schedules notification

  Scenario: when launch is in near future then should not be enqueued
    Given launch date
    When launch is in 22 hours
    Then the launch is enqueued