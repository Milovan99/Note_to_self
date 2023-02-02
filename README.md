# Note to self

  Aplikacija za pravljenje beleški

## O aplikaciji


<img src="https://user-images.githubusercontent.com/29107405/216338624-bdefe7f4-4c32-48eb-97fa-a0198a6ef2ce.png" width="200" height="350">

Ovo je aplikacija za beleške koja koristi RecyclerView za prikaz popisa beleški. Svaka beleška je predstavljena prilagođenim adapterom prikaza (NoteAdapter). Aplikacija omogućava korisniku da kreira novu belešku klikom na floating action button (FAB), koja otvara fragment dijaloga (DialogNewNote) u koji korisnik može uneti detalje beleške. Beleške se pohranjuju u JSON datoteku koristeći JSONSerializer. Aplikacija također ima aktivnost postavki (SettingsActivity) kojoj se može pristupiti sa trake aplikacije. Aplikacija sprema beleške kada je aktivnost pauzirana i učitava ih kada se nastavi.

<img src="https://user-images.githubusercontent.com/29107405/216339672-46f37f1e-732a-468b-9cbc-f5f0c42afdb0.png" width="200" height="350">      <img src="https://user-images.githubusercontent.com/29107405/216339682-73938413-26bb-42d4-bd48-545f049579c9.png" width="200" height="350">      <img src="https://user-images.githubusercontent.com/29107405/216339689-647fa048-d1fe-4f39-9558-a531ba582b21.png" width="200" height="350">

Aktivnost prikazuje listu beleški, koje se mogu dodati, prikazati i sačuvati. Beleške se pohranjuju u ArrayList objekata Note. Klasa koristi klasu JSONSerializer za spremanje i učitavanje bilješki iz JSON datoteke.

Aktivnost prikazuje plutajuće dugme (FAB) koje, kada se klikne, otvara dijalog za kreiranje nove beleške. Beleške se prikazuju u RecyclerView-u i koriste NoteAdapter za prikaz podataka. RecyclerView takođe može prikazati devider-e između stavki zavisno o preferencijama korisnika koje se čuvaju pomoću SharedPreferences.

Aktivnost takođe ima meni sa opcijama sa jednom stavkom, "Settings", koja otvara SettingsActivity kada je odabrana.

Metoda onCreate se poziva kada se aktivnost kreira i postavlja FAB i RecyclerView. Metoda onResume se poziva kada se aktivnost nastavi i provjerava preferencije korisnika za prikazivanje devider-a. Metoda onPause se poziva kada je aktivnost pauzirana i pohranjuje beleške u JSON datoteku. Metoda createNewNote se koristi za dodavanje nove beleške u ArrayList i obavještavanje adaptera o promeni. ShowNote metoda se koristi za prikazivanje odabrane beleške u zasebnoj aktivnost (NoteActivity). Metoda saveNotes koristi JSONSerializer za spremanje beleški u JSON datoteku, a metoda loadNotes koristi istu za učitavanje beleški iz JSON datoteke.
