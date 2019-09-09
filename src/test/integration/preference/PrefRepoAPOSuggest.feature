Feature: Preference APO suggest
  APO suggestion based on user preference

  Scenario Outline: Correct APO suggestion?
    Given username is <user>
    Then The APO suggestion is <suggest>
    Examples:
      | user    | suggest   |
      | "Jack"  | "bowling" |
      | "David" | "cinema"  |
