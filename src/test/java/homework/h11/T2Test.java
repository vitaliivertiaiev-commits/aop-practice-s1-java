package homework.h11;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(solution.majorityElement(new int[] {3, 2, 3})).isEqualTo(3);
  }

  @Test
  void exampleTwo() {
    assertThat(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
  }

  @Test
  void singleElement() {
    assertThat(solution.majorityElement(new int[] {-7})).isEqualTo(-7);
  }

  @Test
  void majorityCanBeNegative() {
    assertThat(solution.majorityElement(new int[] {-1, -1, 2, -1, 3})).isEqualTo(-1);
  }

  @Test
  void majorityCanAppearAtTheEnd() {
    assertThat(solution.majorityElement(new int[] {1, 2, 3, 3, 3})).isEqualTo(3);
  }

  @Test
  void majorityCanBeAtTheConstraintBoundary() {
    assertThat(solution.majorityElement(new int[] {-1_000_000_000, 7, -1_000_000_000}))
        .isEqualTo(-1_000_000_000);
  }

  @Test
  void maximumInputLength() {
    int[] numbers = new int[50000];
    Arrays.fill(numbers, 17);
    assertThat(solution.majorityElement(numbers)).isEqualTo(17);
  }

  @Test
  void doesNotModifyInput() {
    int[] numbers = {2, 1, 2, 3, 2};
    assertThat(solution.majorityElement(numbers)).isEqualTo(2);
    assertThat(numbers).containsExactly(2, 1, 2, 3, 2);
  }

  @Test
  void allSmallInputsWithAMajorityReturnThatValue() {
    int[] alphabet = {-1, 0, 1};
    for (int length = 1; length <= 7; length++) {
      int combinations = (int) Math.pow(alphabet.length, length);
      for (int encoded = 0; encoded < combinations; encoded++) {
        int value = encoded;
        int[] numbers = new int[length];
        int[] frequencies = new int[alphabet.length];
        for (int index = 0; index < length; index++) {
          int choice = value % alphabet.length;
          numbers[index] = alphabet[choice];
          frequencies[choice]++;
          value /= alphabet.length;
        }
        for (int choice = 0; choice < alphabet.length; choice++) {
          if (frequencies[choice] > length / 2) {
            assertThat(solution.majorityElement(numbers))
                .as("numbers=%s", Arrays.toString(numbers))
                .isEqualTo(alphabet[choice]);
            break;
          }
        }
      }
    }
  }
}
