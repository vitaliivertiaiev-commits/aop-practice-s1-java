package homework.h04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.findComplement(5)).isEqualTo(2);
  }

  @Test
  void exampleTwoAndMinimumAllowedNumber() {
    assertThat(solution.findComplement(1)).isZero();
  }

  @Test
  void maximumAllowedNumber() {
    assertThat(solution.findComplement(Integer.MAX_VALUE)).isZero();
  }

  @Test
  void smallestPowerOfTwoAboveOne() {
    assertThat(solution.findComplement(2)).isEqualTo(1);
  }

  @Test
  void largestAllowedPowerOfTwo() {
    assertThat(solution.findComplement(1 << 30)).isEqualTo(1_073_741_823);
  }

  @Test
  void allSignificantBitsAreSet() {
    assertThat(solution.findComplement(7)).isZero();
  }

  @Test
  void rejectsZero() {
    assertThatThrownBy(() -> solution.findComplement(0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.findComplement(-1))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
