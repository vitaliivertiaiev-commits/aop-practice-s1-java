package homework.h01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.countOdds(3, 7)).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.countOdds(8, 10)).isEqualTo(1);
  }

  @Test
  void minimumAllowedBounds() {
    assertThat(solution.countOdds(0, 0)).isZero();
  }

  @Test
  void fullAllowedRange() {
    assertThat(solution.countOdds(0, 1_000_000_000)).isEqualTo(500_000_000);
  }

  @Test
  void maximumAllowedBounds() {
    assertThat(solution.countOdds(1_000_000_000, 1_000_000_000)).isZero();
  }

  @Test
  void singleOddNumber() {
    assertThat(solution.countOdds(1, 1)).isEqualTo(1);
  }

  @Test
  void evenAndOddEndpoints() {
    assertThat(solution.countOdds(0, 1)).isEqualTo(1);
    assertThat(solution.countOdds(2, 5)).isEqualTo(2);
    assertThat(solution.countOdds(3, 6)).isEqualTo(2);
  }

  @Test
  void rejectsNegativeLowerBound() {
    assertThatThrownBy(() -> solution.countOdds(-1, 3))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsReversedBounds() {
    assertThatThrownBy(() -> solution.countOdds(5, 4)).isInstanceOf(IllegalArgumentException.class);
  }
}
