Feature: Testing to verify if vehicle can be searched successfully
  In order to validate that the Vehicle Search page is working
  Doing the Acceptance Testing

  @VehicleSearch
  Scenario Outline: Validate Vehicle Search Page on "<browser>"
Given Launch browser "<browser>"
    And user navigates to the URL
    And user enter value "<VehicleNumber>" in search field
    And I click on findVehicle button
    Then Verify vehicle details are appearing on the homepage or not "<VehicleNumber>"
    And Verify correct startDate "<StartDate>" is appearing
    And Verify correct endDate "<EndDate>" is appearing

    Examples:
      |browser| VehicleNumber |StartDate|EndDate|
      |chrome| OV12UYY  |09 FEB 2022 : 16 : 26|18 FEB 2022 : 23 : 59|
      |firefox| OV12UYY  |09 FEB 2022 : 16 : 26| 18 FEB 2022 : 23 : 59|