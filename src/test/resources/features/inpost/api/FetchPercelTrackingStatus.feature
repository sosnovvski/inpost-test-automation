Feature: Sprawdzanie statusu przesylki
  Jako uzytkownik niezalogowany
  Chcę móc sprawdzic status przesylki

  Scenario Outline: Sprawdzanie statusu przesylki
    Given Pobieram status przesylki dla numeru paczki: "<numer_paczki>"
    Then sprawdzam czy poprany status to "<oczekiwany_status>"
    Examples:
      | numer_paczki             | oczekiwany_status                                                                |
      | 630075127031589010345249 | delivered                                                                        |
      | 630091027031589130630794 | delivered                                                                        |
      | 630091027031589130630791 | Tracking information about 630091027031589130630791 shipment has not been found. |