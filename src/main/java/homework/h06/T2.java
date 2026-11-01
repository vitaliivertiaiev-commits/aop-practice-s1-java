package homework.h06;

// https://leetcode.com/problems/valid-palindrome/
public class T2 {
  public boolean isPalindrome(String text) {
    if (text == null) {
      throw new IllegalArgumentException("Input string must not be null");
    }

    int left = 0;
    int right = text.length();
    while (left < right) {
      int leftCodePoint = text.codePointAt(left);
      if (!Character.isLetterOrDigit(leftCodePoint)) {
        left += Character.charCount(leftCodePoint);
        continue;
      }

      int rightCodePoint = text.codePointBefore(right);
      if (!Character.isLetterOrDigit(rightCodePoint)) {
        right -= Character.charCount(rightCodePoint);
        continue;
      }

      if (Character.toLowerCase(leftCodePoint) != Character.toLowerCase(rightCodePoint)) {
        return false;
      }

      left += Character.charCount(leftCodePoint);
      right -= Character.charCount(rightCodePoint);
    }

    return true;
  }
}
