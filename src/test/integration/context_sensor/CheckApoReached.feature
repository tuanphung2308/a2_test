Feature: Check API Reached
  Check API reach threshold

  Scenario Outline: API reach threshold?
    Given The username : <user> with medical condition <medical>
    When When user is outdoor for <duration>
    Then The current api is <api> reach threshold should be reached <reached>

    Examples:
      | user    | medical | api | duration | reached |
      | "Jack"  | 2       | 50  | 10       | 0       |
      | "Jack"  | 2       | 50  | 60       | 1       |
      | "Jack"  | 2       | 60  | 25       | 0       |
      | "Jack"  | 2       | 60  | 30       | 1       |
      | "Jack"  | 2       | 120 | 10       | 0       |
      | "Jack"  | 2       | 120 | 20       | 1       |
      | "Jack"  | 2       | 200 | 5        | 0       |
      | "Jack"  | 2       | 200 | 10       | 1       |
      | "David" | 3       | 50  | 10       | 0       |
      | "David" | 3       | 50  | 90       | 1       |
      | "David" | 3       | 60  | 25       | 0       |
      | "David" | 3       | 60  | 45       | 1       |
      | "David" | 3       | 120 | 10       | 0       |
      | "David" | 3       | 120 | 30       | 1       |
      | "David" | 3       | 200 | 5        | 0       |
      | "David" | 3       | 200 | 15       | 1       |