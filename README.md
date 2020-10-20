# inpost-test-automation
Gotowy minimalistyczny framework testowy do testow UI jak i testow API.

WYMÓG: WINDOWS 10 oraz dostep do internetu ;)

1. Zaintaluj jre 1.8.0_241 
2. Pobierz mavena 
https://apache.mirrors.tworzy.net/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip
3.Dodaj zmienna srodowiskowa JAVA_HOME, edutuj zmienna Path i dodaj do niej sciezke do
folderu apache-maven-3.6.3/bin oraz dodaj %JAVA_HOME%/bin rowniez w zmiennej srodowiskowej Path.
Przyklad ponizej.
![alt text](https://tutorials.visualstudio.com/Java/hello-world/Maven_Path.png)
4. Skolonuj repozytorium
5 W folderze glownym uruchom wiersz polecen i wykonaj:
mvn clean install

----------------------------------------------------------
ERROR CASES:
W przypadku gdy podczas wykonywania mvn clean install wyswitlony zostanie komunikat 
mvn is not recognized... oznacza prawdopodobnie zle skonfigurowane zmienne srodowiskowe

Zostana wykonane wszystkie testy (oprocz manualnych) ktore byly zdefiniowane w 
zadaniu rekrutacyjnym
 
