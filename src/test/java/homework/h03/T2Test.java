package homework.h03;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.differenceOfSums(10, 3)).isEqualTo(19);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.differenceOfSums(5, 6)).isEqualTo(15);
  }

  @Test
  void exampleThree() {
    assertThat(solution.differenceOfSums(5, 1)).isEqualTo(-15);
  }

  @Test
  void minimumAllowedInputs() {
    assertThat(solution.differenceOfSums(1, 1)).isEqualTo(-1);
  }

  @Test
  void maximumAllowedInputs() {
    assertThat(solution.differenceOfSums(1000, 1000)).isEqualTo(498_500);
  }

  @Test
  void maximumLimitWithMinimumDivisor() {
    assertThat(solution.differenceOfSums(1000, 1)).isEqualTo(-500_500);
  }

  @Test
  void minimumLimitWithMaximumDivisor() {
    assertThat(solution.differenceOfSums(1, 1000)).isEqualTo(1);
  }

  @Test
  void zeroLimitHasEmptySum() {
    assertThat(solution.differenceOfSums(0, 1)).isZero();
  }

  @Test
  void rejectsNegativeLimit() {
    assertThatThrownBy(() -> solution.differenceOfSums(-1, 1))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsZeroDivisor() {
    assertThatThrownBy(() -> solution.differenceOfSums(10, 0))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
