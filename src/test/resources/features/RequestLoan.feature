Feature: Request Loan

  @request_loan
  Scenario: Request Loan
    Given I am on the request loan page
    When I request for loan with loan amount as "1000" and down payment as "10" and base account "12345"
    Then Requested loan is processed and new account number is created
    And new account number is displayed in the account overview page



