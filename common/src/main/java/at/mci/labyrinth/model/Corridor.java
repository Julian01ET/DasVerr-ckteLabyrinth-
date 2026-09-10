package at.mci.labyrinth.model;

import java.util.EnumSet;
import java.util.Set;

/**
 * Ein Gang-Plättchen auf einem Feld. "Feste Gänge" sind normalerweise nicht verschiebbar
 * (siehe Bonus {@link Bonus#FESTE_GAENGE_SCHIEBEN}), "verschiebbare Gänge" schon.
 */
public final class Corridor {

    private final CorridorType type;
    private final Set<Direction> openings;
    private final boolean fixed;

    public Corridor(CorridorType type, Set<Direction> openings, boolean fixed) {
        this.type = type;
        this.openings = EnumSet.copyOf(openings);
        this.fixed = fixed;
    }

    public CorridorType type() {
        return type;
    }

    public Set<Direction> openings() {
        return Set.copyOf(openings);
    }

    public boolean isFixed() {
        return fixed;
    }

    public boolean isOpenTowards(Direction direction) {
        return openings.contains(direction);
    }
}
