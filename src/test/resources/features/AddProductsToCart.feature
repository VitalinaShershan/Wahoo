#Author: antonishchenko.qa@gmail.com
Feature: Adding products to the card

  @addProducts
  Scenario: User add two random products to the cart and remove one of them
    When user navigate to website and click on shop btn then all products should be displayed
    And user adding two random products to the cart and remove the last one
    Then confirm with the following pop-up that the item was removed
