package homework.h01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.smallestEvenMultiple(5)).isEqualTo(10);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.smallestEvenMultiple(6)).isEqualTo(6);
  }

  @Test
  void minimumAllowedNumber() {
    assertThat(solution.smallestEvenMultiple(1)).isEqualTo(2);
  }

  @Test
  void maximumAllowedNumber() {
    assertThat(solution.smallestEvenMultiple(150)).isEqualTo(150);
  }

  @Test
  void largestAllowedOddNumber() {
    assertThat(solution.smallestEvenMultiple(149)).isEqualTo(298);
  }

  @Test
  void rejectsZero() {
    assertThatThrownBy(() -> solution.smallestEvenMultiple(0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.smallestEvenMultiple(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
