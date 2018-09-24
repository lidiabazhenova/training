Feature: Mobile category page

  Scenario: Check mobile description on page
    Given Open https://catalog.onliner.by/mobile
    Then Mobiles count on page is equals to 30
    And Mobile headings count on page is equals to 30
    And All mobiles have not null headings
    And Mobile descriptions count on page is equals to 30
    And All mobiles have not null description
    And Mobile prices count on page is equals to 30
    And All mobiles have prices format equals to "^[0-9]+,[0-9]{2}$"