# Pflichtenheft: Das verrückte Labyrinth

> Status: **Entwurf/Vorlage.** Bis 25. Oktober gemeinsam ausfüllen und
> finalisieren (Abgabetermin laut Fahrplan). Jede Sektion nennt, wer sie
> sinnvollerweise befüllt – passt das an eure tatsächliche Rollenverteilung an.
>
> Empfohlener Workflow: pro Abschnitt einen eigenen Branch/PR, damit man sich
> nicht gegenseitig überschreibt. Details siehe `../CONTRIBUTING.md`.
> Freies Brainstorming (Formulierungen, Diskussion) gerne vorher in einem
> gemeinsamen Google Doc – die **finale** Fassung gehört aber hierher ins
> Repo, damit sie versioniert und für alle sechs sichtbar ist.

## 1. Zielbestimmung

*(Musskriterien / Wunschkriterien / Abgrenzungskriterien – was bauen wir,
was explizit nicht.)*

## 2. Produkteinsatz

*(Wer nutzt die Software, in welchem Kontext – hier: Lehrveranstaltung,
Demo-Partien zwischen den Gruppen.)*

## 3. Produktumgebung

- Zielplattformen (Server, Desktop-Client): *TODO*
- Java-Version: *TODO* (siehe `pom.xml`, aktuell Java 21)
- Betriebssysteme: *TODO*
- Optionale Clients (Web/Mobile) und deren Technologie: *TODO*

## 4. Funktionale Anforderungen

Strukturiert nach Lastenheft Kapitel 2–4. Für jede Anforderung: eindeutige
ID, Beschreibung, Priorität (Muss/Soll/Kann).

| ID | Beschreibung | Priorität |
|---|---|---|
| F-01 | Server nimmt 2–4 Spieler-Clients an | Muss |
| F-02 | Client meldet sich mit Benutzernamen an | Muss |
| F-03 | Server konfiguriert Spielfeldgröße n×m | Muss |
| F-04 | Rundenbasierter Zug: Gang schieben + Figur ziehen | Muss |
| F-05 | Schatzkarten / Missionsziele je Spieler | Muss |
| F-06 | Boni: Beamen, Feste Gänge schieben, Tauschen, Zweimal schieben | Muss |
| F-07 | Achievements | Soll |
| F-08 | KI-Vertretung je Client (nicht rein zufällig) | Muss |
| F-09 | Timeout-Handling (30s + 3s Countdown) | Muss |
| F-10 | Serverseitiges Protokoll des Spielverlaufs | Muss |
| F-11 | Neue Runde: bestehende Clients zuerst wieder aufnehmen | Muss |
| F-12 | Zentraler Verzeichnisserver für Server-Liste | Kann |
| … | … | … |

## 5. Nichtfunktionale Anforderungen

*(Performance, Robustheit gegen fehlerhafte/böswillige Clients,
Testbarkeit, Wartbarkeit, Dokumentation – siehe Lastenheft Kapitel 6.)*

## 6. Schnittstellen

- **Intern:** common ↔ server ↔ client (siehe Architektur in `../README.md`).
- **Extern / gruppenübergreifend:** Netzwerkprotokoll gemäß
  `protokoll-entwurf.md`, abgestimmt im Schnittstellenkomitee mit den
  anderen Gruppen.

## 7. Ergänzungen

*(Risiken, offene Fragen, Annahmen.)*

## 8. Punktesystem (eigene Festlegung laut Lastenheft Kap. 4)

*(Wie wird aus Platzierung + gesammelten Schätzen + Achievements etc. eine
Punktzahl / ein Sieger bestimmt?)*
