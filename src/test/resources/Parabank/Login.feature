Feature: Login Feature

#  1. Analysis
#  2. Divide the app into logical boundaries==> modules ==>features
#  a. Login
#  - TC 1
#  - Positive Scn
#  - Negative Scn
#  - TC 2
#  b. Register
#  c. Open New Account
#  d.  Request Loan

  @login @positive
  Scenario: User is able to login using correct username and password
    Given user is on the login page
    When user enters username as "john" and password as "demo"
    Then user is able login in the the app
    And user is able to see the accounts overview page
    And User is able to see side-menu in left hand side

  @login @negative
  Scenario: User is not able to login using incorect username and password
    Given user is on the login page
    When user enters username as "sdfds" and password as "sdfs"
    Then user is not able login in the the app
    And app is displaying the error message "invalid crdentials"

  Scenario: User is not able to login using incorect username and password
    Given user is on the login page
    When user enters username as "#$%%^^%$" and password as "#%^$^%"
    Then user is not able login in the the app
    And app is displaying the error message "invalid crdentials"

  Scenario: User is not able to login when user name and password field is blank

  Scenario: Username and password field size

  Scenario: Session length

  Scenario: user should not be allowed more than three times






