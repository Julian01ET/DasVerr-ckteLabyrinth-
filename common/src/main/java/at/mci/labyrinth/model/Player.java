package at.mci.labyrinth.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

/** Ein Spieler mit seiner Figur, seinen (geheimen) Zielschätzen und seinem Fortschritt. */
public final class Player {

    private final String id;
    private final String name;
    private Position position;
    private final List<Treasure> treasureGoals = new ArrayList<>();
    private final List<Treasure> collectedTreasures = new ArrayList<>();
    private final Set<Bonus> collectedBonuses = EnumSet.noneOf(Bonus.class);
    private final PlayerStats stats = new PlayerStats();

    public Player(String id, String name, Position startPosition) {
        this.id = id;
        this.name = name;
        this.position = startPosition;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Position position() {
        return position;
    }

    public void moveTo(Position position) {
        this.position = position;
    }

    public List<Treasure> treasureGoals() {
        return treasureGoals;
    }

    public List<Treasure> collectedTreasures() {
        return collectedTreasures;
    }

    public Set<Bonus> collectedBonuses() {
        return collectedBonuses;
    }

    public PlayerStats stats() {
        return stats;
    }

    public boolean hasReachedAllGoals() {
        return collectedTreasures.containsAll(treasureGoals);
    }
}
