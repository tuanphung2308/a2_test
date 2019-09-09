Feature: Test the suggestion of the weather
  The suggestion should match what is in the preference.

  Scenario Outline: Is the suggestion for the user correct for the weather?
    Given The user is logged in under <username>
    And  the weather from the sensor is <weather>
    Then the suggestion for the user should be <suggest>
    Examples:
      | username | weather     | suggest  |
      | "Jack"   | 0           | null     |
      | "Jack"   | 1           | "cinema" |
      | "Jack"   | 2           | "cinema" |
      | "Jack"   | 3           | "cinema" |
      | "Jack"   | -30         | null     |
      | "Jack"   | 4           | null     |
      | "Jack"   | 2147483647  | null     |
      | "Jack"   | -2147483647 | null     |
      | "David"  | 1           | "shops"  |
      | "David"  | 2           | "shops"   |
      | "David"  | 3           | "shops"   |

