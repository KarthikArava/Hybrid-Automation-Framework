@UI @Register
Feature: User Registration

  Scenario: Register a new user successfully

    Given user is on the home page
    When user clicks on signup login
    Then user should navigate to login page
    And user see signup "New User Signup!"

    When user enters name and email
    And user clicks signup button
    Then user should navigate to signup page

    When user enters account information
      | title    | Mr.       |
      | password | karthik   |
      | day      | 18        |
      | month    | February  |
      | year     | 2005      |
    And user scrolls the page
    And user enters address information
      | first name    | Karthik         |
      | last name     | Arava           |
      | address       | Bhimavaram      |
      | state         | Andhra Pradesh  |
      | city          | Bhimavaram      |
      | zipcode       | 534204          |
      | mobile number | 7731802005      |
    And user clicks create account button
    Then user should see "ACCOUNT CREATED!"

    When user clicks continue button
    Then user should see registered username on home page
    And user click delete account

    When user see delete account message "ACCOUNT DELETED!"
    Then click continue