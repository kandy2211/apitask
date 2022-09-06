@address
Feature: Address Module API automation

  Scenario Outline: Verify add new address to the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for Add new address "<firstname>","<lastname>","<mobile>","<apartment>","<state>","<city>","<country>", "<zipcode>", "<address>" and "<address_type>"
    And User send "POST" request for addUserAddress endpoint
    Then User verify the status code is 200
    And User verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | firstname | lastname | mobile     | apartment | state | city | country | zipcode | address   | address_type |
      | kandasamy | K        | 9597905636 | ceebros   |    12 |   33 |     101 |  607022 | cuddalore | work         |

  Scenario Outline: Verify update user address in the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for updating existing address "<addressId>" , "<firstname>","<lastname>","<mobile>","<apartment>","<state>","<city>","<country>", "<zipcode>", "<address>" and "<address_type>"
    And User send "PUT" request for updateUserAddress endpoint
    Then User verify the status code is 200
    And User verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | firstname | lastname | mobile     | apartment | state | city | country | zipcode | address   | address_type |
      | kandasamy | K        | 9597905637 | ceebros   |    12 |   33 |     101 |  607022 | cuddalore | home         |

  Scenario Outline: Verify delete user address in the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    When User add request body for deleting address
    And User send "DELETE" request for deleteUserAddress endpoint
    Then User verify the status code is 200
    And User verify the deleteUserAddress response message matches "Address deleted successfully"

  Scenario Outline: Verify get user addresses from the application through API
    Given User add headers and bearer authorization for accessing address endpoints
    And User send "GET" request for getUserAddresses endpoint
    Then User verify the status code is 200
    And User verify the getUserAddresses response message matches "OK"
