package homework.h04;

// https://leetcode.com/problems/hamming-distance/
public class T1 {
  public int hammingDistance(int first, int second) {
    return Integer.bitCount(first ^ second);
  }
}
