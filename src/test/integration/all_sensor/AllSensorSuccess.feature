Feature: All Sensor
  Getting data from other sensor

  Scenario Outline: Could sensor get data?
    Given the user is <user>
    When user is at that location for <duration>
    Then the value should be obtained correctly like username is <user>
    And location is <location>
    And temperature is <temp>
    And air quality is <aqi_val>
    Examples:
      | user    | location | temp | aqi_val | duration |
      | "Jack"  | "A"      | 10   | 200     | 0        |
      | "Jack"  | "A"      | 10   | 200     | 1        |
      | "Jack"  | "C"      | 10   | 200     | 2        |
      | "Jack"  | "C"      | 10   | 200     | 3        |
      | "Jack"  | "C"      | 10   | 200     | 4        |
      | "Jack"  | "C"      | 10   | 200     | 5        |
      | "Jack"  | "C"      | 15   | 200     | 6        |
      | "Jack"  | "C"      | 15   | 200     | 7        |
      | "Jack"  | "C"      | 15   | 200     | 8        |
      | "Jack"  | "C"      | 20   | 200     | 9        |
      | "Jack"  | "C"      | 20   | 200     | 10       |
      | "Jack"  | "C"      | 20   | 200     | 11       |
      | "Jack"  | "C"      | 20   | 200     | 12       |
      | "Jack"  | "C"      | 10   | 200     | 13       |
      | "Jack"  | "C"      | 10   | 200     | 14       |
      | "Jack"  | "C"      | 10   | 200     | 15       |
      | "Jack"  | "C"      | 10   | 90      | 16       |
      | "Jack"  | "D"      | 10   | 90      | 17       |
      | "Jack"  | "D"      | 15   | 90      | 18       |
      | "Jack"  | "D"      | 15   | 90      | 19       |
      | "Jack"  | "D"      | 15   | 90      | 20       |
      | "Jack"  | "D"      | 20   | 90      | 21       |
      | "Jack"  | "D"      | 20   | 90      | 22       |
      | "Jack"  | "D"      | 20   | 90      | 23       |
      | "Jack"  | "D"      | 20   | 90      | 24       |
      | "Jack"  | "D"      | 10   | 90      | 25       |
      | "Jack"  | "D"      | 10   | 90      | 26       |
      | "Jack"  | "D"      | 10   | 200     | 27       |


      | "David" | "A"      | 10   | 200     | 1        |
      | "David" | "D"      | 25   | 200     | 30       |
      | "David" | "A"      | 25   | 200     | 31       |
      | "David" | "A"      | 25   | 200     | 31       |

