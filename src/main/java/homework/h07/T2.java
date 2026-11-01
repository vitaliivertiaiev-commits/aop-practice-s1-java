package homework.h07;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class T2 {
  public int numberOfSteps(int num) {
    if (num < 0) {
      throw new IllegalArgumentException("num must not be negative");
    }

    int steps = 0;
    while (num > 0) {
      if (num % 2 == 0) {
        num /= 2;
      } else {
        num--;
      }
      steps++;
    }
    return steps;
  }
}
