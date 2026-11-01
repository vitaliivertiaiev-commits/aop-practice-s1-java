package homework.h07;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/fizz-buzz/
public class T1 {
  public List<String> fizzBuzz(int number) {
    if (number < 1) {
      throw new IllegalArgumentException("number must be positive");
    }

    List<String> result = new ArrayList<>(number);
    for (int current = 1; current <= number; current++) {
      if (current % 15 == 0) {
        result.add("FizzBuzz");
      } else if (current % 3 == 0) {
        result.add("Fizz");
      } else if (current % 5 == 0) {
        result.add("Buzz");
      } else {
        result.add(Integer.toString(current));
      }
    }
    return result;
  }
}
