package homework.h01;

/**
 * Практична робота 1, завдання 2.
 * LeetCode 1523: Count Odd Numbers in an Interval Range.
 */
public class T2 {
    /**
     * Підраховує непарні числа на включеному проміжку [low, high].
     *
     * @param low нижня межа проміжку
     * @param high верхня межа проміжку
     * @return кількість непарних чисел у проміжку
     */
    public int countOdds(int low, int high) {
        if (low < 0 || high < low) {
            throw new IllegalArgumentException("Очікується 0 <= low <= high");
        }

        // Кількість непарних чисел від 0 до x дорівнює ceil(x / 2).
        // Віднімаємо кількість непарних чисел до low, щоб отримати [low, high].
        int oddsThroughHigh = high / 2 + high % 2;
        int oddsBeforeLow = low / 2;
        return oddsThroughHigh - oddsBeforeLow;
    }
}
