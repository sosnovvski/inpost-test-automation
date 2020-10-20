@ManualTest
Feature: Rejestracja nowego percel menagera
  Jako uzytkownik niezalogowany
  Chce moc zarejestrowac sie jako percel menager

  Scenario: Poprawne zarejestrowanie pervel menagera
    Given Otworzylem strone glowna inpost
    And Rozwijam liste rozwijana "Log in"
    And Wybieram z listy rozwijanej "Percel menager"
    And w nowej karcie otwarta zostaje formatka logowania "percel menagera"
    When Wybieram ocje "Rejestracja"
    And  Wpisuje email: "lol@lol.pl"
    And  Wpisuje imie: "Kamil"
    And  Wpisuje telefon: "123456789"
    And  Wpisuje nazwe kod pocztowy: "80-123"
    And  Wpisuje nazwe haslo: "324123423dsafsFSF"
    And  Wpisuje nazwe powtorz haslo: "324123423dsafsFSF"
    And  Wybierz preferowany paczkomat: ""
    And  Wybierz typ konta "Firma"
    And  Nacisnij przycisk "Zarejstruj sie"
    Then Wyswietlony zostaje komunikat o poprawnej rejestracji
    And Sprawdzam w bazie danych poprawnosc dodanych rekordow


  Scenario: Brak danych w formularzu rejestracji percel menagera
    Given Otworzylem strone glowna inpost
    And Rozwijam liste rozwijana "Log in"
    And Wybieram z listy rozwijanej "Percel menager"
    And w nowej karcie otwarta zostaje formatka logowania "percel menagera"
    When Wybieram ocje "Rejestracja"
    And  Nacisnij przycisk "Zarejstruj sie"
    Then Sprawdzam czy przy kazdym wymaganym polu wyswietlony zostal komunikat o koniecznosci wypelnienia