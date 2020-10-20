@ManualTest
Feature: Zwrot towaru przez partnera
  Jako uzytkownik niezalogowany
  Chce moc zwrocic towar

  Scenario: Poprawny zwrot towaru
    Given Otworzylem strone glowna szybkiezwroty
    And Wybieram zakladke "Zwroc towar"
    And Wybieram sklep internetowy "3biker"
    And naciskam przycik "Zwroc teraz!"
    When Wywietlony zostal formularz zwrotu
    And  Wpisuje numer zamowienia: 122314134342
    And  Wpisuje imie i nazwisko: "Imie Nazwisko"
    And  Wpisuje telefon: "123456789"
    And  Wpisuje email: "lol@lol.pl"
    And  Wybieram powod zwrotu: "Material"
    And  Wpisuje opis: "opis"
    And  Nacisnij przycisk "Wyslij"
    Then Odbieram kod zwrotu


  Scenario: Brak danych w formularzu zwrotu towaru
    Given Otworzylem strone glowna szybkiezwroty
    And Wybieram zakladke "Zwroc towar"
    And Wybieram sklep internetowy "3biker"
    And naciskam przycik "Zwroc teraz!"
    When Wywietlony zostal formularz zwrotu
    And  Nacisnij przycisk "Wyslij"
    Then Sprawdzam czy przy kazdym wymaganym polu wyswietlony zostal komunikat o koniecznosci wypelnienia