package homework.h09;

// https://leetcode.com/problems/number-of-good-pairs/
public class T1 {
  public int numIdenticalPairs(int[] numbers) {
    int[] frequencies = countFrequencies(numbers);
    int pairCount = 0;
    for (int frequency : frequencies) {
      pairCount += frequency * (frequency - 1) / 2;
    }
    return pairCount;
  }

  private int[] countFrequencies(int[] numbers) {
    int[] frequencies = new int[101];
    for (int number : numbers) {
      frequencies[number]++;
    }
    return frequencies;
  }
}
