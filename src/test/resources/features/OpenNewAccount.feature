Feature: Open New Account

  @new_account
  Scenario: User is able to Open new Account
    Given I am on the Open New Account Page
    When I select account type as "CHECKING" and select base account number as "12456"
    Then New account is created is displayed and new account number is generated
    And New account number is displayed in the account overview page


