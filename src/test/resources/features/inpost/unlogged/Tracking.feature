Feature: Sledzenie przesylek
  Jako uzytkownik niezalogowany
  Chcę móc sledzic przesylke

  Scenario: Poprawne wyswietlenie sledzonej przesylki
    Given Otworzylem strone glowna inpost
    And Wpisuje numer przesylki "630075127031589010345249"
    And Nasickam przycisk Znajdz
    Then Wyswietlona zostaje formatka sledzenia przesylki
    And Status przesylki to "Dostarczona"