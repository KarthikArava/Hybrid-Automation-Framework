@UI @Login
Feature: Login Functionality

  Background:

    Given user is on the home page
    When user clicks on signup login
    Then user should navigate to login page
    And user see login "Login to your account"


  @ValidLogin
  Scenario: Login with valid credentials

    When user enters valid credentials
    And user clicks login button
    Then user should see valid username on home page


  @InvalidLogin
  Scenario: Login with invalid credentials

    When user enters invalid credentials
    And user clicks login button
    Then user should see error message "Your email or password is incorrect!"
