package homework.h13;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.maximumCount(new int[] {-2, -1, -1, 1, 2, 3})).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.maximumCount(new int[] {-3, -2, -1, 0, 0, 1, 2})).isEqualTo(3);
  }

  @Test
  void countsOnlyPositiveNumbers() {
    assertThat(solution.maximumCount(new int[] {5, 20, 66, 1314})).isEqualTo(4);
  }

  @Test
  void countsOnlyNegativeNumbers() {
    assertThat(solution.maximumCount(new int[] {-4, -3, -2, -1})).isEqualTo(4);
  }

  @Test
  void ignoresZerosAndHandlesEqualCounts() {
    assertThat(solution.maximumCount(new int[] {-2, -1, 0, 0, 1})).isEqualTo(2);
  }

  @Test
  void handlesEmptyArray() {
    assertThat(solution.maximumCount(new int[] {})).isZero();
  }
}
