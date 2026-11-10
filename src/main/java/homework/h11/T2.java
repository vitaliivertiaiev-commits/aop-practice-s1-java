package homework.h11;

// https://leetcode.com/problems/majority-element/
public class T2 {
  public int majorityElement(int[] numbers) {
    int candidate = 0;
    int balance = 0;
    for (int number : numbers) {
      if (balance == 0) {
        candidate = number;
      }
      balance += number == candidate ? 1 : -1;
    }
    return candidate;
  }
}
