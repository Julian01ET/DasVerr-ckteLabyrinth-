package at.mci.labyrinth.model;

/** Das n*m große Spielbrett plus das eine verschiebbare Extra-Gang-Plättchen. */
public final class Board {

    private final int rows;
    private final int columns;
    private final Field[][] fields;
    private Corridor spareCorridor;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.fields = new Field[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                fields[row][column] = new Field(new Position(row, column));
            }
        }
    }

    public int rows() {
        return rows;
    }

    public int columns() {
        return columns;
    }

    public Field fieldAt(Position position) {
        return fields[position.row()][position.column()];
    }

    public Corridor spareCorridor() {
        return spareCorridor;
    }

    public void setSpareCorridor(Corridor spareCorridor) {
        this.spareCorridor = spareCorridor;
    }
}
