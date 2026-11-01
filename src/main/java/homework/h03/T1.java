package homework.h03;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
public class T1 {
  public double average(int[] salary) {
    if (salary == null || salary.length < 3) {
      throw new IllegalArgumentException("Потрібно щонайменше три зарплати");
    }

    int minimum = Integer.MAX_VALUE;
    int maximum = Integer.MIN_VALUE;
    long total = 0;

    for (int amount : salary) {
      total += amount;
      minimum = Math.min(minimum, amount);
      maximum = Math.max(maximum, amount);
    }

    return (double) (total - minimum - maximum) / (salary.length - 2);
  }
}
