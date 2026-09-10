package at.mci.labyrinth.model;

/** Kennzahlen je Spieler für die Rangliste am Spielende (Lastenheft Kapitel 2). */
public final class PlayerStats {

    private int stepsTaken;
    private int corridorsPushed;
    private int blockedOpponentMoves;

    public int stepsTaken() {
        return stepsTaken;
    }

    public void incrementStepsTaken(int steps) {
        stepsTaken += steps;
    }

    public int corridorsPushed() {
        return corridorsPushed;
    }

    public void incrementCorridorsPushed() {
        corridorsPushed++;
    }

    public int blockedOpponentMoves() {
        return blockedOpponentMoves;
    }

    public void incrementBlockedOpponentMoves() {
        blockedOpponentMoves++;
    }
}
