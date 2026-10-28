package homework.h06;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class T1Test {
    private final T1 solution = new T1();

    @Test
    void recognizesAnagramsAndNonAnagrams() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
        assertFalse(solution.isAnagram("rat", "car"));
        assertFalse(solution.isAnagram("ab", "a"));
    }

    @Test
    void countsRepeatedAndSupplementaryCodePoints() {
        assertTrue(solution.isAnagram("aabbcc", "abcabc"));
        assertTrue(solution.isAnagram("👨‍👩‍👧ab", "ba👨‍👩‍👧"));
        assertFalse(solution.isAnagram("👨", "👩"));
    }

    @Test
    void handlesEmptyStringsAndRejectsNull() {
        assertTrue(solution.isAnagram("", ""));
        assertThrows(IllegalArgumentException.class, () -> solution.isAnagram(null, ""));
        assertThrows(IllegalArgumentException.class, () -> solution.isAnagram("", null));
    }
}
