Feature: Check API Reached
  Check API reach threshold

  Scenario Outline: API reach threshold?
    Given The username is <user>
    When all sensor is initialized done
    Then The current temperature is <temperature> reach threshold should be <reached>

    Examples:
      | user   | temperature | reached |
      | "Jack" | 10  | 0 |
      | "Jack" | 15  | 0 |
      | "Jack" | 20  | 1 |
      | "David" | 10 | 0 |
      | "David" | 15 | 0 |
      | "David" | 20 | 1 |