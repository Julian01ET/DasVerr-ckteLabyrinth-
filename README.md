# Das verrückte Labyrinth – Advanced Integrative Project

Verteilte Client-Server-Umsetzung des Ravensburger-Spiels ["Das verrückte
Labyrinth"](https://de.wikipedia.org/wiki/Das_verr%C3%BCckte_Labyrinth) im
Rahmen des Moduls *Advanced Integrative Project* (MCI, WS 2026/27).

Die genauen Anforderungen stehen im **Lastenheft** (Sakai → Advanced
Integrative Project → Resources). Eine Zusammenfassung findest du unten und
in [`docs/lastenheft-zusammenfassung.md`](docs/lastenheft-zusammenfassung.md).

## Team

| Rolle (Pflicht) | Person |
|---|---|
| Gruppenmanagement | *TODO* |
| Schriftführung | *TODO* |
| Qualitätsmanagement | *TODO* |
| Schnittstellenvertretung | *TODO* |

Optionale Rollen (Externe Kommunikation, Datenbank, Architektur,
Technik/Sysadmin, Design, Programmierung, Scrum-Master, …) bitte ebenfalls
im Team verteilen und hier ergänzen.

## Architektur

Ein Maven-Multi-Modul-Projekt mit drei Teilen:

```
labyrinth-parent
├── common   -> Domänenmodell (Spielfeld, Figuren, Schätze, ...) und später
│               das Netzwerkprotokoll. Wird von Server UND Client genutzt.
├── server   -> Der eine verpflichtende Spiele-Server (verwaltet Partien,
│               setzt die Regeln durch).
└── client   -> Der verpflichtende Desktop-Client (Java). Weitere Clients
                (Web, Smartphone, ...) sind optional und dürfen in einer
                anderen Technologie entstehen, solange sie dasselbe
                Netzwerkprotokoll sprechen.
```

Warum diese Struktur? Server und Client sind zwei getrennte, später auf
unterschiedlichen Rechnern laufende Programme. Der `common`-Teil enthält
alles, was beide brauchen (v.a. das gemeinsame Protokoll), damit es nicht
doppelt gepflegt werden muss.

**Wichtig laut Lastenheft Kapitel 5:** Das Netzwerkprotokoll muss
gruppenübergreifend kompatibel sein – Server und Clients *aller* fünf/sechs
Gruppen müssen beliebig miteinander funktionieren. Der aktuelle
Diskussionsstand dazu steht in
[`docs/protokoll-entwurf.md`](docs/protokoll-entwurf.md). Das ist **kein**
Alleingang unserer Gruppe, sondern muss über das Schnittstellenkomitee mit
den anderen Gruppen abgestimmt werden (siehe unten).

## Build & Ausführen

Voraussetzung: JDK 21 und Maven.

```bash
# Alles bauen und testen
mvn test

# Server starten (Standardport 5000)
mvn -pl server exec:java -Dexec.mainClass=at.mci.labyrinth.server.ServerMain

# oder nach dem Paketieren direkt als Jar:
mvn -pl common,server package
java -jar server/target/labyrinth-server.jar

# Client starten (verbindet sich zu localhost:5000)
mvn -pl common,client package
java -jar client/target/labyrinth-client.jar localhost 5000
```

## Fahrplan (aus der Projektvorstellung)

| Datum | Meilenstein |
|---|---|
| 02. September | Projektstart & Gruppenfindung |
| 25. Oktober | Abgabe Pflichtenheft |
| 11./12. November | Präsentation & Fragerunde Pflichtenheft |
| 22. November | Abgabe Testplan & Unit Tests |
| 02./03. Dezember | Präsentation & Fragerunde Testplan |
| 16. Dezember | Zwischenpräsentation |
| 24. Jänner | Finale Abgabe |
| 03. Februar | Abschlusspräsentation |

## Dokumentation

- [`docs/lastenheft-zusammenfassung.md`](docs/lastenheft-zusammenfassung.md) – Kurzfassung der Anforderungen
- [`docs/pflichtenheft-vorlage.md`](docs/pflichtenheft-vorlage.md) – Vorlage für unser eigenes Pflichtenheft (Abgabe 25.10.)
- [`docs/protokoll-entwurf.md`](docs/protokoll-entwurf.md) – Entwurf für das gruppenübergreifende Netzwerkprotokoll
- [`docs/java-einstieg.md`](docs/java-einstieg.md) – Lernpfad Java für Einsteiger, zugeschnitten auf dieses Projekt
- [`CONTRIBUTING.md`](CONTRIBUTING.md) – Wie wir zu sechst im selben Repo arbeiten (Branches, Pull Requests, Reviews)

## Kommunikation

- Fragen, die alle betreffen: Sakai-Forum
- Fragen an den Gruppenbetreuer: Sakai-Message-Tool
- Innerhalb des Teams: dieses Repo (Issues) + eigener Chat/BBB-Raum
- Kritik/Anregungen an die LV: entsprechendes Sakai-Unterforum (anonym)
