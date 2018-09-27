Feature: TabletPC category page

  Scenario: Check producers is selected
    Given Open https://catalog.onliner.by/tabletpc
    When User clicks on "Все 62 варианта" in filter "Производитель"
    Then AllProducerspopup opens
    When Click on producers: "Xiaomi,Ritmix,Philips,Prestigio,Sony,TELEFUNKEN,Tesla,TeXet,Toshiba,Евросеть" in AllProducerspopup
    Then Check all producers "Xiaomi,Ritmix,Philips,Prestigio,Sony,TELEFUNKEN,Tesla,TeXet,Toshiba,Евросеть" are clicked in filter "Производитель"
    And Check all producers "Xiaomi,Ritmix,Philips,Prestigio,Sony,TELEFUNKEN,Tesla,TeXet,Toshiba,Евросеть" are clicked in search results