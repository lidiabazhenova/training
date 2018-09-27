Feature: Search page

  Scenario: Check phones is selected to compare
    Given Open https://catalog.onliner.by
    When User search "HTC"
    Then Search page opens
    When User click on any two phones and go to compare results
    Then Check the description of first phone are displayed on compare results
    And Check the description of second phone are displayed on compare results
    And Check the price of first phone are displayed on compare results
    And Check the price of second phone are displayed on compare results