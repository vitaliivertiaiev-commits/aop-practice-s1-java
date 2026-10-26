package homework.h01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void returnsNWhenNIsEven() {
        assertEquals(2, solution.smallestEvenMultiple(2));
        assertEquals(150, solution.smallestEvenMultiple(150));
    }

    @Test
    void doublesNOdd() {
        assertEquals(2, solution.smallestEvenMultiple(1));
        assertEquals(10, solution.smallestEvenMultiple(5));
    }

    @Test
    void rejectsNonPositiveN() {
        assertThrows(IllegalArgumentException.class, () -> solution.smallestEvenMultiple(0));
    }
}
