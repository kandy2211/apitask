@login
Feature: Login module API automation

  Scenario: Get User logtoken from login endpoint
    Given User add header
    And User add basic authentication for login
    When User send "POST" request for login endpoint
    Then User verify the status code is 200
    And User verify the login response body first_name present as "Kandasamy" and get the logtoken saved
