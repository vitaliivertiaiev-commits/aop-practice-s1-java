package homework.h05;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void findsMaximumProductDifference() {
        assertEquals(34, solution.maxProductDifference(new int[] {5, 6, 2, 7, 4}));
        assertEquals(64, solution.maxProductDifference(new int[] {4, 2, 5, 9, 7, 4, 8}));
    }

    @Test
    void handlesRepeatedValuesAndSmallestAllowedArray() {
        assertEquals(0, solution.maxProductDifference(new int[] {3, 3, 3, 3}));
        assertEquals(18, solution.maxProductDifference(new int[] {1, 2, 4, 5}));
    }

    @Test
    void rejectsNullOrTooShortInput() {
        assertThrows(IllegalArgumentException.class, () -> solution.maxProductDifference(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> solution.maxProductDifference(new int[] {1, 2, 3}));
    }
}
