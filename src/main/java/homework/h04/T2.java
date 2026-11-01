package homework.h04;

// https://leetcode.com/problems/number-complement/
public class T2 {
  public int findComplement(int num) {
    if (num <= 0) {
      throw new IllegalArgumentException("num має бути додатним");
    }

    int significantBits = Integer.SIZE - Integer.numberOfLeadingZeros(num);
    int mask = (1 << significantBits) - 1;
    return num ^ mask;
  }
}
