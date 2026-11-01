package homework.h09;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.numIdenticalPairs(new int[] {1, 2, 3, 1, 1, 3})).isEqualTo(4);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.numIdenticalPairs(new int[] {1, 1, 1, 1})).isEqualTo(6);
  }

  @Test
  void exampleThree() {
    assertThat(solution.numIdenticalPairs(new int[] {1, 2, 3})).isZero();
  }

  @Test
  void singleElement() {
    assertThat(solution.numIdenticalPairs(new int[] {100})).isZero();
  }

  @Test
  void emptyArray() {
    assertThat(solution.numIdenticalPairs(new int[0])).isZero();
  }

  @Test
  void maximumLengthWithEqualMaximumValues() {
    int[] numbers = new int[100];
    Arrays.fill(numbers, 100);
    assertThat(solution.numIdenticalPairs(numbers)).isEqualTo(4950);
  }

  @Test
  void allDistinctValues() {
    assertThat(solution.numIdenticalPairs(IntStream.rangeClosed(1, 100).toArray())).isZero();
  }

  @Test
  void boundaryValues() {
    assertThat(solution.numIdenticalPairs(new int[] {1, 100, 1, 100})).isEqualTo(2);
  }

  @Test
  void singlePair() {
    assertThat(solution.numIdenticalPairs(new int[] {2, 2})).isEqualTo(1);
  }

  @Test
  void interleavedPairs() {
    assertThat(solution.numIdenticalPairs(new int[] {1, 2, 1, 2, 1})).isEqualTo(4);
  }

  @Test
  void doesNotModifyInput() {
    int[] numbers = {3, 1, 3, 2, 1};
    assertThat(solution.numIdenticalPairs(numbers)).isEqualTo(2);
    assertThat(numbers).containsExactly(3, 1, 3, 2, 1);
  }

  @Test
  void allSmallInputsMatchDirectCounting() {
    for (int combination = 0; combination < 1024; combination++) {
      int[] numbers = new int[5];
      int encoded = combination;
      for (int index = 0; index < numbers.length; index++) {
        numbers[index] = encoded % 4 + 1;
        encoded /= 4;
      }
      int expected = 0;
      for (int left = 0; left < numbers.length; left++) {
        for (int right = left + 1; right < numbers.length; right++) {
          if (numbers[left] == numbers[right]) {
            expected++;
          }
        }
      }
      assertThat(solution.numIdenticalPairs(numbers)).as("numbers=%s", numbers).isEqualTo(expected);
    }
  }
}
