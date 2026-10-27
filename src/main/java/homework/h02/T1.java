package homework.h02;

/**
 * Практична робота 2, завдання 1.
 * LeetCode 258: Add Digits.
 */
public class T1 {
    /**
     * Обчислює цифровий корінь числа.
     *
     * @param num невід'ємне ціле число
     * @return однозначний цифровий корінь числа
     */
    public int addDigits(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num має бути невід'ємним");
        }
        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}
