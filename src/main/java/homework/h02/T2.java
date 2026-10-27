package homework.h02;

/**
 * Практична робота 2, завдання 2.
 * LeetCode 2119: A Number After a Double Reversal.
 */
public class T2 {
    /**
     * Перевіряє, чи збігається число з числом після двох перевертань цифр.
     *
     * @param num невід'ємне ціле число
     * @return {@code true}, якщо подвійне перевертання не змінює число
     */
    public boolean isSameAfterReversals(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("num має бути невід'ємним");
        }

        return num == 0 || num % 10 != 0;
    }
}
