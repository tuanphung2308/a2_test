Feature: Calculate APO threshold
  Calculate APO threshold based on user medical condition and current api

  Scenario Outline: Correct APO threshold?
    Given username : <user> has medical condition <medical>
    When The current api read is <api>
    Then The APO threshold is <threshold>
    Examples:
      | user    | medical | api | threshold |
      | "Jack"  | 1       | 50  | 30        |
      | "Jack"  | 2       | 50  | 60        |
      | "Jack"  | 3       | 50  | 90        |
      | "Jack"  | 1       | 60  | 15        |
      | "Jack"  | 2       | 60  | 30        |
      | "Jack"  | 3       | 60  | 45        |
      | "Jack"  | 1       | 120 | 10        |
      | "Jack"  | 2       | 120 | 20        |
      | "Jack"  | 3       | 120 | 30        |
      | "Jack"  | 1       | 200 | 5         |
      | "Jack"  | 2       | 200 | 10        |
      | "Jack"  | 3       | 200 | 15        |
