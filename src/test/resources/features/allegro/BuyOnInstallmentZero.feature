Feature: Dodanie do koszyka przedmiotu z mozliwoscia zakupu na raty zero
  Jako uzytkownik niezalogowany
  Chcę móc dodac do koszyka przedmiot oraz moc zalogowac sie przez facebook do aplikacji

  Scenario: Dodanie przedmiotu do koszyka
    Given Otworzylem strone glowna allegro
    And Wybralem zakladke raty zero
    And Wybieram pierwszy produkt dostepny w karuzeli produktow
    When Sprawdzam czy przedmiot mozna kupic na raty zero
    And Dodaje przedmiot do koszyka
    Then Sprawdzam w koszyku mozliwosc zakupu na raty zero
    And Naciskam przycisk: KUP NA RATY ZERO
    And Wybieram logowanie przez facebooka
    And Popup logowania zostaje wyswietlony