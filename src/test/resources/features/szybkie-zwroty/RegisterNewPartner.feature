@ManualTest
Feature: Rejestracja nowego partnera
  Jako uzytkownik niezalogowany
  Chce moc zarejestrowac nowego partnera

  Scenario: Poprawne wyslanie formularza zgloszeniowego nowego partnera
    Given Otworzylem strone glowna szybkiezwroty
    And Wybieram zakladke "Zostan partnerem"
    And Wyswietlona zostaje formatka rejestracji nowego patrnera
    And naciskam przycik "Wypelnij formularz"
    When Wywietlony zostal formularz rejestracji
    And  Wpisuje adres strony: "costam.com"
    And  Wpisuje imie i nazwisko: "Imie Nazwisko"
    And  Wpisuje adres firmy: "adres"
    And  Wpisuje nazwe kod pocztowy: "80-123"
    And  Wpisuje telefon: "123456789"
    And  Wpisuje email: "lol@lol.pl"
    And  Wpisuje login do menagera paczek: "login"
    And  Nacisnij przycisk "Wyslij"
    Then Wyswietlony zostaje komunikat o poprawnosci wyspelnienia formularza zgloszeniowego
    And Wystwietlona zostaje informacja o kontakcie zwrotnym


  Scenario: Brak danych w formularzu zgloszeniowym nowego partnera
    Given Otworzylem strone glowna szybkiezwroty
    And Wybieram zakladke "Zostan partnerem"
    And Wyswietlona zostaje formatka rejestracji nowego patrnera
    And naciskam przycik "Wypelnij formularz"
    When Wywietlony zostal formularz rejestracji
    And  Nacisnij przycisk "Wyslij"
    Then Sprawdzam czy przy kazdym wymaganym polu wyswietlony zostal komunikat o koniecznosci wypelnienia