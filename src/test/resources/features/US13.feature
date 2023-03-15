Feature: Manage filters on the Vehicle Costs page

  Background: User is on the login page
    Given the user is on the "login" page

  Scenario Outline: US13AC1TC1 Verify user <user> can see 3 columns on the Vehicle Model page
  Expected Column names: TYPE, TOTAL PRICE, DATE
    Given the user enters username "<username>" and password "<password>"
    And the user click on "FleetModule" in "VehicleCostPage"
    And the user click on "Vehicle CostsModule" in "VehicleCostPage"
    Then the user should see webelement "TYPE" on the "VehicleCostPage"
    Then the user should see following titles in the table
      | TYPE        |
      | TOTAL PRICE |
      | DATE        |

    Examples:
      | user          | username        | password    |
      | sales manager | salesmanager101 | UserUser123 |
      | store manager | storemanager85  | UserUser123 |

  Scenario Outline: US13AC2TC1 Verify user can check the first checkbox to check all the Vehicle Costs

    Given the user logged in as "<user>"
    And the user click on the Vehicle Costs under the Fleet
    And the user click the first checkbox
    Then the user should see all the vehicle costs are checked

    Examples:
      | user          |
      | sales manager |
      | store manager |


