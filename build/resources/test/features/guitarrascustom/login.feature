Feature: Perform authentication on website
  Me as a user of the Guitar Custom store
  I want to authenticate myself in the virtual store
  To buy products from the online store

  Background:
    Given I enter the login page of the Guitar Custom page

  Scenario: Login to the platform with valid data
    When I authenticate with the email and password
    Then the main page will be displayed

  Scenario: Login to the platform with invalid data
    When I authenticate with wrong email and password
    Then the error message will be displayed