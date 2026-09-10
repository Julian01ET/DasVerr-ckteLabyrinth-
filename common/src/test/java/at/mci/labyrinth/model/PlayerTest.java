package at.mci.labyrinth.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void hasReachedAllGoalsOnlyWhenEveryGoalIsCollected() {
        Player player = new Player("p1", "Ada", new Position(0, 0));
        Treasure goal = new Treasure("t1", "Kelch");
        player.treasureGoals().add(goal);

        assertFalse(player.hasReachedAllGoals());

        player.collectedTreasures().add(goal);

        assertTrue(player.hasReachedAllGoals());
    }
}
