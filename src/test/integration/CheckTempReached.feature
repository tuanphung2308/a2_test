Feature: Check Temperature Reached
  Check Temperature reach threshold

  Scenario Outline: Temperature reach threshold?
    Given The username is <user>
    When all sensor is initialized done
    Then The current temperature is <temperature> reach threshold

    Examples:
      | user   | temperature |
      | "Jack" | 10  |
      | "Jack" | 15  |
      | "Jack" | 20  |
      | "David" | 10 |
      | "David" | 15 |
      | "David" | 20 |