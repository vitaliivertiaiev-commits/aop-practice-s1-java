package homework.h13;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class T1Test {
  @Test
  void findsFirstBadVersionInTheMiddle() {
    assertThat(solutionWithFirstBadVersion(4).firstBadVersion(5)).isEqualTo(4);
  }

  @Test
  void handlesFirstVersionAsBad() {
    assertThat(solutionWithFirstBadVersion(1).firstBadVersion(1)).isEqualTo(1);
  }

  @Test
  void handlesLastVersionAsBad() {
    assertThat(solutionWithFirstBadVersion(10).firstBadVersion(10)).isEqualTo(10);
  }

  @Test
  void handlesLargeVersionNumbersWithoutOverflow() {
    assertThat(solutionWithFirstBadVersion(2_000_000_000).firstBadVersion(Integer.MAX_VALUE))
        .isEqualTo(2_000_000_000);
  }

  private T1 solutionWithFirstBadVersion(int firstBad) {
    return new T1() {
      @Override
      protected boolean isBadVersion(int version) {
        return version >= firstBad;
      }
    };
  }
}
