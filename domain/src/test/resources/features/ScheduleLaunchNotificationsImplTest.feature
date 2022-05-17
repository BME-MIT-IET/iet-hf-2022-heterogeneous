Feature: ScheduleLaunchNotificationsImplTest
  Schedules notification

  Scenario: when launch is in near future then should not be enqueued
    Given launch date
    When luanch is in 22 hours
    Then the launch is enqueued