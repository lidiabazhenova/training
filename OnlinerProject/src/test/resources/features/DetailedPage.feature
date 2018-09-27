Feature: Tv category page

  Scenario: Check diagonal popup in filter
    Given Open https://catalog.onliner.by/mobile/apple/iphone732
    When User scroll  to "Аккумулятор и время работы"
    Then Buttery type equals to "Li-ion"
    And Capacity equals to "1 960 мА·ч"
    And Talking time equals to "14 часов"
    And Wait time equals to "1 неделя, 3 суток"