package homework.h04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.hammingDistance(1, 4)).isEqualTo(2);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.hammingDistance(3, 1)).isEqualTo(1);
  }

  @Test
  void minimumAllowedInputs() {
    assertThat(solution.hammingDistance(0, 0)).isZero();
  }

  @Test
  void maximumAllowedInputs() {
    assertThat(solution.hammingDistance(Integer.MAX_VALUE, Integer.MAX_VALUE)).isZero();
  }

  @Test
  void allAllowedBitsDiffer() {
    assertThat(solution.hammingDistance(0, Integer.MAX_VALUE)).isEqualTo(31);
  }

  @Test
  void argumentOrderDoesNotMatter() {
    assertThat(solution.hammingDistance(Integer.MAX_VALUE, 0)).isEqualTo(31);
  }

  @Test
  void onlyHighestAllowedBitDiffers() {
    assertThat(solution.hammingDistance(0, 1 << 30)).isEqualTo(1);
  }
}
