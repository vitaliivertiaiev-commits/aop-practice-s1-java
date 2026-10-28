package homework.h06;

// LeetCode 125: Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/
public class T2 {
    public boolean isPalindrome(String s) {
        if (s == null) {
            throw new IllegalArgumentException("Input string must not be null");
        }

        int left = 0;
        int right = s.length();
        while (left < right) {
            int leftCodePoint = s.codePointAt(left);
            if (!Character.isLetterOrDigit(leftCodePoint)) {
                left += Character.charCount(leftCodePoint);
                continue;
            }

            int rightCodePoint = s.codePointBefore(right);
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
