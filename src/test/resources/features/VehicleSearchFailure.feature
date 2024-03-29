Feature: Testing to verify if failure message is appearing incase vehicle can't be searched successfully
  In order to validate that the Vehicle Search page is working
  Doing the Acceptance Testing

  @VehicleSearchFailure
  Scenario Outline: Validate Failure Vehicle Search Page on "<browser>"
Given Launch browser "<browser>"
    And user navigates to the URL
    And user enter value "<VehicleNumber>" in search field
    And I click on findVehicle button
    Then Verify error message is appearing on the homepage or not "<VehicleNumber>"

    Examples:
      |browser| VehicleNumber |
      |chrome| OV12UYY4  |
      |firefox| OV12UYY4  |