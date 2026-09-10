# Zusammenarbeit im Team (6 Personen)

## Repository einrichten (einmalig, pro Person)

1. GitHub-Repo: alle 6 Teammitglieder müssen als Collaborator eingeladen
   werden (Repo-Owner → Settings → Collaborators). Ohne Einladung kein Push.
2. Klonen: `git clone <repo-url>`
3. Auf den Entwicklungs-Branch wechseln bzw. eigenen Feature-Branch davon
   abzweigen (siehe unten).

## Branch-Strategie

- `main`: immer bauf- und lauffähig (mindestens `mvn test` grün). Direktes
  Pushen auf `main` vermeiden.
- Für jede Aufgabe ein eigener Branch, z. B. `feature/bonus-tauschen`,
  `feature/server-socket`, `docs/pflichtenheft-schnittstellen`.
- Änderungen per **Pull Request** nach `main` mergen, nicht direkt pushen.
  Das gibt der Qualitätsmanagement-Rolle die Chance, kurz drüberzuschauen
  (Code, Dokumente, Protokolle – siehe Rollenverteilung), bevor etwas in
  `main` landet.
- Konflikte/uneinige Fälle: laut Rollenverteilung entscheidet am Ende das
  Gruppenmanagement.

## Typischer Ablauf für eine Änderung

```bash
git checkout main
git pull origin main
git checkout -b feature/mein-thema

# ... Code ändern ...

mvn test          # lokal prüfen, bevor gepusht wird
git add <dateien>
git commit -m "Kurze, verständliche Beschreibung der Änderung"
git push -u origin feature/mein-thema
# -> Pull Request auf GitHub öffnen, Review anfragen, dann mergen
```

## Wer macht was (Pflichtrollen laut Projektvorstellung)

- **Gruppenmanagement:** verantwortlich für die Gruppe, trifft finale
  Entscheidungen bei Uneinigkeit.
- **Schriftführung:** protokolliert Meetings, pflegt die Protokolle (z. B.
  unter `docs/protokolle/`) und hält die Aufgabenübersicht aktuell (z. B.
  über GitHub Issues).
- **Qualitätsmanagement:** prüft Code, Dokumente und Protokolle, bevor sie
  gemergt/abgegeben werden – idealerweise als Reviewer auf jedem Pull Request.
- **Schnittstellenvertretung:** vertritt uns im gruppenübergreifenden
  Schnittstellenkomitee, das den gemeinsamen Kommunikationsstandard
  festlegt (siehe `docs/protokoll-entwurf.md`).

## Gemeinsame Dokumente (Pflichtenheft, Protokolle, ...)

Damit alle sechs am selben Stand arbeiten und nichts doppelt/gegenläufig
bearbeitet wird:

- **Endgültige Fassungen** (Pflichtenheft, Protokoll-Entwurf, Testplan)
  gehören als Markdown in dieses Repo, unter `docs/`. Vorteil: versioniert,
  Änderungen nachvollziehbar (`git log`/`git blame`), über Pull Requests
  reviewbar – genau wie Code.
- **Offenes Brainstorming/gemeinsames Schreiben in Echtzeit** (z. B. beim
  gemeinsamen Formulieren eines Kapitels) geht in einem geteilten Google Doc
  oft leichter von der Hand als über Git. Empfehlung: dort entwerfen,
  anschließend die finale Version in einem Pull Request ins Repo übernehmen
  – spätestens vor jeder Abgabefrist (Pflichtenheft: 25.10.).
- Meeting-Protokolle (Aufgabe der Schriftführung) am besten ebenfalls unter
  `docs/protokolle/YYYY-MM-DD.md` versionieren.

## Vor jedem Commit/Push

- `mvn test` lokal laufen lassen.
- Prüfen, dass keine IDE-/Build-Dateien versehentlich mit eingecheckt werden
  (siehe `.gitignore` – `target/`, `.idea/`, `*.iml` sind schon ausgeschlossen).
