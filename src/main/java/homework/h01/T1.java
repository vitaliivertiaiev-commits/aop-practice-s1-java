package homework.h01;

// https://leetcode.com/problems/smallest-even-multiple/
public class T1 {
  public int smallestEvenMultiple(int number) {
    if (number <= 0) {
      throw new IllegalArgumentException("n має бути додатним");
    }

    return number % 2 == 0 ? number : number * 2;
  }
}
