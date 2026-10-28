package homework.h06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T2Test {
    private final T2 solution = new T2();

    @Test
    void recognizesValidAndInvalidPalindromes() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(solution.isPalindrome("race a car"));
        assertTrue(solution.isPalindrome(" "));
    }

    @Test
    void ignoresPunctuationAndHandlesUnicodeCodePoints() {
        assertTrue(solution.isPalindrome(".,"));
        assertTrue(solution.isPalindrome("А роза упала на лапу Азора"));
        assertTrue(solution.isPalindrome("👨‍👩‍👧"));
    }

    @Test
    void rejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> solution.isPalindrome(null));
    }
}
