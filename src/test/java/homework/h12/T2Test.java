package homework.h12;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T2Test {
  private final T2 solution = new T2();

  @Test
  void exampleOne() {
    assertThat(
            solution.relativeSortArray(
                new int[] {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[] {2, 1, 4, 3, 9, 6}))
        .containsExactly(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19);
  }

  @Test
  void exampleTwo() {
    assertThat(
            solution.relativeSortArray(new int[] {28, 6, 22, 8, 44, 17}, new int[] {22, 28, 8, 6}))
        .containsExactly(22, 28, 8, 6, 17, 44);
  }

  @Test
  void repeatsArr2ValuesAndSortsRemainingValues() {
    assertThat(solution.relativeSortArray(new int[] {5, 1, 5, 2, 1, 4, 3}, new int[] {5, 1}))
        .containsExactly(5, 5, 1, 1, 2, 3, 4);
  }

  @Test
  void handlesMinimumAndMaximumValues() {
    assertThat(solution.relativeSortArray(new int[] {1000, 0, 500}, new int[] {500}))
        .containsExactly(500, 0, 1000);
  }

  @Test
  void doesNotModifyInputs() {
    int[] first = {2, 3, 1, 2};
    int[] order = {2, 1};
    assertThat(solution.relativeSortArray(first, order)).containsExactly(2, 2, 1, 3);
    assertThat(first).containsExactly(2, 3, 1, 2);
    assertThat(order).containsExactly(2, 1);
  }
}
