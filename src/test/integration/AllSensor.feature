Feature: All Sensor
  Getting data from other sensor

  Scenario Outline: Could sensor get data?
    Given the user is <user>
    When all sensor is initialized
    Then the value should be obtained correctly like location is <location> and temperature is <temp> and aqi is <aqi>
    Examples:
      | user   | location | temperature | aqi
      | "Jack" | "A"      | 10          | 200

