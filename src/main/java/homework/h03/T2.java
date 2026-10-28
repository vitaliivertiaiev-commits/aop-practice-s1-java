package homework.h03;

// LeetCode 2894: Divisible and Non-divisible Sums Difference.
public class T2 {
    public int differenceOfSums(int n, int m) {
        if (n < 0 || m <= 0) {
            throw new IllegalArgumentException("Потрібно n >= 0 та m > 0");
        }

        long difference = 0;
        for (int number = 1; number <= n; number++) {
            difference += number % m == 0 ? -number : number;
        }

        return Math.toIntExact(difference);
    }
}
