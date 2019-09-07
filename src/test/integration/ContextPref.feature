Feature: Login into the system
  User is logged in and his/her setting is detected correctly

  Scenario Outline: User exists
    Given username is <user>
    When the Context Manager passes the username to the Preference Repo
    Then the config should load the config of the user
    And medical condition is <cond>
    And personal preference is <pref>
    Examples:
      | user    | cond | pref                                                                                            |
      | "Jack"  | 2    | when 20 suggest shops,when 30 suggest pool,when APO suggest bowling,when weather suggest cinema |
      | "David" | 3    | when 16 suggest pool,when APO suggest cinema,when weather suggest shops                         |

