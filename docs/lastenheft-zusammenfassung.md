# Lastenheft – Zusammenfassung

Kurzfassung des offiziellen Lastenhefts. Bei Widersprüchen gilt immer das
Original-PDF (Sakai → Resources), nicht diese Zusammenfassung.

## 1. Aufgabenstellung

- Verteilte Umsetzung von "Das verrückte Labyrinth" (Vorbild: Originalspiel
  von Ravensburger).
- Client-Server-Architektur: mehrere Spieler-Clients treten gegeneinander an,
  verbunden über einen gemeinsamen Server.
- Jeder Client steuert genau eine Spielfigur und bietet Anzeige-/Komfortfunktionen.
- Server: verwaltet Anmeldung der Clients, wickelt die Partie ab, überwacht
  regelkonformes Verhalten von Clients *und* Figuren.
- **Pflicht:** Server + mindestens 1 Desktop-Client, beide in Java.
- **Optional:** weitere Clients (Web, Smartphone, ...) in beliebiger Technologie.

## 2. Ablaufbeispiel

- Es gibt (optional/ergänzend) einen zentralen Verzeichnisserver, bei dem
  sich Spielserver anmelden und über den Clients verfügbare Server abfragen
  können.
- Client wählt Server aus → gibt Benutzernamen an → verbindet sich → wartet
  auf weitere Spieler.
- Server nimmt **mind. 2, max. 4 Spieler** an; Server selbst oder ein
  Administrator startet die Partie.
- Beim Start: Server baut Spielfeld auf, platziert Spielobjekte, informiert
  Clients; hält sie danach laufend auf aktuellem Stand.
- Jeder Spieler bekommt geheime Schatzkarten (Missionsziele).
- Rundenbasiert, ein Spieler pro Zug am Zug. Ein Zug = **genau 2 Schritte**:
  (1) einen Gang verschieben, (2) eigene Figur ziehen.
- Partieende: konfigurierbare Spielzeit abgelaufen ODER ein Spieler hat alle
  Schätze gesammelt → Server zeigt Rangliste (nach Punkten) + weitere
  Kennzahlen (zurückgelegte Schritte, geschobene Gänge, gesammelte Schätze,
  blockierte Wege).
- Neue Runde: bestehende Clients zuerst wieder aufnehmen, dann neue zulassen.
- Timeout: Client reagiert > 30s nicht (serverseitig gemessen) → Countdown
  3s → Server entfernt ihn aus der Partie.
- Server muss den Spielverlauf protokollieren, mindestens sichtbar im
  Server-Fenster.
- Jeder Client muss die Möglichkeit bieten, den eigenen Spieler durch eine
  **KI** vertreten zu lassen – die KI darf **nicht rein zufällig** agieren.

## 3. Spielfeld und Spielregeln

- Spielfeld: n × m Felder, n/m konfigurierbar.
- z Spieler, 2 ≤ z ≤ 4.
- Jeder Spieler hat x Schatzkarten, x konfigurierbar.
- Spielobjekte pro Feld: Spielfiguren, Schätze, feste Gänge, verschiebbare
  Gänge, Boni.
- Zwei Figuren dürfen nie dasselbe Feld belegen.
- Jedes Feld trägt höchstens einen Gang.
- Feste Gänge behalten ihre Position, außer ein Bonus ändert das.
- Innerhalb eines Zuges darf eine Figur beliebig weit entlang
  zusammenhängender Gänge laufen (keine unzulässigen Züge), darf dabei über
  andere Figuren hinwegziehen, darf den Laufweg **nicht umkehren** und nach
  einem Halt **nicht weiterlaufen**.
- Für alle übrigen Regeln (inkl. Schieben der Gänge) gilt das Originalspiel.

### Boni (konfigurierbare, zufällige Häufigkeit)

- **Beamen:** eigene Figur einmalig an beliebige unbesetzte Position teleportieren.
- **Feste Gänge schieben:** einmalig auch feste Gänge verschiebbar machen.
- **Tauschen:** eigene Position einmalig mit der eines beliebigen anderen Spielers tauschen.
- **Zweimal schieben:** innerhalb eines Zuges ein zweites Mal das Spielfeld verschieben.

Regel: Wer zuerst einen Bonus erreicht, sammelt ihn ein (dann für andere
weg); Einsatz später, beliebiger Zeitpunkt, jeder Bonus nur einmal nutzbar.

### Achievements (Beispiele, offen für eigene Ideen)

Läufer (meiste überquerte Felder), Schieber (meiste geschobene Gänge),
Blocker (meiste verhinderte gegnerische Züge), Zeitfresser (100 gespielte
Partien), Hattrick (3 Siege in Folge), …

## 4. Punktesystem und Spielende

Punktesystem (wie Sieger bestimmt wird, über die Platzierung aus Kapitel 2
hinaus) legt **jede Gruppe selbst** fest.

## 5. Kommunikation und Kompatibilität

- Schnittstellen zwischen Server und Client entwirft **jede Gruppe selbst**.
- **Aber:** gruppenübergreifend ein **einheitlicher Kommunikationsstandard**,
  sodass Server und Clients unterschiedlicher Gruppen beliebig
  untereinander austauschbar sind. → siehe `protokoll-entwurf.md`, muss mit
  den anderen Gruppen (Schnittstellenkomitee) abgestimmt werden.

## 6. Interne Qualität

- Umsetzung durch geeignete Entwurfsdokumente nachvollziehbar begründen/dokumentieren.
- Code: gut dokumentiert, sinnvoll strukturiert, leicht verständlich, wartbar.
- Testfälle müssen v.a. die zentralen Serverfunktionen absichern: am Server
  dürfen keine unzulässigen Spielzüge zustande kommen; Clients dürfen nicht
  unzulässig mit dem Server interagieren können.

## Aus der Projektvorstellung (Folien)

- Gruppengröße 6–7 Personen; verpflichtende Rollen: Gruppenmanagement,
  Schriftführung, Qualitätsmanagement, Schnittstellenvertretung (vertritt die
  Gruppe im **Schnittstellenkomitee**, wo der gemeinsame Kommunikationsstandard
  zwischen allen Gruppen verhandelt wird).
- Benotung: Pflichtenheft 15 %, Testplan & Unit Tests 15 %, finale Abgabe
  30 %, Abschlusspräsentation 40 %. Mind. 60 % für Positiv.
