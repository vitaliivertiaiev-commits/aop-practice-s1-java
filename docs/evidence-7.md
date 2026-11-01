# Практична 7: стан виконання та докази

## Java

| Завдання | Розв'язок | Тести | LeetCode |
| --- | --- | --- | --- |
| T1 | [T1.java](../src/main/java/homework/h07/T1.java) | [T1Test.java](../src/test/java/homework/h07/T1Test.java) | [412 — Fizz Buzz](https://leetcode.com/problems/fizz-buzz/) |
| T2 | [T2.java](../src/main/java/homework/h07/T2.java) | [T2Test.java](../src/test/java/homework/h07/T2Test.java) | [1342 — Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) |

T1: час `O(n)` і пам'ять `O(n)` для результату. Спочатку перевіряється кратність
15, щоб числа, кратні 3 та 5, отримували `FizzBuzz`, а не тільки `Fizz`.

T2: час `O(log(num + 1))`, додаткова пам'ять `O(1)`.
Додатне число на кожній ітерації строго зменшується. Для нуля відповідь — 0.

### Справжні результати LeetCode

| Завдання | Результат | Час відправлення на знімку | Знімки |
| --- | --- | --- | --- |
| 412 — Fizz Buzz | **Accepted, 8/8** | Nov 01, 2026 19:27 | [Номер і назва](../screenshots/h07/t1-leetcode-title.jpg), [Accepted](../screenshots/h07/t1-leetcode.jpg) |
| 1342 — Number of Steps to Reduce a Number to Zero | **Accepted, 204/204** | Nov 01, 2026 19:24 | [Номер і назва](../screenshots/h07/t2-leetcode-title.jpg), [Accepted](../screenshots/h07/t2-leetcode.jpg) |

Збережено чотири обрізані знімки з наданої студентом серії. Панелі телефона
та браузера прибрано; номер, назву, результати й час не домальовано.
Назва та Accepted знаходяться на **різних вихідних кадрах**: це підтвердження
отриманих результатів, але не твердження про повне виконання вимоги G1
показати назву й Accepted одночасно на одному знімку.

### Перевірка збірки й тестів

Перевірено 1 листопада 2026 року на **OpenJDK 25.0.2** у чистому локальному
`git clone` збереженого коміту, без додаткових файлів:

| Команда | Результат |
| --- | --- |
| `mvn clean compile` | BUILD SUCCESS |
| `mvn test-compile` | BUILD SUCCESS |
| `mvn test` | BUILD SUCCESS; 128 тестів, 0 failures, 0 errors, 0 skipped |
| `mvn spotless:check` | BUILD SUCCESS |

Із них **17 тестів** належать практичній 7. У кожному є перевірка AssertJ.
Приклади LeetCode — окремі методи; межі: `n = 1` і `10_000`,
`num = 0` і `1_000_000`. JaCoCo 0.8.14 підтвердив для `h07`
**23 із 23 рядків і 16 із 16 гілок**. Після чотирьох команд робоче дерево
залишилося чистим. `pom.xml` і `.gitignore` не змінювалися.

## DevOps та Git

- **DevOps, завдання 1–2 підтверджено:**
  [слухач і три HTTP-запити](../screenshots/h07/devops-01-listener-and-http.jpg).
  На кадрі видно `python3`, PID 5402, TCP LISTEN на 8000, однакові відповіді
  через `localhost` і `127.0.0.1`, `HTTP/1.0 200 OK`, дату та користувача `runner`.
- **DevOps, завдання 3 і помилка зайнятого порту із завдання 4 підтверджені:**
  [404, відсутній сервер і зайнятий порт](../screenshots/h07/devops-02-http-errors-and-busy-port.jpg).
  Видно `HTTP/1.0 404 File not found`, відмову з'єднання на 9999 з exit code 7,
  `OSError: [Errno 98] Address already in use`, PID 7246, дату та `runner`.
- **DevOps, решта завдання 4 підтверджена:**
  [зупинка, звільнення порту й повторний запуск](../screenshots/h07/devops-03-stop-and-restart.jpg).
  У свіжому самодостатньому запуску PID 8117 завершено, `lsof` повернув 1,
  після чого PID 8124 зайняв порт і відповів `HTTP/1.0 200 OK`.
- **DevOps, завдання 5 підтверджене:**
  [фрагмент списку `netstat`](../screenshots/h07/devops-04-netstat-listeners.jpg).
  Видно LISTEN/LISTENING, дату та `runner`.
  [Окремий кадр повної таблиці TCP-слухачів `lsof`](../screenshots/h07/devops-06-all-tcp-listeners.jpg)
  містить команду, заголовки, PID, адреси, порти, дату та `runner`.
- **DevOps, завдання 6–7 підтверджені:**
  [nc, jobs і прибирання](../screenshots/h07/devops-05-nc-and-cleanup.jpg).
  `nc` для 8000 повернув 0, для 9999 — 1; `jobs` показав PID 8124.
  Після його завершення вивід `lsof` порожній, exit code 1; дата та `runner` видимі.
- [DevOps: усі сім завдань і блоки для скриншотів](devops-7.md).
- **Git, завдання 1–2 підтверджені чотирма кадрами:**
  [unstaged і порожній diff після add](../screenshots/h07/git-01-unstaged-and-add.jpg);
  [index/HEAD і working tree/HEAD після add](../screenshots/h07/git-02-staged-and-head.jpg);
  [після п'ятого рядка: working tree/index та index/HEAD](../screenshots/h07/git-03-three-states.jpg);
  [після п'ятого рядка: working tree/HEAD](../screenshots/h07/git-04-working-tree-head.jpg).
  Видно додавання `чотири`, потім окреме unstaged-додавання `пʼять`,
  різні результати трьох порівнянь, дату та `runner`.
- **Git, завдання 3–5 підтверджені чотирма кадрами:**
  [звичайний і нульовий контекст](../screenshots/h07/git-05-default-and-zero-context.jpg);
  [контекст -U5 та два коміти](../screenshots/h07/git-06-context-and-commits.jpg);
  [порівняння комітів і чистого working tree](../screenshots/h07/git-07-commit-comparisons.jpg);
  [усі staged-файли проти вибору f.txt](../screenshots/h07/git-08-path-filter.jpg).
  Видно hunk `@@ -1,4 +1,4 @@`, мінімальні фрагменти `-U0`, однакові результати
  двох порівнянь з попереднім комітом, staged-додавання `other.txt`
  та порожній diff для `f.txt`, дату та `runner`.
- **Git, завдання 6–8 підтверджені чотирма кадрами:**
  [статистика та нові staged-файли](../screenshots/h07/git-09-statistics.jpg);
  [рядковий і словесний diff](../screenshots/h07/git-10-word-diff.jpg);
  [огляд і зняття зі staging без втрати правки](../screenshots/h07/git-11-review-and-unstage.jpg);
  [повторний огляд, коміт і чистий стан](../screenshots/h07/git-12-commit-and-clean-status.jpg).
  Видно `--stat`/`--shortstat` із двома доданими рядками, word diff,
  unstaged-стан `M text.md` зі збереженою правкою, чотири коміти,
  порожній фінальний status, дату та `runner`.
- [Git: усі вісім завдань і блоки для скриншотів](git-7.md).
- [Відповіді на всі шість питань дискусії](discussion-7.md).

Усі три блоки з кожної інструкції також виконано під час підготовки:
отримано 200, 404, помилку з'єднання та зайнятого порту, звільнено порт;
перевірено три пари станів Git, hunk, контекст, обмеження шляху, статистику
й word diff. Це перевірка працездатності команд, не заміна власних скриншотів.

## Що ще потрібно для здачі за A–G

- Для буквального виконання G1: по одному кадру для кожної задачі, де одночасно
  видно номер і повну назву, Accepted, дату/час або ім'я користувача.
  Самі Accepted вже підтверджено знімками вище; повторно розв'язувати задачі не потрібно.
- Один скриншот власного профілю з кількістю розв'язаних задач не менше **14**
  у `screenshots/leetcode-total.png` або `.jpg`.

Скриншоти LeetCode отримано й додано до `screenshots/h07/`.
Отримано шість скриншотів DevOps; усі сім завдань підтверджено.
Отримано дванадцять скриншотів Git; усі вісім завдань підтверджено.
Залишилися профіль і зазначені вище вимоги G1 до спільного кадру.
Практична не позначається повністю зданою до отримання решти доказів.
