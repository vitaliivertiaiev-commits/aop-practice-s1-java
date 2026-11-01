package homework.h08;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.countPairs(List.of(-1, 1, 2, 3, 1), 2)).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.countPairs(List.of(-6, 2, 5, -2, -7, -1, 3), -2)).isEqualTo(10);
  }

  @Test
  void minimumLength() {
    assertThat(solution.countPairs(List.of(-50), 50)).isZero();
  }

  @Test
  void emptyList() {
    assertThat(solution.countPairs(List.of(), 0)).isZero();
  }

  @Test
  void excludesSumEqualToTarget() {
    assertThat(solution.countPairs(List.of(1, 2), 3)).isZero();
  }

  @Test
  void countsPairsOfEqualValuesAtDifferentIndices() {
    assertThat(solution.countPairs(List.of(1, 1, 1, 1), 3)).isEqualTo(6);
  }

  @Test
  void maximumLengthAndMinimumValuesAndTarget() {
    assertThat(solution.countPairs(Collections.nCopies(50, -50), -50)).isEqualTo(1225);
  }

  @Test
  void maximumLengthAndMaximumValuesAndTarget() {
    assertThat(solution.countPairs(Collections.nCopies(50, 50), 50)).isZero();
  }

  @Test
  void strictComparisonAtMaximumTarget() {
    assertThat(solution.countPairs(List.of(25, 24, 26), 50)).isEqualTo(1);
  }

  @Test
  void strictComparisonAtMinimumTarget() {
    assertThat(solution.countPairs(List.of(-25, -24, -26), -50)).isEqualTo(1);
  }

  @Test
  void doesNotModifyInputOrder() {
    List<Integer> numbers = new ArrayList<>(List.of(3, -1, 2, 1, 1));
    assertThat(solution.countPairs(numbers, 2)).isEqualTo(3);
    assertThat(numbers).containsExactly(3, -1, 2, 1, 1);
  }

  @Test
  void allSmallInputsMatchDirectPairCounting() {
    for (int combination = 0; combination < 3125; combination++) {
      List<Integer> numbers = new ArrayList<>();
      int encodedValues = combination;
      for (int index = 0; index < 5; index++) {
        numbers.add(encodedValues % 5 - 2);
        encodedValues /= 5;
      }
      for (int target = -3; target <= 3; target++) {
        int expectedCount = 0;
        for (int leftIndex = 0; leftIndex < numbers.size(); leftIndex++) {
          for (int rightIndex = leftIndex + 1; rightIndex < numbers.size(); rightIndex++) {
            if (numbers.get(leftIndex) + numbers.get(rightIndex) < target) {
              expectedCount++;
            }
          }
        }
        assertThat(solution.countPairs(numbers, target))
            .as("numbers=%s, target=%d", numbers, target)
            .isEqualTo(expectedCount);
      }
    }
  }
}
