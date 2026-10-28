package homework.h03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void computesDivisibleAndNonDivisibleDifference() {
        assertEquals(19, solution.differenceOfSums(10, 3));
        assertEquals(15, solution.differenceOfSums(5, 6));
    }

    @Test
    void handlesOneAndAllDivisibleNumbers() {
        assertEquals(1, solution.differenceOfSums(1, 2));
        assertEquals(-6, solution.differenceOfSums(3, 1));
    }

    @Test
    void rejectsInvalidDivisor() {
        assertThrows(IllegalArgumentException.class, () -> solution.differenceOfSums(10, 0));
    }
}
