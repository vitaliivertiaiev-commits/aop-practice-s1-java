package homework.h12;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.heightChecker(new int[] {1, 1, 4, 2, 1, 3})).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.heightChecker(new int[] {5, 1, 2, 3, 4})).isEqualTo(5);
  }

  @Test
  void alreadySorted() {
    assertThat(solution.heightChecker(new int[] {1, 2, 3, 4, 5})).isZero();
  }

  @Test
  void identicalHeights() {
    assertThat(solution.heightChecker(new int[] {7, 7, 7, 7})).isZero();
  }

  @Test
  void doesNotModifyInput() {
    int[] heights = {3, 1, 2};
    assertThat(solution.heightChecker(heights)).isEqualTo(3);
    assertThat(heights).containsExactly(3, 1, 2);
  }

  @Test
  void maximumInputLength() {
    int[] heights = new int[100];
    Arrays.fill(heights, 100);
    assertThat(solution.heightChecker(heights)).isZero();
  }
}
