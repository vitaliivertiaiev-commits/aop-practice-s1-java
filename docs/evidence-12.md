# Самостійна 12. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [1051 — Height Checker](https://leetcode.com/problems/height-checker/) | [T1.java](../src/main/java/homework/h12/T1.java) | [T1Test.java](../src/test/java/homework/h12/T1Test.java) |
| [1122 — Relative Sort Array](https://leetcode.com/problems/relative-sort-array/) | [T2.java](../src/main/java/homework/h12/T2.java) | [T2Test.java](../src/test/java/homework/h12/T2Test.java) |

- LeetCode Accepted: [1051 — Height Checker](../screenshots/h12/leetcode-1051-accepted.jpg),
  [1122 — Relative Sort Array](../screenshots/h12/leetcode-1122-accepted.jpg).

Для 1051 відсортував копію масиву й порахував позиції, де значення різняться.
Для 1122 порахував частоти, записав числа в порядку `arr2`, а решту — за зростанням.

`mvn clean test spotless:check` на JDK 25 завершився успішно:
229 тестів, помилок і пропусків немає.

## DevOps і Git

- DevOps: [дерево залежностей](../screenshots/h12/devops-01-dependency-tree.jpg),
  [аналіз і конфлікт версій](../screenshots/h12/devops-02-analyze-conflict.jpg),
  [оновлення та npm lock-файл](../screenshots/h12/devops-03-updates-npm.jpg),
  [повторюваність збірки](../screenshots/h12/devops-04-reproducible.jpg).
- Git: [зміна remote у тимчасовому репозиторії](../screenshots/h12/git-02-remote.jpg),
  [секрет у попередньому коміті](../screenshots/h12/git-03-secret-history.jpg).
- [Профіль LeetCode: 22 задачі розв'язано](../screenshots/leetcode-total-current.jpg).
