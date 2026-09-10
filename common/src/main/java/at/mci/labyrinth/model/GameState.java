package at.mci.labyrinth.model;

import java.util.ArrayList;
import java.util.List;

/** Gesamtzustand einer Partie: Konfiguration, Spielbrett, Spieler und wer am Zug ist. */
public final class GameState {

    private final GameConfig config;
    private final Board board;
    private final List<Player> players = new ArrayList<>();
    private int currentPlayerIndex;
    private GamePhase phase = GamePhase.WAITING_FOR_PLAYERS;

    public GameState(GameConfig config, Board board) {
        this.config = config;
        this.board = board;
    }

    public GameConfig config() {
        return config;
    }

    public Board board() {
        return board;
    }

    public List<Player> players() {
        return players;
    }

    public Player currentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void advanceToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public GamePhase phase() {
        return phase;
    }

    public void setPhase(GamePhase phase) {
        this.phase = phase;
    }
}
