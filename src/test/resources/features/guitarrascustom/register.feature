Feature: Create an account on the website
  Me as a new user of Custom Guitars
  I want to register on the website
  To make purchases in the online store


  Scenario: Successful registration on the website
    Given you entered the Guitar Custom website
    When I register with the requested data
    Then I can login to the account


  Scenario: Registration to the platform with email already registered
    Given I already had a record with the mail
    When I try to register with the same email
    Then it will not allow to create the account