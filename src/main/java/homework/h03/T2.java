package homework.h03;

// https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
public class T2 {
  public int differenceOfSums(int limit, int divisor) {
    if (limit < 0 || divisor <= 0) {
      throw new IllegalArgumentException("Потрібно n >= 0 та m > 0");
    }

    long difference = 0;
    for (int number = 1; number <= limit; number++) {
      difference += number % divisor == 0 ? -number : number;
    }

    return Math.toIntExact(difference);
  }
}
