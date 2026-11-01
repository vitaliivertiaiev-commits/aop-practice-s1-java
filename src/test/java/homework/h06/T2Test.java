package homework.h06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.isPalindrome("A man, a plan, a canal: Panama")).isTrue();
  }

  @Test
  void exampleTwo() {
    assertThat(solution.isPalindrome("race a car")).isFalse();
  }

  @Test
  void exampleThree() {
    assertThat(solution.isPalindrome(" ")).isTrue();
  }

  @Test
  void minimumAllowedLengthWithLetter() {
    assertThat(solution.isPalindrome("a")).isTrue();
  }

  @Test
  void maximumAllowedLength() {
    assertThat(solution.isPalindrome("a".repeat(200_000))).isTrue();
  }

  @Test
  void emptyString() {
    assertThat(solution.isPalindrome("")).isTrue();
  }

  @Test
  void onlyPunctuation() {
    assertThat(solution.isPalindrome(".,!")).isTrue();
  }

  @Test
  void leadingAndTrailingPunctuation() {
    assertThat(solution.isPalindrome("!a")).isTrue();
    assertThat(solution.isPalindrome("a!")).isTrue();
  }

  @Test
  void comparisonIgnoresCaseButNotDigits() {
    assertThat(solution.isPalindrome("Aa")).isTrue();
    assertThat(solution.isPalindrome("0P")).isFalse();
    assertThat(solution.isPalindrome("1a1")).isTrue();
  }

  @Test
  void unicodeLetters() {
    assertThat(solution.isPalindrome("А роза упала на лапу Азора")).isTrue();
  }

  @Test
  void supplementaryLettersAndEmoji() {
    assertThat(solution.isPalindrome("𐐀a𐐨")).isTrue();
    assertThat(solution.isPalindrome("👨‍👩‍👧")).isTrue();
    assertThat(solution.isPalindrome("a👨")).isTrue();
  }

  @Test
  void rejectsNull() {
    assertThatThrownBy(() -> solution.isPalindrome(null))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
