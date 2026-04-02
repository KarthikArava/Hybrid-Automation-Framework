@UI @Cart
Feature: Cart Functionality

  Background:

    Given user is on the home page
    When user clicks on signup login
    Then user should navigate to login page
    And user enters valid credentials
    And user clicks login button


  @AddToCart
  Scenario: Add product to cart and validate

    When user navigates to products page
    And user adds the first product to the cart
    And user clicks view cart
    Then product should be visible in the cart

  @RemoveFromCart
  Scenario: Remove product from cart and validate

    When user navigates to products page
    And user adds the first product to the cart
    And user clicks view cart
    Then product should be visible in the cart

    When user removes the product from cart
    Then cart should display "Cart is empty!"