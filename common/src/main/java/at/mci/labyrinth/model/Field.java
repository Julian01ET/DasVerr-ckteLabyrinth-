package at.mci.labyrinth.model;

/**
 * Ein Feld des n*m großen Spielbretts. Höchstens ein Gang pro Feld, höchstens eine
 * Spielfigur pro Feld (siehe Lastenheft Kapitel 3).
 */
public final class Field {

    private final Position position;
    private Corridor corridor;
    private Treasure treasure;
    private Bonus bonus;
    private String occupantPlayerId;

    public Field(Position position) {
        this.position = position;
    }

    public Position position() {
        return position;
    }

    public Corridor corridor() {
        return corridor;
    }

    public void setCorridor(Corridor corridor) {
        this.corridor = corridor;
    }

    public Treasure treasure() {
        return treasure;
    }

    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public Bonus bonus() {
        return bonus;
    }

    public void setBonus(Bonus bonus) {
        this.bonus = bonus;
    }

    public String occupantPlayerId() {
        return occupantPlayerId;
    }

    public void setOccupantPlayerId(String occupantPlayerId) {
        this.occupantPlayerId = occupantPlayerId;
    }

    public boolean isOccupied() {
        return occupantPlayerId != null;
    }
}
