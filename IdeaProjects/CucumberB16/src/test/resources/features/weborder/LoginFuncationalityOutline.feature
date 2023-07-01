Feature: Testing Login Functionality negative scenario

  Scenario Outline: Negative scenario login function
    When User provides login '<email>' and password '<password>' and click sign in button
    Then User validate error message '<message>'
    Examples:
      | email          | password | message        |
      | main@gmail.com | Guest1!  | Sign in Failed |
      |                | Guest1!  | Sign in Failed |
      | main@gmail.com |          | Sign in Failed |
      |                |          | Sign in Failed |

