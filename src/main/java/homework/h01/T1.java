package homework.h01;

/**
 * Практична робота 1, завдання 1.
 * LeetCode 2413: Smallest Even Multiple.
 */
public class T1 {
    /**
     * Повертає найменше додатне число, яке ділиться і на {@code n}, і на 2.
     *
     * @param n додатне ціле число
     * @return найменше спільне кратне n та 2
     */
    public int smallestEvenMultiple(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n має бути додатним");
        }

        return n % 2 == 0 ? n : n * 2;
    }
}
