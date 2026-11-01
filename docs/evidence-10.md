# Практична 10. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [3304 — Find the K-th Character in String Game I](https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/) | [T1.java](../src/main/java/homework/h10/T1.java) | [T1Test.java](../src/test/java/homework/h10/T1Test.java) |
| [344 — Reverse String](https://leetcode.com/problems/reverse-string/) | [T2.java](../src/main/java/homework/h10/T2.java) | [T2Test.java](../src/test/java/homework/h10/T2Test.java) |

У 3304 рекурсивно визначаю, в якій половині знаходиться потрібна позиція.
Для другої половини літера збільшується на одну. Повний рядок не створюється.
Час і додаткова пам'ять — `O(log k)`.

У 344 рекурсивно міняю місцями пари символів у початковому масиві.
Один блок обробляє до 64 пар; цикл запускає наступні блоки.
Глибина викликів не перевищує 65 і не залежить від довжини масиву.
Час — `O(n)`, додаткова пам'ять — `O(1)`, включно зі стеком.

## Тести

24 тести: приклади LeetCode, межі, порожній і одиничний масив,
парна й непарна довжина, повтори та межі рекурсивних блоків.
Для 3304 перевірено всі позиції від 1 до 500.
Для 344 перевірено масив із 100000 символів та всі 1093 масиви
довжини 0–6 над алфавітом із трьох символів.

На OpenJDK 25.0.2 команда `mvn clean test spotless:check` завершилася успішно:
200 тестів, помилок і пропусків немає. Форматування відповідає шаблону.

## Матеріали

- [DevOps: артефакти збірки](devops-10.md).
- [Git: злиття гілок](git-10.md).
- [Дискусія: шість відповідей](discussion-10.md).

## DevOps

- [Збірка JAR](../screenshots/h10/devops-01-package.jpg):
  `mvn package` завершився успішно та створив `target/demo-1.0.0.jar`.
- [Вміст JAR і маніфест](../screenshots/h10/devops-02-manifest-missing.jpg):
  архів містить `Main.class`, але без `Main-Class` запуск через `java -jar`
  завершується очікуваною помилкою.
- [Запускний JAR](../screenshots/h10/devops-03-executable-jar.jpg):
  після налаштування плагіна маніфест містить `Main-Class: Main`,
  а `java -jar` запускає програму.
- [Контрольна сума SHA-256](../screenshots/h10/devops-04-sha256.jpg):
  суми JAR та копії збігаються; дописування одного байта змінює суму копії.
- [Архіви ZIP і TAR.GZ](../screenshots/h10/devops-05-archives.jpg):
  створено `release.zip` та `release.tar.gz`, перевірено їхній вміст.
- [Ігнорування й повторна збірка](../screenshots/h10/devops-06-ignore-rebuild.jpg):
  `target/` додано до `.gitignore`; після `mvn clean` артефакт відновлено
  через `mvn package`, його SHA-256 не змінився.
