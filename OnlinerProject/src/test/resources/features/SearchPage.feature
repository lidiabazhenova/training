Feature: Search page

  Scenario: Check phones is selected to compare
    Given Open https://catalog.onliner.by
    When User search "HTC"
    Then Search page opens
    When User click on any two phones and go to compare results
    Then Check description and prices of this phones are displayed on compare results