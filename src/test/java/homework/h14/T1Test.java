package homework.h14;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void removesAdjacentPairsFromExampleOne() {
    assertThat(solution.removeDuplicates("abbaca")).isEqualTo("ca");
  }

  @Test
  void removesAdjacentPairsFromExampleTwo() {
    assertThat(solution.removeDuplicates("azxxzy")).isEqualTo("ay");
  }

  @Test
  void removesPairsCreatedByEarlierRemovals() {
    assertThat(solution.removeDuplicates("aabccb")).isEmpty();
  }

  @Test
  void leavesStringWithoutAdjacentDuplicatesUnchanged() {
    assertThat(solution.removeDuplicates("abc")).isEqualTo("abc");
  }

  @Test
  void handlesEmptyString() {
    assertThat(solution.removeDuplicates("")).isEmpty();
  }
}
