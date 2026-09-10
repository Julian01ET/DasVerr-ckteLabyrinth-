package at.mci.labyrinth.model;

/** Eine der vier Himmelsrichtungen, in die ein Gang von einem Feld aus offen sein kann. */
public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction opposite() {
        return switch (this) {
            case NORTH -> SOUTH;
            case SOUTH -> NORTH;
            case EAST -> WEST;
            case WEST -> EAST;
        };
    }
}
