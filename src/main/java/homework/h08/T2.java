package homework.h08;

import java.util.List;

// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/
public class T2 {
  public int countPairs(List<Integer> numbers, int target) {
    int[] sortedNumbers = numbers.stream().mapToInt(Integer::intValue).sorted().toArray();
    int leftIndex = 0;
    int rightIndex = sortedNumbers.length - 1;
    int pairCount = 0;
    while (leftIndex < rightIndex) {
      if (sortedNumbers[leftIndex] + sortedNumbers[rightIndex] < target) {
        pairCount += rightIndex - leftIndex;
        leftIndex++;
      } else {
        rightIndex--;
      }
    }
    return pairCount;
  }
}
