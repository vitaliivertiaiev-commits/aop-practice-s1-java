package homework.h14;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class T1 {
  public String removeDuplicates(String s) {
    char[] stack = new char[s.length()];
    int size = 0;

    for (char value : s.toCharArray()) {
      if (size > 0 && stack[size - 1] == value) {
        size--;
      } else {
        stack[size++] = value;
      }
    }

    return new String(stack, 0, size);
  }
}
