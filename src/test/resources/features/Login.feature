Feature: Login

  @login
  Scenario: Login Scenario
    Given I am on the landing page of the app
    When I enter username and password
    Then I am able to login in the app


