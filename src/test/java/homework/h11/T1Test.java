package homework.h11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.missingNumber(new int[] {3, 0, 1})).isEqualTo(2);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.missingNumber(new int[] {0, 1})).isEqualTo(2);
  }

  @Test
  void exampleThree() {
    assertThat(solution.missingNumber(new int[] {9, 6, 4, 2, 3, 5, 7, 0, 1})).isEqualTo(8);
  }

  @Test
  void missingZero() {
    assertThat(solution.missingNumber(new int[] {1, 2, 3})).isZero();
  }

  @Test
  void singleElement() {
    assertThat(solution.missingNumber(new int[] {0})).isEqualTo(1);
  }

  @Test
  void missingNumberInsideRange() {
    assertThat(solution.missingNumber(new int[] {0, 1, 3, 4})).isEqualTo(2);
  }

  @Test
  void maximumInputLength() {
    int[] numbers = IntStream.range(0, 10000).toArray();
    assertThat(solution.missingNumber(numbers)).isEqualTo(10000);
  }

  @Test
  void doesNotModifyInput() {
    int[] numbers = {4, 0, 3, 1};
    assertThat(solution.missingNumber(numbers)).isEqualTo(2);
    assertThat(numbers).containsExactly(4, 0, 3, 1);
  }

  @Test
  void allMissingValuesMatchTheExpectedNumber() {
    for (int length = 1; length <= 100; length++) {
      for (int missing = 0; missing <= length; missing++) {
        int omitted = missing;
        int[] numbers = IntStream.range(0, length).filter(value -> value != omitted).toArray();
        assertThat(solution.missingNumber(numbers))
            .as("length=%s, missing=%s", length, missing)
            .isEqualTo(missing);
      }
    }
  }
}
