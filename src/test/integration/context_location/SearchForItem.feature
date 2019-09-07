Feature: Search for item of interest
  User is logged in and his/her setting is detected correctly

  Scenario Outline: Search for item in current location
    Given user is logged in under the name of <user>
    When the user search for item at duration of <duration>
    Then should return the following location <locations>

    Examples:
      | user    | locations                    | duration |
      | "Jack"  | "Vivo City Shopping Centre"  | 0        |
      | "David" | "Vivo City Shopping Centre"  | 1        |
      | "David" | "Dam Sen Parklands"          | 14       |
      | "David" | "Dam Sen Parklands"          | 15       |
      | "David" | "Dam Sen Parklands"          | 16       |
      | "David" | "Ho Chi Minh City, Downtown" | 29       |
      | "David" | "Ho Chi Minh City, Downtown" | 30       |
      | "David" | "Vivo City Shopping Centre"  | 31       |
      | "David" | "Vivo City Shopping Centre"  | 31       |