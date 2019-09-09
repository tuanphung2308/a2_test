Feature: Search For Location By Service
  Check if the list of locations is returned correctly

  Scenario Outline: Search for location by services
    Given the user is logged in
    When the user search for <service>
    Then should return the following location <locations>

    Examples:
      | service        | locations                                                                              |
      | "shops"        | "Vivo City Shopping Centre;Crescent Mall;Dam Sen Parklands;Ho Chi Minh City, Downtown" |
      | "SHOPS"        | "Vivo City Shopping Centre;Crescent Mall;Dam Sen Parklands;Ho Chi Minh City, Downtown" |
      | "bowling"      | "Vivo City Shopping Centre;Ho Chi Minh City, Downtown"                                 |
      | "market"       | "Ho Chi Minh City, Downtown"                                                           |
      | "cinema"       | "Vivo City Shopping Centre;Crescent Mall"                                              |
      | "Ferris wheel" | "Dam Sen Parklands"                                                                    |
      | ""             | ""                                                                                     |
      | " "            | ""                                                                                     |
      | "randomstring" | ""                                                                                     |
      | "123123213"    | ""                                                                                     |
