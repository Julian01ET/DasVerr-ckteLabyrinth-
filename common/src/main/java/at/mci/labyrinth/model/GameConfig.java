package at.mci.labyrinth.model;

/**
 * Konfigurierbare Eckdaten einer Partie (Lastenheft Kapitel 2/3): Spielfeldgröße n*m,
 * Anzahl Spieler z (2-4) und Anzahl Schatzkarten x pro Spieler.
 */
public record GameConfig(int rows, int columns, int minPlayers, int maxPlayers, int treasuresPerPlayer) {

    public GameConfig {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Spielfeld muss mindestens 1x1 groß sein");
        }
        if (minPlayers < 2 || maxPlayers > 4 || minPlayers > maxPlayers) {
            throw new IllegalArgumentException("Spieleranzahl muss zwischen 2 und 4 liegen");
        }
        if (treasuresPerPlayer < 1) {
            throw new IllegalArgumentException("Jeder Spieler braucht mindestens einen Schatz");
        }
    }
}
