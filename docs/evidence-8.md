# Практична 8. Результати

## Java

| Задача | Рішення | Тести |
| --- | --- | --- |
| [485 — Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/) | [T1.java](../src/main/java/homework/h08/T1.java) | [T1Test.java](../src/test/java/homework/h08/T1Test.java) |
| [2824 — Count Pairs Whose Sum is Less than Target](https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/) | [T2.java](../src/main/java/homework/h08/T2.java) | [T2Test.java](../src/test/java/homework/h08/T2Test.java) |

У першій задачі зберігається довжина поточної та найбільшої серії.
Нуль обриває серію. Час — `O(n)`, додаткова пам'ять — `O(1)`.

У другій задачі сортується копія списку. Якщо сума крайніх елементів
менша за `target`, до результату додається `rightIndex - leftIndex`.
Інакше правий вказівник зсувається ліворуч. Початковий список не змінюється.
Час — `O(n log n)`, додаткова пам'ять — `O(n)`.

## Перевірка

24 тести практичної охоплюють приклади LeetCode, граничні значення,
порожні дані, повтори, строгу нерівність і незмінність вхідних даних.
Для підрахунку пар додатково порівнюються всі 3125 списків довжини 5
зі значеннями від -2 до 2 для семи значень `target` із прямим перебором.

У чистому клоні на OpenJDK 25.0.2:

| Команда | Результат |
| --- | --- |
| `mvn clean compile` | BUILD SUCCESS |
| `mvn test-compile` | BUILD SUCCESS |
| `mvn test` | 152 тести, без помилок і пропусків |
| `mvn spotless:check` | BUILD SUCCESS |

Покриття `h08` за JaCoCo: 20/20 рядків і 8/8 гілок.

## Інші частини

- [DevOps: оточення](devops-8.md).
- [Git: скасування змін](git-8.md).
- [Відповіді на дискусію](discussion-8.md).

## LeetCode

- [485: код і позначка Solved](../screenshots/h08/t1-leetcode-solved.jpg).
- [2824: код і позначка Solved](../screenshots/h08/t2-leetcode-solved.jpg).

Обидві задачі позначені як розв'язані. Окремі кадри результатів Accepted
і новий знімок лічильника профілю ще не додані.

## DevOps

- [Локальна й експортована змінні](../screenshots/h08/devops-01-local-export.jpg):
  дочірній процес отримав тільки експортовану змінну.
- [PATH і пошук Java та Git](../screenshots/h08/devops-02-path.jpg).
- [Власна команда hello](../screenshots/h08/devops-03-command-search.jpg):
  після зміни PATH команда працює; у новому shell з початковим PATH
  знову не знаходиться.
- [Постійне налаштування PATH](../screenshots/h08/devops-04-persistent-path.jpg):
  після запису в `.zshrc` команда працює і в новому інтерактивному zsh.

- [Аліаси gs і gl](../screenshots/h08/devops-05-aliases.jpg):
  перегляд змінених файлів та історії комітів короткими командами.

- [Редактор і змінні оточення](../screenshots/h08/devops-06-editor-env.jpg):
  `EDITOR=nano`, налаштування `core.editor`, перегляд `HOME` та `env`.

- [Oh My Zsh](../screenshots/h08/devops-07-oh-my-zsh.jpg):
  порівняння запрошення до та після завантаження теми,
  відображення гілки `main` і перевірка аліасів `gs` та `ls`.

## Git

- [Виправлення коміту через amend](../screenshots/h08/git-01-amend.jpg):
  змінено повідомлення коміту та додано забутий файл `b.txt`
  зі збереженням повідомлення через `--no-edit`.
- [Зняття з індексу та скасування правок](../screenshots/h08/git-02-restore.jpg):
  `restore --staged` зберіг зміни у файлі, а `restore` повернув
  його вміст до останнього коміту.
- [Порівняння reset --soft і --mixed](../screenshots/h08/git-03-reset-soft-mixed.jpg):
  `--soft` залишив зміни в індексі, а `--mixed` — лише в робочому файлі.
- [Скасування коміту через revert](../screenshots/h08/git-05-revert.jpg):
  створено новий коміт, третій рядок прибрано, попередні коміти збережено.
  `git status -s` не виводить змін.

Скриншот `reset --hard` і відновлення через `reflog` ще не додано.
