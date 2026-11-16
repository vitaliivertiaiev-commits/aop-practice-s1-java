package homework.h14;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class T2 {
  private final Deque<Integer> inputStack = new ArrayDeque<>();
  private final Deque<Integer> outputStack = new ArrayDeque<>();

  public void push(int x) {
    inputStack.push(x);
  }

  public int pop() {
    moveIfNeeded();
    return outputStack.pop();
  }

  public int peek() {
    moveIfNeeded();
    return outputStack.peek();
  }

  public boolean empty() {
    return inputStack.isEmpty() && outputStack.isEmpty();
  }

  private void moveIfNeeded() {
    if (outputStack.isEmpty()) {
      while (!inputStack.isEmpty()) {
        outputStack.push(inputStack.pop());
      }
    }
  }
}
