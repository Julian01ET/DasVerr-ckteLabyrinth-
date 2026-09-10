package at.mci.labyrinth.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GameConfigTest {

    @Test
    void rejectsTooManyPlayers() {
        assertThrows(IllegalArgumentException.class,
                () -> new GameConfig(7, 7, 2, 5, 6));
    }

    @Test
    void rejectsTooFewPlayers() {
        assertThrows(IllegalArgumentException.class,
                () -> new GameConfig(7, 7, 1, 4, 6));
    }
}
