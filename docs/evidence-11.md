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
- Профіль LeetCode: [20/4109 задач розв'язано](../screenshots/leetcode-total-current.jpg)
  на знімку від 9 листопада.

## DevOps

- [Початкове дерево, залежність Commons Lang і збірка](../screenshots/h11/devops-01-maven-dependency.jpg).
- [Повторне завантаження з тимчасового кешу, офлайн-перевірка та Gson](../screenshots/h11/devops-02-cache-and-gson.jpg).

## Git

- [Конфлікт однакових рядків і маркери](../screenshots/h11/git-01-conflict-markers.jpg).
- [Зміни в різних файлах і ручне розв'язання](../screenshots/h11/git-02-manual-resolution.jpg).
- [Вибір версії через `--ours` і `--theirs`](../screenshots/h11/git-03-ours-theirs.jpg).
- [Скасування конфліктного злиття](../screenshots/h11/git-04-abort.jpg).
