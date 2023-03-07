Feature: Users should view columns on the Vehicle models page

  Background: User is already in the log in page
    Given the user is on the login page

  @kutay
  Scenario: US05 AC01 TC01 Verify that store manager and sales manager should see 10 columns on the Vehicle Model page
  Expected Column names: MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED),
  TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

    Given the user logged in as "<user>"
    Then the user clicks the Vehicle Model under the Fleet
    Then the user verifies managers see below columns in the web-table
      | MODEL NAME               |
      | MAKE                     |
      | CAN BE REQUESTED         |
      | CVVI                     |
      | CO2 FEE (/MONTH)         |
      | COST (DEPRECIATED)       |
      | TOTAL COST (DEPRECIATED) |
      | CO2 EMISSIONS            |
      | FUEL TYPE                |
      | VENDORS                  |


    Examples:
      | user          |
      | sales manager |
      #| store manager |

  @kutay
  Scenario: US05 AC02 TC02 Verify that drivers should not able to access the Vehicle Model page,
  users should see “You do not have permission to perform this action.”
    Given the user logged in as "driver"
    Then the user clicks the Vehicle Model under the Fleet
    Then the user verify that the drivers see the error message "You do not have permission to perform this action."