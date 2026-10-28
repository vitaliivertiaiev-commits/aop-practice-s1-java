# Практичні роботи 1–6

Розв'язання завдань з Java у шаблоні Maven `djnzx/java-template`. Практичні 2–6 продовжують
роботу в репозиторії, створеному для Практичної 1; новий репозиторій створювати не потрібно.

## Структура

- `src/main/java/homework/h01/T1.java` — LeetCode 2413, **Smallest Even Multiple**.
- `src/main/java/homework/h01/T2.java` — LeetCode 1523, **Count Odd Numbers in an Interval Range**.
- `src/main/java/homework/h02/` — LeetCode 258 та 2119, Практична 2.
- `src/main/java/homework/h03/` — LeetCode 1491 та 2894, Практична 3.
- `src/main/java/homework/h04/` — LeetCode 461 та 476, Практична 4.
- `src/main/java/homework/h05/` — LeetCode 1913 та 977, Практична 5.
- `src/main/java/homework/h06/` — LeetCode 242 та 125, Практична 6.
- `src/test/java/homework/` — автоматичні тести.
- `docs/devops.md` — нотатки про термінал і файлову систему.
- `docs/git.md` — контроль версій та основний цикл роботи з Git.
- `docs/discussion.md` — відповіді на запитання для відкритої дискусії.
- `docs/devops-2.md`, `docs/git-2.md`, `docs/discussion-2.md` — матеріали Практичної 2.
- `docs/devops-3.md`, `docs/git-3.md`, `docs/discussion-3.md` — матеріали Практичної 3.
- `docs/devops-4.md`, `docs/git-4.md`, `docs/discussion-4.md` — матеріали Практичної 4.
- `docs/devops-5.md`, `docs/git-5.md`, `docs/discussion-5.md` — матеріали Практичної 5.
- `docs/devops-6.md`, `docs/git-6.md`, `docs/discussion-6.md` — матеріали Практичної 6.
- `evidence/` — скриншоти термінала, GitHub та результатів LeetCode.

## Як перевірити проєкт

Потрібні JDK 25 і Maven. У терміналі з кореня репозиторію виконайте:

```bash
mvn test
```

Окремо скомпілювати код можна так:

```bash
mvn compile
```

## Алгоритми

**2413.** Якщо `n` парне, відповідь — `n`. Якщо `n` непарне, найменше парне кратне — `2 * n`.
Часова складність: `O(1)`, додаткова пам'ять: `O(1)`.

**1523.** Кількість непарних чисел від `0` до `x` дорівнює `x / 2 + x % 2`.
Кількість на `[low, high]` — різниця цієї кількості для `high` і кількості непарних чисел до `low`.
Часова складність: `O(1)`, додаткова пам'ять: `O(1)`.

## Відправлення на LeetCode

У редакторі LeetCode треба використати сигнатуру з умови й назву класу `Solution`.
Методи з `T1` і `T2` можна скопіювати у відповідні класи `Solution`; пакет `homework.h01`
та назви класів `T1`/`T2` у LeetCode не потрібні. Після відправлення збережіть справжній
скриншот результату **Accepted** у своєму акаунті. Пароль або код підтвердження нікому не передавайте.

## Git

Репозиторій публічний і створений із шаблону:

<https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java>

Приклад основних команд для наступних змін:

```bash
git status
git add .
git commit -m "Complete practice 1"
git push
```

Пояснення до DevOps, Git і дискусійних запитань розміщені в `docs/`.

## Практична 2: Представлення цілих чисел

- **258 — Add Digits.** Цифровий корінь дорівнює `0` для нуля та
  `1 + (num - 1) % 9` для додатного числа. Час і пам'ять: `O(1)`.
- **2119 — A Number After a Double Reversal.** Подвійне перевертання змінює додатне число
  лише тоді, коли воно закінчується нулем. Час і пам'ять: `O(1)`.

### Підтвердження виконання

- [LeetCode 258 — Accepted](evidence/leetcode/258-add-digits.jpg).
- [LeetCode 2119 — Accepted](evidence/leetcode/2119-double-reversal.jpg).
- [DevOps — 8 скриншотів команд і результатів](evidence/devops/practice-2/).
- [Git — 5 скриншотів команд і результатів](evidence/git/practice-2/).
- [Відповіді для дискусії](docs/discussion-2.md).

Вправи термінала виконано зі смартфона. Для мобільної клавіатури використано адаптації:
додавання рядків лога у фоні та автоматична зупинка `tail -f` через `timeout`;
тимчасове зіставлення `jj` з Esc у Vim; тимчасова конфігурація Nano, де Enter зберігає
файл і завершує редактор. Це відрізняється від стандартних комбінацій Ctrl+O/Ctrl+X.
Видалення `.git` виконано лише в окремій тимчасовій копії навчального репозиторію.

Публічний репозиторій залишається тим самим для всіх практичних робіт:
<https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java>

## Практична 3: Представлення дробових чисел

- **1491 — Average Salary Excluding the Minimum and Maximum Salary.** Сума всіх зарплат
  мінус мінімальна й максимальна, поділена на кількість решти значень. Час `O(n)`,
  додаткова пам'ять `O(1)`.
- **2894 — Divisible and Non-divisible Sums Difference.** Для чисел від `1` до `n`
  додаємо число, якщо воно не ділиться на `m`, і віднімаємо, якщо ділиться. Час `O(n)`,
  додаткова пам'ять `O(1)`.

Відповіді для дискусії та команди DevOps/Git наведені у відповідних файлах `docs/*-3.md`.
Виконуй їх у Shell окремими блоками, у навчальній теці та локальному тимчасовому Git-репозиторії.
Допоміжні сценарії, які раніше запускали всі блоки автоматично, видалені.

### Підтвердження виконання

- [LeetCode 1491 — Accepted, 43/43 тести](evidence/leetcode/1491-average-salary.jpg).
- [LeetCode 2894 — Accepted, 737/737 тестів](evidence/leetcode/2894-sums-difference.jpg).
- [DevOps — 3 скриншоти команд і результатів](evidence/devops/practice-3/).
- [Git — 3 скриншоти staging area, часткового додавання та індексу](evidence/git/practice-3/).
- [Відповіді для дискусії](docs/discussion-3.md).

Скриншоти отримано під час виконання зі смартфона. Панелі телефона й браузера обрізано,
справжні команди, повідомлення й результати збережено. У Git-сценарії вибір фрагментів
автоматизовано через відповіді `y`/`n`, як зазначено вище.

Усі практичні роботи здаються за тим самим посиланням:
<https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java>

## Практична 4: Булева алгебра та бітові операції

- **461 — Hamming Distance:** <https://leetcode.com/problems/hamming-distance/>.
- **476 — Number Complement:** <https://leetcode.com/problems/number-complement/>.
- **461 — Hamming Distance.** Відстань Геммінга дорівнює кількості одиничних бітів у
  `x ^ y`: `Integer.bitCount(x ^ y)`. Час `O(1)` для 32-бітного `int`.
- **476 — Number Complement.** Створити маску з одиниць до старшого значущого біта та
  виконати XOR з `num`. Час `O(1)`, додаткова пам'ять `O(1)`.

Відповіді для дискусії, команди й пояснення DevOps/Git наведені у `docs/*-4.md`.
Код, тести, пояснення та отримані скриншоти практичної 4 розміщені в тому самому репозиторії:
<https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java>

### Підтвердження виконання

- [LeetCode 461 — Accepted, 149/149 тестів](evidence/leetcode/461-hamming-distance.jpg).
- [LeetCode 476 — Accepted, 154/154 тести](evidence/leetcode/476-number-complement.jpg).
- [Git — 5 скриншотів remote, tracking, відхиленого push та успішного злиття](docs/evidence-4.md).
- [DevOps — 5 скриншотів перенаправлення, конвеєрів, stdout/stderr і пошуку](docs/evidence-4.md#devops).

На скриншотах залишено тільки вміст завдань і термінала, без панелей телефона та браузера.
Навмисно відхилений push є частиною вправи: далі показано успішне злиття та push.

Команди та пояснення наведені у `docs/devops-4.md` і `docs/git-4.md`. Повторюй їх
окремими блоками з методички в ізольованій навчальній теці. Git-вправа не потребує
нового репозиторію GitHub.

## Практична 5: Масиви

- **1913 — Maximum Product Difference Between Two Pairs.** За один прохід знайти
  два найбільші й два найменші значення; відповідь — різниця їхніх добутків.
  Час `O(n)`, додаткова пам'ять `O(1)`.
- **977 — Squares of a Sorted Array.** Двома вказівниками порівнювати квадрати
  крайніх значень і заповнювати результат справа наліво. Час `O(n)`, додаткова
  пам'ять `O(n)`.

### Задачі LeetCode

- [1913 — Maximum Product Difference Between Two Pairs](https://leetcode.com/problems/maximum-product-difference-between-two-pairs/).
- [977 — Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/).
- [1913 — Accepted, 96/96 тестів](evidence/leetcode/1913-maximum-product-difference.jpg).
- [977 — Accepted, 137/137 тестів](evidence/leetcode/977-sorted-squares.jpg).

### DevOps, Git і дискусія

Команди, пояснення й відповіді для дискусії наведені у файлах `docs/*-5.md`.
Виконуй практичні команди в Shell окремими блоками, використовуючи тимчасові навчальні
теки та Git-репозиторії; допоміжні сценарії для пакетного запуску видалені.

Git-вправа використовує лише тимчасові локальні репозиторії та не виконує push.
У прикладі `.env` використано фальшиве навчальне значення, а не реальний секрет.

### Підтвердження виконання

- [DevOps — 5 скриншотів усіх частин](docs/evidence-5.md#devops).
- [Git — скриншоти `.gitignore`, `.env`, очищення та гілок](docs/evidence-5.md#git).
- [Відповіді для відкритої дискусії](docs/discussion-5.md).

## Практична 6: Символи, кодування та рядки

- [242 — Valid Anagram](https://leetcode.com/problems/valid-anagram/). Рішення рахує
  частоти Unicode code point, а не окремих UTF-16 `char`.
- [125 — Valid Palindrome](https://leetcode.com/problems/valid-palindrome/). Два вказівники
  рухаються по code point, пропускають неалфавітно-цифрові символи й порівнюють без урахування регістру.

Команди та пояснення до DevOps і Git наведені в `docs/devops-6.md` і `docs/git-6.md`;
відповіді для дискусії — у `docs/discussion-6.md`. У репозиторій не додаються Shell-файли.

### Підтвердження виконання

- Розв'язки Java: `src/main/java/homework/h06/T1.java` і `T2.java`.
- Автоматичні тести: `src/test/java/homework/h06/`.
- [242 — Accepted, 56/56 тестів](evidence/leetcode/242-valid-anagram.jpg).
- [125 — Accepted, 492/492 тести](evidence/leetcode/125-valid-palindrome.jpg).
- [Скриншоти LeetCode](docs/evidence-6.md).
- [DevOps — 11 скриншотів і пояснення мобільних адаптацій](docs/evidence-6.md#devops).
- [Git — 11 скриншотів, історія, пошук рядків і тег](docs/evidence-6.md#git).
- [Тег v1.0.0](https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java/tree/v1.0.0)
  позначає стан до додавання термінальних скриншотів.
