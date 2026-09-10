# Entwurf: Gruppenübergreifendes Netzwerkprotokoll

> **Wichtig:** Das hier ist ein Diskussionsvorschlag unserer Gruppe, **kein**
> fertiger Standard. Laut Lastenheft Kapitel 5 muss der Kommunikationsstandard
> mit *allen* Gruppen im Schnittstellenkomitee abgestimmt werden (die Person
> in der Rolle "Schnittstellenvertretung" vertritt uns dort). Erst nach
> Einigung wird daraus Code im `common`-Modul.

## Warum das überhaupt geklärt werden muss

Jede Gruppe baut ihren eigenen Server und Client. Damit sich am Ende *jeder*
Client mit *jedem* Server verbinden kann, müssen alle Gruppen exakt dasselbe
"Alphabet" sprechen: dieselben Nachrichtentypen, dasselbe Format, dieselbe
Bedeutung der Felder. Das ist etwas, das sich niemand alleine ausdenken darf
– es ist eine Verhandlung.

## Zu klärende Grundsatzfragen (mit Vorschlag)

1. **Transportprotokoll:** TCP (zustandsbehaftete Verbindung passt gut zu
   "ein Client = eine Partie/Session"). *Vorschlag: TCP.*
2. **Nachrichtenformat:** Textbasiert und für Menschen lesbar erleichtert
   Debugging zwischen fremden Implementierungen enorm. *Vorschlag: JSON,
   eine Nachricht pro Zeile (newline-delimited), oder JSON mit vorangestellter
   Längenangabe.*
3. **Nachrichten-Hülle:** Jede Nachricht braucht mindestens einen `type` und
   eine `payload`, damit Empfänger unbekannte Felder ignorieren können
   (Abwärtskompatibilität zwischen Gruppen mit leicht unterschiedlichem
   Funktionsumfang).

   ```json
   {"type": "MOVE", "payload": { "playerId": "p1", "toRow": 3, "toColumn": 4 }}
   ```

4. **Koordinatensystem:** (row, column), 0-basiert, (0,0) = oben links.
   *Muss gruppenübergreifend gleich definiert sein.*
5. **Figuren/Spieler-Identifikation:** eindeutige String-IDs statt Indizes,
   damit das Protokoll auch bei unterschiedlicher interner Modellierung stabil bleibt.
6. **Versionierung:** ein `protocolVersion`-Feld beim Verbindungsaufbau, damit
   inkompatible Änderungen erkannt (nicht: verhindert) werden können.

## Beispielhafte Nachrichtentypen (nur Diskussionsgrundlage)

| Richtung | Typ | Zweck |
|---|---|---|
| Client → Server | `HELLO` | Verbindungsaufbau, Benutzername, Protokollversion |
| Server → Client | `SERVER_LIST` | Antwort des Verzeichnisservers (optional) |
| Server → Client | `GAME_STATE` | Voller oder inkrementeller Spielstand |
| Client → Server | `SHIFT_CORRIDOR` | Schritt 1 des Zuges: Gang schieben |
| Client → Server | `MOVE` | Schritt 2 des Zuges: Figur ziehen |
| Client → Server | `USE_BONUS` | Bonus einsetzen |
| Server → Client | `GAME_OVER` | Rangliste + Kennzahlen |
| Server → Client | `ERROR` | Ungültiger Zug / ungültige Anfrage |

## Nächste Schritte

1. In unserem eigenen Pflichtenheft (Abschnitt "Schnittstellen") unseren
   Vorschlag festhalten.
2. Über die Schnittstellenvertretung mit den anderen Gruppen abstimmen
   (Sakai-Forum bzw. Schnittstellenkomitee-Treffen).
3. Ergebnis hier aktualisieren und danach im `common`-Modul als konkrete
   Java-Klassen (z. B. `at.mci.labyrinth.protocol`) umsetzen – idealerweise
   mit einer JSON-Bibliothek wie Jackson, sobald das Format final ist.
