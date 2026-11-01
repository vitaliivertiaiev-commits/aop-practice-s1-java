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

## DevOps

- [Компіляція і запуск Main](../screenshots/h09/devops-01-compile-run.jpg):
  `javac` створив `Main.class`, програма вивела привітання.
- [Помилки компіляції та виконання](../screenshots/h09/devops-02-errors.jpg):
  пропущена крапка з комою, вихід за межі масиву та невідповідність
  імені файла класу. Наведено коди завершення.
- [Classpath](../screenshots/h09/devops-03-classpath.jpg):
  без шляху клас не знайдено, а `java -cp out Main` запускає програму.
- [Версії JVM та компілятора](../screenshots/h09/devops-04-versions.jpg):
  `java` і `javac` мають однакову версію 25.0.2.

- [Збірка Maven](../screenshots/h09/devops-05-maven.jpg):
  `mvn compile` завершився успішно, створено `target/classes/Main.class`,
  програму запущено з цим classpath.

Скриншот життєвого циклу Maven ще не доданий.

## Git

- [Перейменування гілки](../screenshots/h09/git-07-rename.jpg):
  створено `experiment`, потім перейменовано на `experiment/bitwise`.

Скриншоти решти вправ Git ще не додані.

## LeetCode

Скриншоти розв'язаних задач ще не додані.
