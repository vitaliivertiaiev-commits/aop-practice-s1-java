package homework.h03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.within;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.average(new int[] {4000, 3000, 1000, 2000})).isEqualTo(2500.0);
  }

  @Test
  void exampleTwoAndMinimumAllowedLength() {
    assertThat(solution.average(new int[] {1000, 2000, 3000})).isEqualTo(2000.0);
  }

  @Test
  void minimumAndMaximumAllowedSalary() {
    assertThat(solution.average(new int[] {1000, 2000, 1_000_000})).isEqualTo(2000.0);
  }

  @Test
  void maximumAllowedLength() {
    int[] salary = IntStream.rangeClosed(1, 100).map(amount -> amount * 1000).toArray();
    assertThat(solution.average(salary)).isEqualTo(50_500.0);
  }

  @Test
  void preservesFractionalAverage() {
    assertThat(solution.average(new int[] {1000, 2000, 3000, 5000, 9000}))
        .isCloseTo(10_000.0 / 3, within(1e-9));
  }

  @Test
  void orderDoesNotMatterAndInputIsNotModified() {
    int[] salary = {1_000_000, 3000, 1000, 2000};
    assertThat(solution.average(salary)).isEqualTo(2500.0);
    assertThat(salary).containsExactly(1_000_000, 3000, 1000, 2000);
  }

  @Test
  void repeatedExtremesRemoveOnlyOneOccurrence() {
    assertThat(solution.average(new int[] {1000, 2000, 3000, 4000, 4000})).isEqualTo(3000.0);
  }

  @Test
  void rejectsNull() {
    assertThatThrownBy(() -> solution.average(null)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsEmptyArray() {
    assertThatThrownBy(() -> solution.average(new int[0]))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsTooFewSalaries() {
    assertThatThrownBy(() -> solution.average(new int[] {1000, 2000}))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
