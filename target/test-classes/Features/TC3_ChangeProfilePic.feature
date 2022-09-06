Feature: Profile picture Module API automation

  Scenario Outline: Verify add new profile picture to the application through API
    Given User add headers and bearer authorization for accessing upload profile picture endpoints
    When User add form data for adding profile picture
    And User send "POST" request for changeProfilePic endpoint
    Then User verify the status code is 200
    And User verify the changeProfilePic response message matches "Profile updated Successfully"