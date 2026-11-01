package homework.h05;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.maxProductDifference(new int[] {5, 6, 2, 7, 4})).isEqualTo(34);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.maxProductDifference(new int[] {4, 2, 5, 9, 7, 4, 8})).isEqualTo(64);
  }

  @Test
  void minimumAllowedLengthAndValues() {
    assertThat(solution.maxProductDifference(new int[] {1, 1, 1, 1})).isZero();
  }

  @Test
  void maximumAllowedValues() {
    assertThat(solution.maxProductDifference(new int[] {1, 1, 10_000, 10_000}))
        .isEqualTo(99_999_999);
  }

  @Test
  void maximumAllowedLength() {
    int[] nums = new int[10_000];
    Arrays.fill(nums, 10_000);
    nums[0] = 1;
    nums[1] = 1;
    assertThat(solution.maxProductDifference(nums)).isEqualTo(99_999_999);
  }

  @Test
  void ascendingValuesExerciseAllExtremaUpdates() {
    assertThat(solution.maxProductDifference(new int[] {1, 2, 3, 4, 5})).isEqualTo(18);
  }

  @Test
  void descendingValuesExerciseAllExtremaUpdates() {
    assertThat(solution.maxProductDifference(new int[] {5, 4, 3, 2, 1})).isEqualTo(18);
  }

  @Test
  void doesNotModifyInput() {
    int[] nums = {1, 2, 4, 5};
    assertThat(solution.maxProductDifference(nums)).isEqualTo(18);
    assertThat(nums).containsExactly(1, 2, 4, 5);
  }

  @Test
  void rejectsNull() {
    assertThatThrownBy(() -> solution.maxProductDifference(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsEmptyArray() {
    assertThatThrownBy(() -> solution.maxProductDifference(new int[0]))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsTooFewNumbers() {
    assertThatThrownBy(() -> solution.maxProductDifference(new int[] {1, 2, 3}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
