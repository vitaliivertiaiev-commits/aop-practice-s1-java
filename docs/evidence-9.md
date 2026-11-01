# Практична 9. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [1512 — Number of Good Pairs](https://leetcode.com/problems/number-of-good-pairs/) | [T1.java](../src/main/java/homework/h09/T1.java) | [T1Test.java](../src/test/java/homework/h09/T1Test.java) |
| [1431 — Kids With the Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/) | [T2.java](../src/main/java/homework/h09/T2.java) | [T2Test.java](../src/test/java/homework/h09/T2Test.java) |

У 1512 окремий метод рахує частоти чисел. Для частоти `k` кількість
пар дорівнює `k * (k - 1) / 2`. За умовою числа лежать у межах 1–100,
тому масив частот має сталий розмір. Час — `O(n)`, додаткова пам'ять — `O(1)`.

У 1431 окремий метод знаходить максимум. Для кожної дитини перевіряється
`candies[i] + extraCandies >= maximum`; рівність теж підходить.
Час — `O(n)`, пам'ять для відповіді — `O(n)`.
Обидва рішення не змінюють вхідні масиви.

## Матеріали

- [DevOps: компіляція, classpath і Maven](devops-9.md).
- [Git: гілки](git-9.md).
- [Дискусія: шість відповідей](discussion-9.md).

24 тести охоплюють приклади LeetCode, межі, повтори, порожні масиви
та незмінність даних. Додатково рішення порівнюються з прямим перебором:
1024 масиви для пар та 256 масивів із чотирма значеннями extraCandies для 1431.

## Перевірка

На OpenJDK 25.0.2 виконано `mvn clean test spotless:check`:
176 тестів, помилок і пропусків немає; форматування відповідає шаблону.
З них 24 тести належать цій практичній.

Скриншоти DevOps, Git і розв'язаних задач LeetCode ще не додані.
