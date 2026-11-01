package homework.h09;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class T2 {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    List<Boolean> result = new ArrayList<>(candies.length);
    if (candies.length == 0) {
      return result;
    }
    int maximum = findMaximum(candies);
    for (int count : candies) {
      result.add(count + extraCandies >= maximum);
    }
    return result;
  }

  private int findMaximum(int[] numbers) {
    int maximum = numbers[0];
    for (int index = 1; index < numbers.length; index++) {
      maximum = Math.max(maximum, numbers[index]);
    }
    return maximum;
  }
}
