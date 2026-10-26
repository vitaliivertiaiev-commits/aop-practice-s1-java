package homework.h01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void countsOddsInExampleRanges() {
        assertEquals(3, solution.countOdds(3, 7));
        assertEquals(1, solution.countOdds(8, 10));
    }

    @Test
    void handlesSingleValueAndZero() {
        assertEquals(1, solution.countOdds(1, 1));
        assertEquals(0, solution.countOdds(0, 0));
        assertEquals(1, solution.countOdds(0, 1));
    }

    @Test
    void handlesLargeBounds() {
        assertEquals(500_000_000, solution.countOdds(0, 1_000_000_000));
    }

    @Test
    void rejectsInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> solution.countOdds(-1, 3));
        assertThrows(IllegalArgumentException.class, () -> solution.countOdds(5, 4));
    }
}
