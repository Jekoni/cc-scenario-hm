Feature: Find milk info in local milk factory's site
   Scenario: search a milk info
    Given url of milk factory site 'http://slavmo.ru/'
    Then  open search field and search to 'Молоко Пастеризованное'
    And make sure that there was info about 'Молоко Пастеризованное'
  Scenario: search a gas info
    Given url of factory site 'http://slavmo.ru/'
    Then  open search field to search 'Бензин'
    And make sure that there is info 'К сожалению, на ваш поисковый запрос ничего не найдено.'
