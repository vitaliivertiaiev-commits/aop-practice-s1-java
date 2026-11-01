# Практична 7. Git: порівняння версій

Вправи виконав у тимчасовому локальному репозиторії з файлом `f.txt`.

## 1–2. Робочі файли, індекс і коміт

Створив файл із рядками `один`, `два`, `три` та зробив початковий коміт.
Після додавання `чотири` команда `git diff` показала новий рядок.
Після `git add f.txt` цей diff став порожнім, але зміна залишилася в індексі.

| Команда | Що порівнює |
| --- | --- |
| `git diff` | Індекс і робочі файли |
| `git diff --staged` | Останній коміт та індекс |
| `git diff HEAD` | Останній коміт і робочі файли |

Потім дописав `пʼять` без `git add`. У звичайному diff було тільки `пʼять`,
у staged diff — тільки `чотири`, а в diff з `HEAD` — обидва рядки.

[До й після add](../screenshots/h07/git-01-unstaged-and-add.jpg) ·
[Порівняння з комітом](../screenshots/h07/git-02-staged-and-head.jpg) ·
[Різні стани](../screenshots/h07/git-03-three-states.jpg) ·
[Робочі файли проти HEAD](../screenshots/h07/git-04-working-tree-head.jpg)

## 3–5. Контекст, коміти та вибір файлу

Замінив вміст на `нуль`, `один`, `два`, `три` та порівняв контекст:

```bash
git diff
git diff -U0
git diff -U5
```

У заголовку `@@ -1,4 +1,4 @@` обидва фрагменти починаються з першого рядка
і містять по чотири рядки. `-U0` залишає лише зміни, `-U5` додає контекст.
Мінус позначає видалення зі старої версії, плюс — додавання в нову.

Після другого коміту виконав:

```bash
git diff HEAD~1 HEAD
git diff HEAD~1
```

Результати однакові, бо робочі файли відповідали останньому коміту.
Потім додав `other.txt` до індексу. Загальний `git diff --staged` показав його,
а `git diff --staged -- f.txt` був порожнім: у `f.txt` staged-змін не було.

[Звичайний контекст і -U0](../screenshots/h07/git-05-default-and-zero-context.jpg) ·
[-U5 і коміти](../screenshots/h07/git-06-context-and-commits.jpg) ·
[Порівняння версій](../screenshots/h07/git-07-commit-comparisons.jpg) ·
[Фільтр за файлом](../screenshots/h07/git-08-path-filter.jpg)

## 6–8. Статистика, слова й перевірка перед комітом

```bash
git diff --stat HEAD~1
git diff --shortstat HEAD~1
git diff --word-diff
```

Статистика показала два змінені файли й два додані рядки.
У `text.md` дописав «і детермінованим». Звичайний diff показав заміну рядка,
а `--word-diff` виділив змінені слова.

Перед комітом переглянув `git diff --staged`. Командою
`git restore --staged text.md` прибрав файл з індексу:
`status --short` показав `M text.md`, а правка залишилася у файлі.
Після повторного `add`, перевірки й коміту `status --short` був порожнім.

[Статистика](../screenshots/h07/git-09-statistics.jpg) ·
[Word diff](../screenshots/h07/git-10-word-diff.jpg) ·
[Зняття зі staging](../screenshots/h07/git-11-review-and-unstage.jpg) ·
[Коміт і чистий стан](../screenshots/h07/git-12-commit-and-clean-status.jpg)
