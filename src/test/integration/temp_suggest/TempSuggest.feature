Feature: Test the suggestion of the temperature
  The suggestion should match what is in the preference.

  Scenario Outline: Is the suggestion for the user correct for the temperature?
    Given The user is logged in under <username>
    And  the temperature from the sensor is <temp>
    Then the suggestion for the user should be <suggest>
    Examples:
      | username | temp        | suggest |
      | "Jack"   | 19          | null    |
      | "Jack"   | 20          | "shops" |
      | "Jack"   | 21          | "shops" |
      | "Jack"   | 30          | "pool"  |
      | "Jack"   | 31          | "pool"  |
      | "David"  | 10          | null    |
      | "David"  | 16          | "pool"  |
      | "David"  | 20          | "pool"  |
      | "David"  | 2147483647  | "pool"  |
      | "David"  | -2147483647 | null    |
      | "David"  | -20         | null    |

