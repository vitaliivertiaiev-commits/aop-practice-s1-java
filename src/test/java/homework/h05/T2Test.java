package homework.h05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.sortedSquares(new int[] {-4, -1, 0, 3, 10}))
        .containsExactly(0, 1, 9, 16, 100);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.sortedSquares(new int[] {-7, -3, 2, 3, 11}))
        .containsExactly(4, 9, 9, 49, 121);
  }

  @Test
  void minimumAllowedLength() {
    assertThat(solution.sortedSquares(new int[] {0})).containsExactly(0);
  }

  @Test
  void minimumAndMaximumAllowedValues() {
    assertThat(solution.sortedSquares(new int[] {-10_000, 0, 10_000}))
        .containsExactly(0, 100_000_000, 100_000_000);
  }

  @Test
  void maximumAllowedLength() {
    int[] nums = new int[10_000];
    Arrays.fill(nums, -10_000);
    int[] expected = new int[10_000];
    Arrays.fill(expected, 100_000_000);
    assertThat(solution.sortedSquares(nums)).containsExactly(expected);
  }

  @Test
  void emptyArray() {
    assertThat(solution.sortedSquares(new int[0])).isEmpty();
  }

  @Test
  void repeatedValues() {
    assertThat(solution.sortedSquares(new int[] {-2, -1, 1, 2})).containsExactly(1, 1, 4, 4);
  }

  @Test
  void onlyNegativeValues() {
    assertThat(solution.sortedSquares(new int[] {-5, -3, -1})).containsExactly(1, 9, 25);
  }

  @Test
  void onlyPositiveValues() {
    assertThat(solution.sortedSquares(new int[] {1, 3, 5})).containsExactly(1, 9, 25);
  }

  @Test
  void doesNotModifyInput() {
    int[] nums = {-3, -1, 2};
    assertThat(solution.sortedSquares(nums)).containsExactly(1, 4, 9);
    assertThat(nums).containsExactly(-3, -1, 2);
  }

  @Test
  void rejectsNull() {
    assertThatThrownBy(() -> solution.sortedSquares(null))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
