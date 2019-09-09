Feature: Check if the context manager could interact with the clock
  The clock's behaviour should be correct

  Scenario Outline: Could the clock reset once the reset function is called?
    Given User is logged in as <user>
    And  the current clock value is <clock>
    Then the value of the clock after reset should be 0
    Examples:
      | user    | clock |
      | "Jack"  | 5     |
      | "David" | 7     |

  Scenario Outline: Could the clock tick once the reset function is called?
    Given User is logged in as <user>
    When  the tick function is called <times>
    Then the value of the clock after ticking should be <times>
    Examples:
      | user    | times |
      | "Jack"  | 5     |
      | "David" | 7     |
