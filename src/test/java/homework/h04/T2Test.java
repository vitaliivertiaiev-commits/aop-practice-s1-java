package homework.h04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void flipsOnlySignificantBits() {
        assertEquals(2, solution.findComplement(5));
        assertEquals(0, solution.findComplement(1));
        assertEquals(1, solution.findComplement(2));
    }

    @Test
    void handlesPowersOfTwoAndMaximumPositiveInt() {
        assertEquals(0, solution.findComplement(7));
        assertEquals(1_073_741_823, solution.findComplement(1_073_741_824));
        assertEquals(0, solution.findComplement(Integer.MAX_VALUE));
    }

    @Test
    void rejectsZero() {
        assertThrows(IllegalArgumentException.class, () -> solution.findComplement(0));
    }
}
