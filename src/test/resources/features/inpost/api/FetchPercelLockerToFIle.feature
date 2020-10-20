Feature: Pobieranie paczkomatow do pliku
  Jako uzytkownik niezalogowany
  Chcę móc pobrac dostepne paczkomaty do pliku

  Scenario: Pobieranie paczkomatow do pliku
    Given Pobieram 20 paczkomatow
    Then Zapisuje liste paczkomatow jako plik