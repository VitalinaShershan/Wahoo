#Author: antonishchenko.qa@gmail.com
Feature: Checkout added products to the cart

  Background:
    When user navigate to website and click on shop btn then all products should be displayed
    And user adding two random products to the cart and remove the last one
    Then confirm with the following pop-up that the item was removed
    When user click btn on view and edit cart at the side-bar
    And cart page should be displayed user change the item quantity and click on update btn
    And click the blue proceed to checkout button
    Then verify that checkout page is displayed

  @regression
  Scenario: Filling up checkout information form
    When user click the blue place order button without filling in any info
    Then verify error messages is displayed
    And user enter all shipping info
    And choose express shipping method and fill credit card info and click on place order btn
    Then verify red alert sign wrong credit card info is displayed