package homework.h01;

// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
public class T2 {
  public int countOdds(int low, int high) {
    if (low < 0 || high < low) {
      throw new IllegalArgumentException("Очікується 0 <= low <= high");
    }

    int oddsThroughHigh = high / 2 + high % 2;
    int oddsBeforeLow = low / 2;
    return oddsThroughHigh - oddsBeforeLow;
  }
}
