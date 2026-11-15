# Самостійна 13. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [278 — First Bad Version](https://leetcode.com/problems/first-bad-version/) | [T1.java](../src/main/java/homework/h13/T1.java) | [T1Test.java](../src/test/java/homework/h13/T1Test.java) |
| [2529 — Maximum Count of Positive Integer and Negative Integer](https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/) | [T2.java](../src/main/java/homework/h13/T2.java) | [T2Test.java](../src/test/java/homework/h13/T2Test.java) |

Для 278 застосував бінарний пошук першої поганої версії. Для 2529 знайшов
межі від’ємних і додатних чисел у відсортованому масиві.

`mvn clean test spotless:check` на JDK 25 завершився успішно:
239 тестів, помилок і пропусків немає.

## DevOps і Git

- [DevOps: репозиторії пакетів](devops-13.md)
- [Git: pull request](git-13.md)
