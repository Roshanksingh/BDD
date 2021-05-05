@storeAdmin
Feature: Store Admin

  # testcase_id = fm-1234
  Scenario: checking Menu page
    Given user is present on "store Admin" site
    When user logged in with valid credentials
    Then  User will see menu page

  Scenario: verify fm admin login
    Given User go to "fm admin" site

  Scenario: verify customer page
    Given User go to "customer" site