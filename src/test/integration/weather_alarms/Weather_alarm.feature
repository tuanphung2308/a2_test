Feature: list of indoor and outdoor
  reading the weather conditions

  Scenario Outline: Could location server be mapping?
    Given Indoor is <Indoor>
    And  Outdoor is <Outdoor>
    Then the value should be obtained correctly like indoor is <Indoor> and outdoor is <Outdoor>
    Examples:
      | Indoor  | Outdoor |
      | "A"  | "C" |
      | "B"  | "D" |


