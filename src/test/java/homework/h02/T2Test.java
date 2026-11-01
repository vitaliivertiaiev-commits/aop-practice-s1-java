package homework.h02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.isSameAfterReversals(526)).isTrue();
  }

  @Test
  void exampleTwo() {
    assertThat(solution.isSameAfterReversals(1800)).isFalse();
  }

  @Test
  void exampleThreeAndMinimumAllowedNumber() {
    assertThat(solution.isSameAfterReversals(0)).isTrue();
  }

  @Test
  void maximumAllowedNumber() {
    assertThat(solution.isSameAfterReversals(1_000_000)).isFalse();
  }

  @Test
  void singleDigit() {
    assertThat(solution.isSameAfterReversals(1)).isTrue();
  }

  @Test
  void internalZerosDoNotMatter() {
    assertThat(solution.isSameAfterReversals(1001)).isTrue();
  }

  @Test
  void singleTrailingZeroChangesTheNumber() {
    assertThat(solution.isSameAfterReversals(10)).isFalse();
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.isSameAfterReversals(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
