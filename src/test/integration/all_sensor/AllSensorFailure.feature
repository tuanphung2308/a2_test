Feature: All Sensor
  Getting data from other sensor

  Scenario Outline: Error if the file is not found
    Given the user has one of the followings name <user>
    Then the program should result in an error
    Examples:
      | user     |
      | "Tom"    |
      | "James"  |
      | "Bond"   |
      | "Peter"  |
      | "Jin"    |
      | "Kim"    |
      | "Tuan"   |
      | "Alice"  |
      | ""       |
      | " "      |
      | "\n"     |
      | "++++++" |

