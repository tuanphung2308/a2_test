Feature: Search for location info
  User is logged in and his/her setting is detected correctly

  Scenario Outline: Search for info about a location
    Given user is logged in under the name of <user>
    When the user search for info about <location>
    Then should return info about the location <location_info>

    Examples:
      | user    | location                       | location_info                                                                                                                                                                                                                                                                                                  |
      | "Jack"  | "Vivo City Shopping Centre"    | "Vivo City Shopping Centre is a major regional shopping centre in the southern suburb of Ho Chi Minh City, Vietnam. It is the second largest shopping centre in the southern suburbs of Ho Chi Minh City, by gross area, and contains the only H&M store in that region."                                      |
      | "David" | "Crescent Mall"                | "Crescent Mall Shopping Centre is located 10km South of the Ho Chi Minh City central business district(CBD) and includes Banana Republic, Baskin Robins, CGV Cinema, Bobapop and over 130 specialty stores."                                                                                                   |
      | "David" | "Dam Sen Parklands"            | "The Dam Sen Parklands area was created as part of the rejuvenation of the industrial upgrade undertaken for World Expo 1988. The Parklands area is spacious with plenty of green and spaces for all ages. A big lake promenade stretches the area of Dam Sen Parklands."                                      |
      | "David" | "Ho Chi Minh City, Downtown"   | "The Ho Chi Minh City central business district (CBD), or 'the City' is located on a central point in district One. The point, known at its tip as Central Point, slopes upward to the north-west where 'the city' is bounded by parkland and the inner city suburb of District 3, District 4 and District 5." |
      | "David" | ""                             | "Not Found"                                                                                                                                                                                                                                                                                                    |
      | "David" | " "                            | "Not Found"                                                                                                                                                                                                                                                                                                    |
      | "David" | "dasjldjlkasjkldasjkldklaskla" | "Not Found"                                                                                                                                                                                                                                                                                                    |
