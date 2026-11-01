package homework.h10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void firstCharacter() {
    assertThat(solution.kthCharacter(1)).isEqualTo('a');
  }

  @Test
  void exampleOne() {
    assertThat(solution.kthCharacter(5)).isEqualTo('b');
  }

  @Test
  void exampleTwo() {
    assertThat(solution.kthCharacter(10)).isEqualTo('c');
  }

  @Test
  void secondCharacter() {
    assertThat(solution.kthCharacter(2)).isEqualTo('b');
  }

  @Test
  void firstCharacterAfterDoubling() {
    assertThat(solution.kthCharacter(3)).isEqualTo('b');
  }

  @Test
  void fourthCharacter() {
    assertThat(solution.kthCharacter(4)).isEqualTo('c');
  }

  @Test
  void eighthCharacter() {
    assertThat(solution.kthCharacter(8)).isEqualTo('d');
  }

  @Test
  void largestPowerOfTwoWithinConstraints() {
    assertThat(solution.kthCharacter(256)).isEqualTo('i');
  }

  @Test
  void positionAfterLargestPowerOfTwo() {
    assertThat(solution.kthCharacter(257)).isEqualTo('b');
  }

  @Test
  void maximumPosition() {
    assertThat(solution.kthCharacter(500)).isEqualTo('h');
  }

  @Test
  void allValidPositionsMatchTheConstructedWord() {
    String word = "a";
    while (word.length() < 500) {
      StringBuilder next = new StringBuilder(word);
      for (int index = 0; index < word.length(); index++) {
        next.append((char) ('a' + (word.charAt(index) - 'a' + 1) % 26));
      }
      word = next.toString();
    }
    for (int position = 1; position <= 500; position++) {
      assertThat(solution.kthCharacter(position)).isEqualTo(word.charAt(position - 1));
    }
  }

  @Test
  void allValidPositionsMatchTheBitCount() {
    for (int position = 1; position <= 500; position++) {
      assertThat(solution.kthCharacter(position))
          .isEqualTo((char) ('a' + Integer.bitCount(position - 1)));
    }
  }
}
