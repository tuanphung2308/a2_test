Feature: Search for item of interest
  User is logged in and his/her setting is detected correctly

  Scenario Outline: User not exists
    Given user is logged in under the name of <user>
    When the user search for item at duration of <duration>
    Then should return the following location <locations>

    Examples:
      | user   | locations                   | duration |
      | "Jack" | "Vivo City Shopping Centre" | 1        |