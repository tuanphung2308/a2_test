Feature: All Sensor
  Getting data from other sensor

  Scenario Outline: Error if the file is not found
    Given the user is <user>
    When user is at that location for <duration>
    Then the program should result in an error
    Examples:
      | user                    | location | temp | aqi_val | duration |
      | "Jacky"                 | "A"      | 10   | 200     | 0        |
      | "Alice"                 | "A"      | 10   | 200     | 1        |
      | ""                      | "C"      | 10   | 200     | 2        |
      | " "                     | "C"      | 10   | 200     | 3        |
      | "\n"                    | "C"      | 10   | 200     | 4        |
      | "\t"                    | "C"      | 10   | 200     | 5        |
      | "kjasjklsajldklasdklas" | "C"      | 15   | 200     | 6        |

