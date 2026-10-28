# Практична 5 — підтвердження виконання

Справжні скриншоти зі смартфона обрізано до вмісту LeetCode і термінала:
панелі телефона та браузера не включені.

## LeetCode

### 1913 — Maximum Product Difference Between Two Pairs

**Accepted — 96/96 тестів.**

![LeetCode 1913: Accepted](../evidence/leetcode/1913-maximum-product-difference.jpg)

### 977 — Squares of a Sorted Array

**Accepted — 137/137 тестів.**

![LeetCode 977: Accepted](../evidence/leetcode/977-sorted-squares.jpg)

## DevOps

Усі п'ять частин виконано: змінні й лапки; shebang та аргументи; права доступу;
`set -euo pipefail`; скрипт підрахунку файлів.

### 1. Змінні та лапки

![Змінні, присвоєння та лапки](../evidence/devops/practice-5/01-variables-quotes.jpg)

### 2. Shebang, аргументи й права на виконання

![Запуск greet.sh та chmod](../evidence/devops/practice-5/02-shebang-arguments.jpg)

### 3. `./script.sh` і `bash script.sh`

![Порівняння способів запуску](../evidence/devops/practice-5/03-execution-methods.jpg)

### 4. Безпечна зупинка після помилки

![Порівняння unsafe.sh та safe.sh](../evidence/devops/practice-5/04-safe-scripts.jpg)

### 5. `set -u` і підрахунок файлів за розширенням

![Перевірка змінної та count.sh](../evidence/devops/practice-5/05-strict-mode-count.jpg)

## Git

Демонстрація виконана в окремому тимчасовому репозиторії; справжні дані й історія
репозиторію GitHub не змінювалися. Значення в прикладі `.env` є фальшивим.

### 1. Ігнорування збірки та локальних налаштувань

![Початковий статус і .gitignore](../evidence/git/practice-5/01-gitignore-basics.jpg)

### 2. `.env`: відстеження та `git rm --cached`

![Вилучення env-файла з індексу без видалення з диска](../evidence/git/practice-5/02-env-cached.jpg)

### 3. Шаблони й винятки

![Шаблони .gitignore](../evidence/git/practice-5/03-patterns-clean.jpg)

### 4. `git check-ignore` та безпечний `git clean`

Спершу показано `git clean -n`, потім — очищення лише навчального репозиторію.

![Перевірка правил та очищення](../evidence/git/practice-5/04-check-ignore-clean.jpg)

### 5. Відстеження файла у двох гілках

![Файл на гілці draft та відновлення на main](../evidence/git/practice-5/05-branch-move.jpg)

![Перевірка дерев гілок і чистого статусу](../evidence/git/practice-5/06-branch-complete.jpg)
