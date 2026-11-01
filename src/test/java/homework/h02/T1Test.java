package homework.h02;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.addDigits(38)).isEqualTo(2);
  }

  @Test
  void exampleTwoAndMinimumAllowedNumber() {
    assertThat(solution.addDigits(0)).isZero();
  }

  @Test
  void maximumAllowedNumber() {
    assertThat(solution.addDigits(Integer.MAX_VALUE)).isEqualTo(1);
  }

  @Test
  void singleDigit() {
    assertThat(solution.addDigits(1)).isEqualTo(1);
    assertThat(solution.addDigits(9)).isEqualTo(9);
  }

  @Test
  void multipleOfNine() {
    assertThat(solution.addDigits(99)).isEqualTo(9);
  }

  @Test
  void numberEndingInZero() {
    assertThat(solution.addDigits(10)).isEqualTo(1);
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.addDigits(-1)).isInstanceOf(IllegalArgumentException.class);
  }
}
