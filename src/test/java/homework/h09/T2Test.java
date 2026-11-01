package homework.h09;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.kidsWithCandies(new int[] {2, 3, 5, 1, 3}, 3))
        .containsExactly(true, true, true, false, true);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.kidsWithCandies(new int[] {4, 2, 1, 1, 2}, 1))
        .containsExactly(true, false, false, false, false);
  }

  @Test
  void exampleThree() {
    assertThat(solution.kidsWithCandies(new int[] {12, 1, 12}, 10))
        .containsExactly(true, false, true);
  }

  @Test
  void emptyArray() {
    assertThat(solution.kidsWithCandies(new int[0], 1)).isEmpty();
  }

  @Test
  void singleChild() {
    assertThat(solution.kidsWithCandies(new int[] {1}, 1)).containsExactly(true);
  }

  @Test
  void equalCounts() {
    assertThat(solution.kidsWithCandies(new int[] {2, 2, 2}, 1)).containsExactly(true, true, true);
  }

  @Test
  void reachingMaximumIsEnough() {
    assertThat(solution.kidsWithCandies(new int[] {1, 4}, 3)).containsExactly(true, true);
  }

  @Test
  void extraCandiesAreInsufficient() {
    assertThat(solution.kidsWithCandies(new int[] {1, 5}, 1)).containsExactly(false, true);
  }

  @Test
  void maximumLengthAndValues() {
    int[] candies = new int[100];
    Arrays.fill(candies, 100);
    assertThat(solution.kidsWithCandies(candies, 50)).hasSize(100).containsOnly(true);
  }

  @Test
  void minimumAndMaximumCounts() {
    assertThat(solution.kidsWithCandies(new int[] {1, 100}, 1)).containsExactly(false, true);
  }

  @Test
  void doesNotModifyInput() {
    int[] candies = {3, 1, 5};
    assertThat(solution.kidsWithCandies(candies, 2)).containsExactly(true, false, true);
    assertThat(candies).containsExactly(3, 1, 5);
  }

  @Test
  void allSmallInputsMatchDirectComparison() {
    for (int combination = 0; combination < 256; combination++) {
      int[] candies = new int[4];
      int encoded = combination;
      for (int index = 0; index < candies.length; index++) {
        candies[index] = encoded % 4 + 1;
        encoded /= 4;
      }
      for (int extra = 1; extra <= 4; extra++) {
        List<Boolean> expected = new ArrayList<>();
        for (int count : candies) {
          boolean greatest = true;
          for (int other : candies) {
            if (count + extra < other) {
              greatest = false;
            }
          }
          expected.add(greatest);
        }
        assertThat(solution.kidsWithCandies(candies, extra))
            .as("candies=%s, extra=%d", candies, extra)
            .containsExactlyElementsOf(expected);
      }
    }
  }
}
