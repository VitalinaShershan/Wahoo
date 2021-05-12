#Author: antonishchenko.qa@gmail.com
Feature: Add products to the cart and proceed to the card page for adjustments

  Background:
    When user navigate to website and click on shop btn then all products should be displayed
    And user adding two random products to the cart and remove the last one
    Then confirm with the following pop-up that the item was removed

  @adjustCart
  Scenario: User proceed to the cart page to do adjustment
    When user click btn on view and edit cart at the side-bar
    And cart page should be displayed user change the item quantity and click on update btn
    And click the blue proceed to checkout button
    Then verify that checkout page is displayed