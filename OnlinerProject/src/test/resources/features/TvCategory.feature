Feature: Tv category page

  Scenario: Check diagonal popup in filter
    Given Open https://catalog.onliner.by/tv
    When User clicks on question mark near "Диагональ"
    Then Diagonal popup opens
    And Popup header equals to "Диагональ"
    And Popup header font weight equals to 700
    And Popup text equals to "Размер диагонали экрана в дюймах. Минимальный комфортный размер зависит от расстояния между экраном и зрителем, поскольку необходимо, чтобы изображение занимало определенный процент поля зрения."
    And Popup text font weight equals to 400