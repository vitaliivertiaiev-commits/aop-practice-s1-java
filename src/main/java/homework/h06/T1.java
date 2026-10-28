package homework.h06;

import java.util.HashMap;
import java.util.Map;

// LeetCode 242: Valid Anagram
// https://leetcode.com/problems/valid-anagram/
public class T1 {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) {
            throw new IllegalArgumentException("Input strings must not be null");
        }

        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int index = 0; index < s.length(); ) {
            int codePoint = s.codePointAt(index);
            frequencies.merge(codePoint, 1, Integer::sum);
            index += Character.charCount(codePoint);
        }

        for (int index = 0; index < t.length(); ) {
            int codePoint = t.codePointAt(index);
            Integer count = frequencies.get(codePoint);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                frequencies.remove(codePoint);
            } else {
                frequencies.put(codePoint, count - 1);
            }
            index += Character.charCount(codePoint);
        }

        return frequencies.isEmpty();
    }
}
