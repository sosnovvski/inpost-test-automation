@ManualTest
Feature: Sledzenie przesylek
  Jako uzytkownik niezalogowany
  Chcę móc sledzic przesylke

  Scenario: Poprawne wyswietlenie sledzonej przesylki
    Given Otworzylem strone glowna inpost
    And Wybralem opcje "Sledz paczke"
    When Formatka "Sledz paczke" jest otworzona
    And  Wpisuje numer przesylki 873234987612340872938732
    And Nasickam przycisk "Znajdz"
    Then Wyswietlaja sie infomracje dotyczace sledzenia przesylki
    And Porownuje wyswietlone infomracje dotyczace sledzenia przesylki z baza danych


  Scenario: Brak mozliwosci wyswietlenia sledzonej paczki
    Given Otworzylem strone glowna inpost
    And Wybralem opcje "Sledz paczke"
    When Formatka "Sledz paczke" jest otworzona
    And  Wpisuje numer przesylki 8732349876123408729387321
    And Nasickam przycisk "Znajdz"
    Then Border pola tesktowego "Wpisz numer przesyłki" ma kolor "czerwony"
    And Wyswietlony zostaje komunikat o blednej ilosci znakow

