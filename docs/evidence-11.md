# Практична 11. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [268 — Missing Number](https://leetcode.com/problems/missing-number/) | [T1.java](../src/main/java/homework/h11/T1.java) | [T1Test.java](../src/test/java/homework/h11/T1Test.java) |
| [169 — Majority Element](https://leetcode.com/problems/majority-element/) | [T2.java](../src/main/java/homework/h11/T2.java) | [T2Test.java](../src/test/java/homework/h11/T2Test.java) |

Для 268 застосував XOR: однакові індекси та значення взаємно виключаються,
залишається відсутнє число. Час `O(n)`, додаткова пам'ять `O(1)`.

Для 169 застосував алгоритм голосування Бойєра—Мура. Кандидат змінюється,
коли баланс голосів стає нульовим. Час `O(n)`, додаткова пам'ять `O(1)`.

## Перевірка

Автоматичні тести перевіряють приклади, межі, незмінність вхідних масивів,
великі вхідні дані та набори малих значень.

На JDK 25.0.2 команда `mvn clean test spotless:check` завершилася успішно:
218 тестів, помилок і пропусків немає.

## LeetCode

- [268 — Missing Number, Accepted](../screenshots/h11/leetcode-268.jpg).
- [169 — Majority Element, Accepted](../screenshots/h11/leetcode-169.jpg).

## Матеріали

- [DevOps: залежності Maven](devops-11.md).
- [Git: конфлікти злиття](git-11.md).
- [Відкрита дискусія](discussion-11.md).
- Профіль LeetCode: [22 задачі розв'язано](../screenshots/leetcode-total-current.jpg).
- Історичний профіль від 9 листопада: [20/4109](../screenshots/leetcode-total-2026-11-09.jpg).

## DevOps і Git

- DevOps: [залежність і збірка](../screenshots/h11/devops-01-maven-dependency.jpg),
  [кеш Maven і Gson](../screenshots/h11/devops-02-cache-and-gson.jpg).
- Git: [конфлікт і маркери](../screenshots/h11/git-01-conflict-markers.jpg),
  [ручне розв'язання](../screenshots/h11/git-02-manual-resolution.jpg),
  [`--ours` та `--theirs`](../screenshots/h11/git-03-ours-theirs.jpg),
  [скасування злиття](../screenshots/h11/git-04-abort.jpg).
