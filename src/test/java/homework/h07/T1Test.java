package homework.h07;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class T1Test {
  private final T1 solution = new T1();

  @Test
  void exampleOne() {
    assertThat(solution.fizzBuzz(3)).containsExactly("1", "2", "Fizz");
  }

  @Test
  void exampleTwo() {
    assertThat(solution.fizzBuzz(5)).containsExactly("1", "2", "Fizz", "4", "Buzz");
  }

  @Test
  void exampleThree() {
    assertThat(solution.fizzBuzz(15))
        .containsExactly(
            "1",
            "2",
            "Fizz",
            "4",
            "Buzz",
            "Fizz",
            "7",
            "8",
            "Fizz",
            "Buzz",
            "11",
            "Fizz",
            "13",
            "14",
            "FizzBuzz");
  }

  @Test
  void minimumAllowedNumber() {
    assertThat(solution.fizzBuzz(1)).containsExactly("1");
  }

  @Test
  void maximumAllowedNumber() {
    var result = solution.fizzBuzz(10_000);
    assertThat(result).hasSize(10_000);
    assertThat(result.getFirst()).isEqualTo("1");
    assertThat(result.getLast()).isEqualTo("Buzz");
    for (int current = 1; current <= result.size(); current++) {
      String expected = "";
      if (current % 3 == 0) {
        expected += "Fizz";
      }
      if (current % 5 == 0) {
        expected += "Buzz";
      }
      if (expected.isEmpty()) {
        expected = Integer.toString(current);
      }
      assertThat(result.get(current - 1)).isEqualTo(expected);
    }
  }

  @Test
  void rejectsZero() {
    assertThatThrownBy(() -> solution.fizzBuzz(0)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void rejectsNegativeNumber() {
    assertThatThrownBy(() -> solution.fizzBuzz(-1)).isInstanceOf(IllegalArgumentException.class);
  }
}
