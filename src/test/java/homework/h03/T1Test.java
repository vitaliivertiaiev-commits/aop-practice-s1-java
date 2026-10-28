package homework.h03;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void excludesMinimumAndMaximum() {
        assertEquals(2500.0, solution.average(new int[] {4000, 3000, 1000, 2000}));
        assertEquals(2000.0, solution.average(new int[] {1000, 2000, 3000}));
        assertEquals(10.0 / 3, solution.average(new int[] {1, 2, 3, 5, 9}), 1e-9);
    }

    @Test
    void handlesRepeatedMaximum() {
        assertEquals(3.0, solution.average(new int[] {1, 2, 3, 4, 4}));
    }

    @Test
    void rejectsTooFewSalaries() {
        assertThrows(IllegalArgumentException.class, () -> solution.average(new int[] {1000, 2000}));
    }
}
