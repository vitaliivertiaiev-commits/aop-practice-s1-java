package homework.h10;

// https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
public class T1 {
  public char kthCharacter(int k) {
    int length = 1;
    while (length < k) {
      length *= 2;
    }
    return findCharacter(k, length);
  }

  private char findCharacter(int position, int length) {
    if (length == 1) {
      return 'a';
    }
    int half = length / 2;
    if (position <= half) {
      return findCharacter(position, half);
    }
    char previous = findCharacter(position - half, half);
    return (char) ('a' + (previous - 'a' + 1) % 26);
  }
}
