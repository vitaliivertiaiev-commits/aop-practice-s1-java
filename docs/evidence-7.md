# Практична 7. Результати

## Java

| Задача | Рішення | Тести | LeetCode |
| --- | --- | --- | --- |
| [412 — Fizz Buzz](https://leetcode.com/problems/fizz-buzz/) | [T1.java](../src/main/java/homework/h07/T1.java) | [T1Test.java](../src/test/java/homework/h07/T1Test.java) | [Accepted, 8/8](../screenshots/h07/t1-leetcode.jpg) |
| [1342 — Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) | [T2.java](../src/main/java/homework/h07/T2.java) | [T2Test.java](../src/test/java/homework/h07/T2Test.java) | [Accepted, 204/204](../screenshots/h07/t2-leetcode.jpg) |

У Fizz Buzz використав цикл `for`: спочатку перевірка кратності 15,
потім 3 та 5. Час і пам'ять для результату — `O(n)`.

У другій задачі — цикл `while`: парне число ділю на 2, від непарного віднімаю 1,
поки не отримаю 0. Час — `O(log(num + 1))`, додаткова пам'ять — `O(1)`.

[Назва задачі 412](../screenshots/h07/t1-leetcode-title.jpg) ·
[Назва задачі 1342](../screenshots/h07/t2-leetcode-title.jpg)

## Тести та збірка

Перевірка на OpenJDK 25.0.2, 1 листопада 2026 року:

| Команда | Результат |
| --- | --- |
| `mvn clean compile` | BUILD SUCCESS |
| `mvn test-compile` | BUILD SUCCESS |
| `mvn test` | 128 тестів, без помилок і пропусків |
| `mvn spotless:check` | BUILD SUCCESS |

До практичної 7 належать 17 тестів з AssertJ: приклади LeetCode, граничні
значення та перевірки розгалужень. Межі: `n = 1` і `10_000`,
`num = 0` і `1_000_000`. Покриття `h07` за JaCoCo —
23/23 рядків і 16/16 гілок.

## DevOps, Git і дискусія

- [DevOps: HTTP-сервер, помилки, порти та nc](devops-7.md).
- [Git: diff, контекст, порівняння комітів і staging](git-7.md).
- [Відповіді на шість запитань](discussion-7.md).

Скриншоти команд і результатів наведені у відповідних розділах.

## LeetCode

Поточний профіль LeetCode: [22 задачі розв'язано](../screenshots/leetcode-total-current.jpg).
