@ManualTest
Feature: Oferty pracy
  Jako uzytkownik niezalogowany
  Chcę móc otworzyc oferty pracy

  Scenario: Poprawne wyswietlenie oferty pracy
    Given Otworzylem strone glowna inpost
    And Wybralem zakladke kariera
    When Wybieram zespol "IT"
    And  Naciskam przycisk "Znajdz"
    Then Wyswietlaja sie mozliwe oferty pracy
    And Porownaj ilosc ofert wyswietlonych z baza danych
    And Porownuje nazwy stanowisk wyswietlone z baza danych

  Scenario: Brak mozliwosci wyswirtlenia ofert pracy
    Given Otworzylem strone glowna inpost
    When wybieram jezyk angielski aplikacji
    Then Zakladka "Carieers" nie jest dostepna

