package homework.h08;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1})).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 0, 1})).isEqualTo(2);
  }

  @Test
  void minimumLengthWithZero() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {0})).isZero();
  }

  @Test
  void minimumLengthWithOne() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {1})).isEqualTo(1);
  }

  @Test
  void longestRunAtStart() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {1, 1, 1, 0, 1, 0})).isEqualTo(3);
  }

  @Test
  void longestRunAtEnd() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {0, 1, 0, 1, 1})).isEqualTo(2);
  }

  @Test
  void longestRunInMiddle() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {1, 0, 1, 1, 1, 0, 1})).isEqualTo(3);
  }

  @Test
  void maximumLengthWithOnes() {
    int[] numbers = new int[100_000];
    Arrays.fill(numbers, 1);
    assertThat(solution.findMaxConsecutiveOnes(numbers)).isEqualTo(100_000);
  }

  @Test
  void maximumLengthWithZeros() {
    assertThat(solution.findMaxConsecutiveOnes(new int[100_000])).isZero();
  }

  @Test
  void emptyArray() {
    assertThat(solution.findMaxConsecutiveOnes(new int[0])).isZero();
  }

  @Test
  void alternatingValues() {
    assertThat(solution.findMaxConsecutiveOnes(new int[] {0, 1, 0, 1, 0, 1})).isEqualTo(1);
  }

  @Test
  void doesNotModifyInput() {
    int[] numbers = {1, 1, 0, 1};
    int[] original = numbers.clone();
    assertThat(solution.findMaxConsecutiveOnes(numbers)).isEqualTo(2);
    assertThat(numbers).containsExactly(original);
  }
}
