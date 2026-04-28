Feature: Hybrid Scenario

  @VEEVA-7
  Scenario: Creating user by API and validating by UI

    When the user account created through API request
    Then the response should validate

    Given the user is on homepage
    When navigated to login page
    And entered the user credentials that created by API request and click submit
    Then the user should login successfully and see the username on the homepage

    When the user clicks delete account on homepage
    Then validate the deletion message in UI "ACCOUNT DELETED!"

    When the user get the same account through API request
    Then the response should validate
    And should see the "Account not found" message