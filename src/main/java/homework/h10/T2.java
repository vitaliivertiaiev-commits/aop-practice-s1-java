package homework.h10;

// https://leetcode.com/problems/reverse-string/
public class T2 {
  public void reverseString(char[] characters) {
    int left = 0;
    int right = characters.length - 1;
    while (left < right) {
      int pairCount = Math.min(64, (right - left + 1) / 2);
      reversePairs(characters, left, right, pairCount);
      left += pairCount;
      right -= pairCount;
    }
  }

  private void reversePairs(char[] characters, int left, int right, int remainingPairs) {
    if (remainingPairs == 0) {
      return;
    }
    char temporary = characters[left];
    characters[left] = characters[right];
    characters[right] = temporary;
    reversePairs(characters, left + 1, right - 1, remainingPairs - 1);
  }
}
