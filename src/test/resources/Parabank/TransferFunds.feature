Feature: Transer funds

  Scenario: I am able to transfer funds from one account to another account
    Given I am on the tranfer funds page
    When I enter amount as "100"
    And I select to account as "12345"
    And I select from account as "12456"
    And I click on transfer funds button
    Then I am navigated transfer fund success page
    And 100 is deducted from "1234566" and creditd to the to 12456

  Scenario: I am not able to tranfer if from account has low balance

  Scenario: Enter special chars in the amount shuld not be allowd


