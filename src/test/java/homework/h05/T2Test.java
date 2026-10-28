package homework.h05;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void squaresMixedSortedValues() {
        assertArrayEquals(
                new int[] {0, 1, 9, 16, 100},
                solution.sortedSquares(new int[] {-4, -1, 0, 3, 10}));
        assertArrayEquals(
                new int[] {4, 9, 9, 49, 121},
                solution.sortedSquares(new int[] {-7, -3, 2, 3, 11}));
    }

    @Test
    void handlesEmptySingleAndRepeatedValues() {
        assertArrayEquals(new int[0], solution.sortedSquares(new int[0]));
        assertArrayEquals(new int[] {0}, solution.sortedSquares(new int[] {0}));
        assertArrayEquals(
                new int[] {1, 1, 4, 4},
                solution.sortedSquares(new int[] {-2, -1, 1, 2}));
    }

    @Test
    void doesNotChangeInputAndRejectsNull() {
        int[] input = {-3, -1, 2};
        solution.sortedSquares(input);
        assertArrayEquals(new int[] {-3, -1, 2}, input);
        assertThrows(IllegalArgumentException.class, () -> solution.sortedSquares(null));
    }
}
