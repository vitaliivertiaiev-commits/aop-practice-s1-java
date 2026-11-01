package homework.h10;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    char[] characters = "hello".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("olleh".toCharArray());
  }

  @Test
  void exampleTwo() {
    char[] characters = "Hannah".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("hannaH".toCharArray());
  }

  @Test
  void emptyArray() {
    char[] characters = new char[0];
    solution.reverseString(characters);
    assertThat(characters).isEmpty();
  }

  @Test
  void singleCharacter() {
    char[] characters = {'a'};
    solution.reverseString(characters);
    assertThat(characters).containsExactly('a');
  }

  @Test
  void twoCharacters() {
    char[] characters = {'a', 'b'};
    solution.reverseString(characters);
    assertThat(characters).containsExactly('b', 'a');
  }

  @Test
  void oddLength() {
    char[] characters = "abcde".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("edcba".toCharArray());
  }

  @Test
  void evenLength() {
    char[] characters = "abcd".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("dcba".toCharArray());
  }

  @Test
  void repeatedCharacters() {
    char[] characters = "aaaaaa".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("aaaaaa".toCharArray());
  }

  @Test
  void palindrome() {
    char[] characters = "abba".toCharArray();
    solution.reverseString(characters);
    assertThat(characters).containsExactly("abba".toCharArray());
  }

  @Test
  void recursiveBlockBoundaries() {
    for (int length : new int[] {127, 128, 129, 130, 131, 256, 257}) {
      char[] characters = new char[length];
      char[] expected = new char[length];
      for (int index = 0; index < length; index++) {
        characters[index] = (char) ('!' + index % 94);
        expected[length - 1 - index] = characters[index];
      }
      solution.reverseString(characters);
      assertThat(characters).containsExactly(expected);
    }
  }

  @Test
  void maximumLengthWithoutStackOverflow() {
    int length = 100000;
    char[] characters = new char[length];
    char[] expected = new char[length];
    for (int index = 0; index < length; index++) {
      characters[index] = (char) ('!' + index % 94);
      expected[length - 1 - index] = characters[index];
    }
    solution.reverseString(characters);
    assertThat(characters).containsExactly(expected);
  }

  @Test
  void allSmallArraysMatchTheStandardReverse() {
    char[] alphabet = {'a', 'B', '1'};
    for (int length = 0; length <= 6; length++) {
      int combinations = (int) Math.pow(alphabet.length, length);
      for (int code = 0; code < combinations; code++) {
        int value = code;
        char[] characters = new char[length];
        for (int index = 0; index < length; index++) {
          characters[index] = alphabet[value % alphabet.length];
          value /= alphabet.length;
        }
        char[] expected =
            new StringBuilder(new String(characters)).reverse().toString().toCharArray();
        solution.reverseString(characters);
        assertThat(characters).containsExactly(expected);
      }
    }
  }
}
