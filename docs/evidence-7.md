# Практична 7: результати виконання

## Java

| Завдання | Розв'язок | Тести | LeetCode |
| --- | --- | --- | --- |
| T1 | [T1.java](../src/main/java/homework/h07/T1.java) | [T1Test.java](../src/test/java/homework/h07/T1Test.java) | [412 — Fizz Buzz](https://leetcode.com/problems/fizz-buzz/) |
| T2 | [T2.java](../src/main/java/homework/h07/T2.java) | [T2Test.java](../src/test/java/homework/h07/T2Test.java) | [1342 — Number of Steps to Reduce a Number to Zero](https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/) |

T1: час `O(n)` і пам'ять `O(n)` для результату. Спочатку перевіряється кратність
15, щоб числа, кратні 3 та 5, отримували `FizzBuzz`, а не тільки `Fizz`.

T2: час `O(log(num + 1))`, додаткова пам'ять `O(1)`.
Додатне число на кожній ітерації строго зменшується. Для нуля відповідь — 0.

### Результати LeetCode

| Завдання | Результат | Час відправлення на знімку | Знімки |
| --- | --- | --- | --- |
| 412 — Fizz Buzz | **Accepted, 8/8** | Nov 01, 2026 19:27 | [Номер і назва](../screenshots/h07/t1-leetcode-title.jpg), [Accepted](../screenshots/h07/t1-leetcode.jpg) |
| 1342 — Number of Steps to Reduce a Number to Zero | **Accepted, 204/204** | Nov 01, 2026 19:24 | [Номер і назва](../screenshots/h07/t2-leetcode-title.jpg), [Accepted](../screenshots/h07/t2-leetcode.jpg) |

Назви задач і результати Accepted показані на окремих скриншотах.

### Перевірка збірки й тестів

Збірка та тести: **OpenJDK 25.0.2**, 1 листопада 2026 року.

| Команда | Результат |
| --- | --- |
| `mvn clean compile` | BUILD SUCCESS |
| `mvn test-compile` | BUILD SUCCESS |
| `mvn test` | BUILD SUCCESS; 128 тестів, 0 failures, 0 errors, 0 skipped |
| `mvn spotless:check` | BUILD SUCCESS |

Із них **17 тестів** належать практичній 7. У кожному є перевірка AssertJ.
Приклади LeetCode — окремі методи; межі: `n = 1` і `10_000`,
`num = 0` і `1_000_000`. JaCoCo 0.8.14 підтвердив для `h07`
**23 із 23 рядків і 16 із 16 гілок**.

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

## Профіль LeetCode

[Скриншот профілю з лічильником](../screenshots/leetcode-total.jpg):
видно `14 problems solved`, `14 Solved` і 14 задач Java. Кількість відповідає
14 розв'язкам у репозиторії.

## Примітки до скриншотів

- G1: назва задачі та Accepted розміщені на різних кадрах, а не на одному спільному.
- На фрагменті профілю видно лічильник 14, але не видно ніка або дати.

Матеріали: 6 скриншотів DevOps, 12 скриншотів Git, 4 кадри задач LeetCode
та скриншот лічильника профілю.
