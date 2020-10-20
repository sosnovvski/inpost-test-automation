Feature: Odtworzenie filmu
  Jako uzytkownik niezalogowany
  Chcę móc odtworzyc film

  Scenario: Odtworzenie filmu
    Given Otworzylem strone glowna abb
    And Wybralem zakladke: Downloads
    And Wybieram zakladke: Movie
    When Naciskam na tytul filmu
    Then Film jest odtwarzany w osobnej karcie