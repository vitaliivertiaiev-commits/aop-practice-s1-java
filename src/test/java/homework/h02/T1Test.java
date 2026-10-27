package homework.h02;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void computesDigitalRoots() {
        assertEquals(2, solution.addDigits(38));
        assertEquals(1, solution.addDigits(10));
        assertEquals(9, solution.addDigits(9));
        assertEquals(9, solution.addDigits(99));
    }

    @Test
    void handlesZeroAndLargestInt() {
        assertEquals(0, solution.addDigits(0));
        assertEquals(1, solution.addDigits(Integer.MAX_VALUE));
    }

    @Test
    void rejectsNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> solution.addDigits(-1));
    }
}
