package homework.h07;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.numberOfSteps(14)).isEqualTo(6);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.numberOfSteps(8)).isEqualTo(4);
  }

  @Test
  void exampleThree() {
    assertThat(solution.numberOfSteps(123)).isEqualTo(12);
  }

  @Test
  void minimumAllowedNumber() {
    assertThat(solution.numberOfSteps(0)).isZero();
  }

  @Test
  void maximumAllowedNumber() {
    assertThat(solution.numberOfSteps(1_000_000)).isEqualTo(26);
  }

  @Test
  void singleOddStep() {
    assertThat(solution.numberOfSteps(1)).isEqualTo(1);
  }

  @Test
  void evenThenOddStep() {
    assertThat(solution.numberOfSteps(2)).isEqualTo(2);
  }

  @Test
  void alternatesOddAndEvenSteps() {
    assertThat(solution.numberOfSteps(3)).isEqualTo(3);
    assertThat(solution.numberOfSteps(15)).isEqualTo(7);
  }

  @Test
  void largestAllowedPowerOfTwo() {
    assertThat(solution.numberOfSteps(524_288)).isEqualTo(20);
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.numberOfSteps(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
