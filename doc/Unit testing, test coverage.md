# Test coverage, Unit testing


## Test coverage

- A projektbe beépítettük a JaCoCo toolt, azonban nem sikerült vele érdemben kimutatni semmit, nem generálja le a kívánt coverage-filet. 
- Az Android Studio beépített Coverage teszt futtatása során az alábbi kimenetet kaptuk:
![](coverage.png)
A projekt struktúrája borzalmasan szétszórt, a benne lévő teszteket alig lehet értelmezni / teljesen primitívek.
![](coverage2.png)
- Próbáltuk a unit teszteket kiegészíteni, azonban a kód összevisszasága miatt nem tudtunk érdemi eredményt hozzárakni a már meglévőkhöz. Nem értük el az adatbázist, a firebase-hez nincs hozzáférésünk. Logikátlanul van szétszedve modulokra a kód.
### Unit testing


