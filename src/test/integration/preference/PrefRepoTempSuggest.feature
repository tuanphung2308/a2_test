Feature: Preference Temperature suggest
  Temperature suggestion based on user preference

  Scenario Outline: Correct Temperature suggestion?
    Given username: <user>
    Then The current temperature <temperature> suggestion is <suggest>
    Examples:
      | user    | temperature | suggest |
      | "Jack"  |      20     | "shops" |
      | "Jack"  |      30     | "pool"  |
      | "David" |      16     | "pool"  |