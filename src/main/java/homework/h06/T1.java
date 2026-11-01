package homework.h06;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
public class T1 {
  public boolean isAnagram(String first, String second) {
    if (first == null || second == null) {
      throw new IllegalArgumentException("Input strings must not be null");
    }

    Map<Integer, Integer> frequencies = new HashMap<>();
    for (int index = 0; index < first.length(); ) {
      int codePoint = first.codePointAt(index);
      frequencies.merge(codePoint, 1, Integer::sum);
      index += Character.charCount(codePoint);
    }

    for (int index = 0; index < second.length(); ) {
      int codePoint = second.codePointAt(index);
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
