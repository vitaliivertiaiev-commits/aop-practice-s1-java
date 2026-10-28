package homework.h04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void countsDifferentBits() {
        assertEquals(2, solution.hammingDistance(1, 4));
        assertEquals(1, solution.hammingDistance(3, 1));
        assertEquals(2, solution.hammingDistance(31, 14));
    }

    @Test
    void identicalNumbersHaveNoDifferentBits() {
        assertEquals(0, solution.hammingDistance(0, 0));
        assertEquals(0, solution.hammingDistance(7, 7));
    }
}
