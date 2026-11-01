# Перевірка практичних 1–6 за критеріями A–G

Репозиторій: <https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java>.

Цей документ відокремлює перевірений код від вимог до доказів виконання.
Наявність правильного розв'язку не замінює потрібний скриншот.

## A–D. Репозиторій, структура, іменування та документація

- Усі 12 розв'язків знаходяться в одному репозиторії, по два на заняття.
- Класи: `src/main/java/homework/hNN/T1.java` та `T2.java`.
- Тести: `src/test/java/homework/hNN/T1Test.java` та `T2Test.java`.
- Шаблонні `app/HelloWorldApp`, `code/Calculator` та їхні тести видалено.
- `pom.xml` і `.gitignore` збережено без змін; ціль компіляції — JDK 25.
- У Git немає `target/`, `.idea/`, `.class`, `.iml`, Shell-скриптів чи сторонніх файлів у `src/`.
- Перед кожним класом розв'язку стоїть прямий URL відповідної задачі LeetCode.
- Інших коментарів, Javadoc, TODO, закоментованого коду або діагностичного друку в Java немає.
- Імена пакетів, файлів і класів відповідають структурі; короткі параметри замінено змістовними.
- Нотатки знаходяться в `docs/`, зображення — у `screenshots/hNN/`.
- Історія попередніх комітів збережена; зміни надсилаються через Git.

Посилання на репозиторій потрібно самостійно подати в classroom. Наявність посилання
в цьому README не підтверджує, що його вже здано викладачеві.

## E. Збірка

Команди для перевірки з кореня чистої копії на **OpenJDK 25.0.2**:

```bash
mvn clean compile
mvn test-compile
mvn test
mvn spotless:check
```

Перевірено 1 листопада 2026 року на чистому локальному `git clone`
збереженого коміту, без файлів, відсутніх у Git:

| Критерій | Команда | Результат |
| --- | --- | --- |
| E1 | `mvn clean compile` | BUILD SUCCESS |
| E2 | `mvn test-compile` | BUILD SUCCESS |
| E3 | `mvn test` | BUILD SUCCESS; 111 тестів, 0 failures, 0 errors, 0 skipped |
| E4 | `mvn spotless:check` | BUILD SUCCESS |

Після всіх чотирьох команд `git status --short` порожній:
збірка не змінила жодного відстежуваного файла.

## F. Тести

- У кожного з 12 розв'язків є власний тестовий клас.
- У кожному тесті є перевірка AssertJ: `assertThat` або `assertThatThrownBy`.
- Кожен приклад LeetCode оформлено окремим тестовим методом.
- Перевірено мінімальні й максимальні допустимі значення та довжини.
- Додано порожні рядки/масиви, одиничні елементи, повтори, помилкові аргументи,
  а також перевірки незмінності вхідних масивів, де це застосовно.
- Тести детерміновані: не читають файли, мережу, поточний час або випадкові значення.
- На JDK 25 виконано **111 тестів: 0 failures, 0 errors, 0 skipped**.
- JaCoCo 0.8.14 підтвердив **100% покриття рядків і гілок** усіх 12 розв'язків:
  120 із 120 рядків і 76 із 76 гілок.
  Клас `h04/T1` не має умовних гілок; його рядки також покрито повністю.

JaCoCo запускався окремо через Maven, без зміни шаблонного `pom.xml`:

```bash
mvn org.jacoco:jacoco-maven-plugin:0.8.14:prepare-agent test \
  org.jacoco:jacoco-maven-plugin:0.8.14:report
```

Згенерований звіт знаходиться в локальному `target/site/jacoco/` і не додається до Git.

## G. Скриншоти: що є та що потрібно оновити

| Заняття | T1 | T2 | Папка зі скриншотами |
| --- | --- | --- | --- |
| 1 | [2413 — Smallest Even Multiple](https://leetcode.com/problems/smallest-even-multiple/) | [1523 — Count Odd Numbers in an Interval Range](https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/) | [h01](../screenshots/h01/) |
| 2 | [258 — Add Digits](https://leetcode.com/problems/add-digits/) | [2119 — A Number After a Double Reversal](https://leetcode.com/problems/a-number-after-a-double-reversal/) | [h02](../screenshots/h02/) |
| 3 | [1491 — Average Salary Excluding the Minimum and Maximum Salary](https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/) | [2894 — Divisible and Non-divisible Sums Difference](https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/) | [h03](../screenshots/h03/) |
| 4 | [461 — Hamming Distance](https://leetcode.com/problems/hamming-distance/) | [476 — Number Complement](https://leetcode.com/problems/number-complement/) | [h04](../screenshots/h04/) |
| 5 | [1913 — Maximum Product Difference Between Two Pairs](https://leetcode.com/problems/maximum-product-difference-between-two-pairs/) | [977 — Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/) | [h05](../screenshots/h05/) |
| 6 | [242 — Valid Anagram](https://leetcode.com/problems/valid-anagram/) | [125 — Valid Palindrome](https://leetcode.com/problems/valid-palindrome/) | [h06](../screenshots/h06/) |

Всього перенесено **84 справжні скриншоти**. Для кожного заняття є по два знімки
Accepted та щонайменше три знімки Git і три DevOps. Назви починаються з
`t1-leetcode`, `t2-leetcode`, `git-` або `devops-`. Посилання в документації оновлено.

**G1 поки не закрито повністю:** у наявних 12 знімках Accepted не видно одночасно
повного номера й назви задачі. Назва файла або підпис у README не замінюють
номер і назву на самому знімку. Потрібні нові знімки зі свого акаунта, де одночасно видно:

1. Номер і повну назву задачі.
2. Статус **Accepted**.
3. Дату й час або ім'я користувача.

Повторно розв'язувати задачі не потрібно: можна відкрити власне успішне
відправлення. Не слід домальовувати номер, назву чи результат поверх зображення.
Знімки потрібно замінити у відповідних `screenshots/hNN/t1-leetcode.jpg`
і `t2-leetcode.jpg`.

**G4 поки не закрито:** потрібен один справжній скриншот власного профілю LeetCode
з видимими іменем користувача та загальною кількістю розв'язаних задач
**не менше 12**. Очікуваний файл: `screenshots/leetcode-total.png`
(або `.jpg` відповідно до справжнього формату).

**Загальна вимога G до дати/часу або імені користувача:** частина старих
термінальних знімків обрізана до команд і результатів та не містить цієї позначки.
Їх не можна вважати безумовним підтвердженням цієї вимоги. Для оновлених
термінальних знімків перед командами потрібно виконати `date` та `whoami`
і залишити їхній вивід у кадрі разом із командами й результатом вправи.
Фотографувати весь екран телефона не потрібно.

У документації практичних збережено пояснення мобільних адаптацій.
Перенесення зображень не означає повторного виконання всіх вправ
або доказу натискання фізичних Ctrl+C/Ctrl+Z.
