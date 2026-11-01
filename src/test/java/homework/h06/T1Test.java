package homework.h06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.isAnagram("anagram", "nagaram")).isTrue();
  }

  @Test
  void exampleTwo() {
    assertThat(solution.isAnagram("rat", "car")).isFalse();
  }

  @Test
  void minimumAllowedLength() {
    assertThat(solution.isAnagram("a", "a")).isTrue();
    assertThat(solution.isAnagram("a", "z")).isFalse();
  }

  @Test
  void maximumAllowedLength() {
    String first = "a".repeat(25_000) + "z".repeat(25_000);
    String second = "z".repeat(25_000) + "a".repeat(25_000);
    assertThat(solution.isAnagram(first, second)).isTrue();
  }

  @Test
  void repeatedCharactersMustHaveEqualCounts() {
    assertThat(solution.isAnagram("aabbcc", "abcabc")).isTrue();
    assertThat(solution.isAnagram("aab", "abb")).isFalse();
  }

  @Test
  void shorterSecondStringLeavesUnmatchedCharacters() {
    assertThat(solution.isAnagram("ab", "a")).isFalse();
  }

  @Test
  void longerSecondStringHasAnUnmatchedCharacter() {
    assertThat(solution.isAnagram("a", "ab")).isFalse();
  }

  @Test
  void emptyStrings() {
    assertThat(solution.isAnagram("", "")).isTrue();
    assertThat(solution.isAnagram("", "a")).isFalse();
    assertThat(solution.isAnagram("a", "")).isFalse();
  }

  @Test
  void supplementaryUnicodeCodePoints() {
    assertThat(solution.isAnagram("👨‍👩‍👧ab", "ba👨‍👩‍👧")).isTrue();
    assertThat(solution.isAnagram("👨", "👩")).isFalse();
  }

  @Test
  void rejectsNullFirstString() {
    assertThatThrownBy(() -> solution.isAnagram(null, "a"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsNullSecondString() {
    assertThatThrownBy(() -> solution.isAnagram("a", null))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
