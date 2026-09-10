package at.mci.labyrinth.model;

/** Koordinate eines Feldes auf dem Spielbrett (0-basiert). */
public record Position(int row, int column) {

    public Position neighbor(Direction direction) {
        return switch (direction) {
            case NORTH -> new Position(row - 1, column);
            case SOUTH -> new Position(row + 1, column);
            case EAST -> new Position(row, column + 1);
            case WEST -> new Position(row, column - 1);
        };
    }
}
