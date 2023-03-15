
Feature: Edit car info icons from the Vehicle page.

  Background: User is already in the log in page
    Given the user is on the login page


  Scenario Outline: US7AC1TC1 Verify users see the car edited options on the Vehicle page
    Given the user logged in as "<user>"
    And   Click the "Vehicles" under the "Fleet"
    Then once the users launch on the Vehicle page, all the checkboxes should be unchecked

    Examples:
      | user          |
      | sales manager |
      | store manager |

  Scenario Outline: US7AC2TC1 Verify users see the car edited options on the Vehicle page
    Given the user logged in as "<user>"
    And   Click the "Vehicles" under the "Fleet"
    Then user checks the first checkbox to check all the cars

    Examples:
      | user          |
      | sales manager |
      | store manager |

  Scenario Outline: US7AC3TC1 Verify users see the car edited options on the Vehicle page
    Given the user logged in as "<user>"
    And   Click the "Vehicles" under the "Fleet"
    Then users can select any car

    Examples:
      | user          |
      | sales manager |
      | store manager |