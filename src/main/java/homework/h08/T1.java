package homework.h08;

// https://leetcode.com/problems/max-consecutive-ones/
public class T1 {
  public int findMaxConsecutiveOnes(int[] numbers) {
    int currentLength = 0;
    int longestLength = 0;
    for (int number : numbers) {
      if (number == 1) {
        currentLength++;
        longestLength = Math.max(longestLength, currentLength);
      } else {
        currentLength = 0;
      }
    }
    return longestLength;
  }
}
