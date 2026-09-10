package at.mci.labyrinth.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class BoardTest {

    @Test
    void createsAllFieldsWithCorrectPositions() {
        Board board = new Board(7, 7);

        assertEquals(7, board.rows());
        assertEquals(7, board.columns());
        Field field = board.fieldAt(new Position(3, 4));
        assertEquals(new Position(3, 4), field.position());
        assertFalse(field.isOccupied());
        assertNull(field.corridor());
    }
}
