Feature: Login into the system
  User is logged in and his/her setting is detected correctly

  Scenario Outline: User not exists
    Given username is <user>
    When the Context Manager passes the username to the Preference Repo
    Then the program should return a error not found

    Examples:
      | user                                   |
      | ""                                     |
      | "qweopqwope"                           |
      | " 12312321"                            |
      | "☾ ✙ ✚ ✛ ✜ ✝ ✞ ✟ † ⊹ ‡ ♁ ♆ ❖ ♅ ✠ ✡ ✢ " |