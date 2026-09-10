# Java-Einstieg für dieses Projekt

Du hast noch nie Java programmiert – hier ein Lernpfad, der genau auf das
zugeschnitten ist, was du in diesem Projekt brauchst. Keine Angst vor der
Sprache selbst: Wenn du schon irgendeine Programmiersprache kennst, überträgt
sich vieles direkt. Falls nicht, geht auch das – Schritt für Schritt.

## 1. Java-Grundlagen (bevor du im Projekt mitcodest)

Ca. 1–2 Wochenenden, mit Fokus auf das, was wir brauchen:

1. **Syntax & Basistypen:** Variablen, `if`/`else`, Schleifen, Methoden.
2. **Klassen & Objekte:** Felder, Konstruktoren, Getter. Schau dir dazu
   `common/src/main/java/at/mci/labyrinth/model/Player.java` in diesem Repo an
   – das ist eine ganz normale, einfache Java-Klasse.
3. **Enums:** siehe `Direction.java`, `Bonus.java` – eine feste Menge
   benannter Werte, super für Spielregeln wie Himmelsrichtungen oder Bonitypen.
4. **Records:** siehe `Position.java`, `Treasure.java`, `GameConfig.java` –
   moderne, kurze Schreibweise für unveränderliche Datenobjekte (Java 16+).
5. **Collections:** `List`, `Set`, `Map` (Pakete `java.util.*`) – wir nutzen
   sie z. B. für die Liste der Spieler oder gesammelten Schätze.
6. **Exceptions:** `throw new IllegalArgumentException(...)`, siehe
   `GameConfig.java` – wie man ungültige Zustände abfängt.

Empfohlene, kostenlose Ressourcen:
- [Oracle Java Tutorials](https://docs.oracle.com/javase/tutorial/) – offizielles Tutorial.
- [Java Programming MOOC (Uni Helsinki)](https://java-programming.mooc.fi/) – sehr praxisnah, mit Übungen.

## 2. Werkzeuge, die wir im Projekt nutzen

- **Maven** (`pom.xml`): verwaltet Abhängigkeiten und den Build. Wichtigste
  Befehle: `mvn test` (bauen + testen), `mvn package` (JAR bauen). Muss man
  nicht komplett verstehen, um loszulegen – die Struktur ist schon angelegt.
- **JUnit 5**: Test-Framework. Schau dir `BoardTest.java` an – ein Test ist
  einfach eine Methode mit `@Test`, die etwas prüft (`assertEquals`, ...).
- **Git/GitHub**: siehe `../CONTRIBUTING.md` für unseren Workflow.
- **IDE:** IntelliJ IDEA (Community Edition, kostenlos) wird an der MCI
  meist verwendet und erkennt Maven-Projekte automatisch beim Öffnen des
  Ordners.

## 3. Themen, die später im Projekt dazukommen

In dieser Reihenfolge, orientiert am Fahrplan:

1. **Objektorientierter Entwurf des Spiels** (jetzt/laufend): Spielfeld,
   Figuren, Regeln – siehe `common/.../model/`.
2. **Netzwerkprogrammierung mit Sockets** (`java.net.ServerSocket`,
   `java.net.Socket`) – Grundgerüst existiert bereits in `ServerMain.java`
   und `ClientMain.java`. Wichtig für das Verständnis: Ein Socket ist wie ein
   Telefonhörer – Server "wartet auf Anruf" (`accept()`), Client "ruft an"
   (`new Socket(host, port)`).
2b. **Nebenläufigkeit (Threads):** der Server muss mehrere Clients
   gleichzeitig bedienen können (`Thread`, evtl. `ExecutorService`).
3. **Serialisierung (JSON):** sobald das gruppenübergreifende Protokoll
   feststeht (`docs/protokoll-entwurf.md`), z. B. mit der Bibliothek
   [Jackson](https://github.com/FasterXML/jackson).
4. **GUI für den Desktop-Client:** z. B. mit JavaFX oder Swing, um das
   Spielfeld darzustellen.
5. **Einfache KI:** Für die verpflichtende KI-Vertretung reicht anfangs eine
   regelbasierte Strategie (z. B. "bewege in Richtung des nächsten
   Schatzes"), solange sie nicht rein zufällig ist.

## 4. Wie du am besten lernst, während du mitbaust

- Fang bei kleinen, klar abgegrenzten Aufgaben an (z. B. eine neue Methode
  in einer bestehenden Model-Klasse, ein neuer Unit-Test).
- Lies bestehenden Code im Repo, bevor du eigenen schreibst – die Model-
  Klassen sind bewusst einfach gehalten.
- Nutze `mvn test` sehr oft – ein grüner Testlauf gibt dir sofort Feedback,
  ob dein Code (noch) funktioniert.
- Frag im Team nach, wenn ein Konzept unklar ist – dafür ist die Rolle
  "Programmierung"/erfahrenere Teammitglieder da, aber auch der
  Gruppenbetreuer in den Meetings.
