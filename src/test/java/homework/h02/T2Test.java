package homework.h02;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void zeroAndNumbersWithoutTrailingZeroRemainTheSame() {
        assertTrue(solution.isSameAfterReversals(0));
        assertTrue(solution.isSameAfterReversals(1));
        assertTrue(solution.isSameAfterReversals(526));
        assertTrue(solution.isSameAfterReversals(1001));
    }

    @Test
    void positiveNumbersWithTrailingZeroChangeAfterDoubleReversal() {
        assertFalse(solution.isSameAfterReversals(10));
        assertFalse(solution.isSameAfterReversals(100));
        assertFalse(solution.isSameAfterReversals(1800));
    }

    @Test
    void rejectsNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> solution.isSameAfterReversals(-1));
    }
}
