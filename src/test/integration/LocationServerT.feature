Feature: list of indoor and outdoor
  mapping of the status to location coordinates

  Scenario Outline: Could location server be mapping?
    Given Indoor is <Indoor>
    And  Outdoor is <Outdoor>
    Then the value should be obtained correctly like indoor is <Indoor> and outdoor is <Outdoor>
    Examples:
      | Indoor  | Outdoor |
      | "A"  | "C" |
      | "B"  | "D" |


