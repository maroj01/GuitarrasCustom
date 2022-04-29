Feature: Buy products through the website

  Me as a user of Custom Guitarras
  I want to make the purchase
  To purchase products from the store

  Background:
    Given I am connected to the store's website

  Scenario: Purchase without attaching proof of payment
    When I make the purchase process without proof of payment
    Then an error message will be displayed


    Scenario: Buy by entering the payment receipt number
    When I make the purchase process with receipt number
    Then a message with order number will be displayed