package homework.h11;

// https://leetcode.com/problems/missing-number/
public class T1 {
  public int missingNumber(int[] numbers) {
    int missing = numbers.length;
    for (int index = 0; index < numbers.length; index++) {
      missing ^= index ^ numbers[index];
    }
    return missing;
  }
}
