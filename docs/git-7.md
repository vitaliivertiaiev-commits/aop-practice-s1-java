# Практична 7. Git: порівняння версій

За завданням із `aop-practice-git-7.docx`. Вправа виконується в окремому
**тимчасовому локальному** репозиторії — це прямо передбачено листком завдання.
Новий репозиторій на GitHub не створюється, історія практичних не змінюється.

Вставляти кожен блок цілком і натискати Enter після `}`.
Шлях до тимчасового репозиторію зберігається у файлі й перечитується наступними
блоками: змінні попереднього Shell можуть зникнути. Дата й користувач мають
залишитися в кадрі. На паузах `SCREEN` зробити знімок кнопками телефона
та натиснути Enter; повертатися до чату після завершення всього блоку.

## Знімок 1. Три пари станів — завдання 1–2

```bash
{
date
whoami
P7_DIFF=$(mktemp -d /tmp/aop-diff-demo-7.XXXXXX)
printf '%s\n' "$P7_DIFF" > /tmp/aop-p7-diff-repo
git -C "$P7_DIFF" init -q
git -C "$P7_DIFF" config user.name 'Practice 7 Demo'
git -C "$P7_DIFF" config user.email 'practice7@example.invalid'
git -C "$P7_DIFF" config core.quotePath false
git -C "$P7_DIFF" config core.pager cat
printf 'один\nдва\nтри\n' > "$P7_DIFF/f.txt"
git -C "$P7_DIFF" add f.txt
git -C "$P7_DIFF" commit -qm 'початок'
printf 'чотири\n' >> "$P7_DIFF/f.txt"
echo '=== UNSTAGED CHANGE ==='
git -C "$P7_DIFF" --no-pager diff
git -C "$P7_DIFF" add f.txt
echo '=== AFTER ADD: DIFF IS EMPTY ==='
git -C "$P7_DIFF" --no-pager diff
date
whoami
read -r -p 'SCREEN 1: take screenshot, then press Enter. ' P7_ENTER
echo '=== STAGED VERSUS COMMIT ==='
git -C "$P7_DIFF" --no-pager diff --staged
echo '=== WORKING TREE VERSUS COMMIT ==='
git -C "$P7_DIFF" --no-pager diff HEAD
date
whoami
read -r -p 'SCREEN 2: take screenshot, then press Enter. ' P7_ENTER
printf 'пʼять\n' >> "$P7_DIFF/f.txt"
echo '=== AFTER FIFTH LINE: WORKING TREE VS INDEX ==='
git -C "$P7_DIFF" --no-pager diff
echo '=== AFTER FIFTH LINE: INDEX VS HEAD ==='
git -C "$P7_DIFF" --no-pager diff --staged
date
whoami
read -r -p 'SCREEN 3: take screenshot, then press Enter. ' P7_ENTER
echo '=== AFTER FIFTH LINE: WORKING TREE VS HEAD ==='
git -C "$P7_DIFF" --no-pager diff HEAD
date
whoami
echo 'SCREEN 4: take screenshot. Block finished.'
}
```

Зняти початкову зміну, порожній diff після add і три різні відповіді
після додавання `пʼять`. За потреби зробити кілька кадрів прокручування.
Демонстраційні ім'я й адреса налаштовані тільки всередині тимчасової вправи,
не в особистому репозиторії й не глобально.

| Команда | Ліва сторона | Права сторона |
| --- | --- | --- |
| `git diff` | index | working tree |
| `git diff --staged` | HEAD | index |
| `git diff HEAD` | HEAD | working tree |

Мінус у diff належить лівій стороні, плюс — правій.

## Знімок 2. Hunk, контекст, коміти та шлях — завдання 3–5

```bash
{
date
whoami
P7_DIFF=$(cat /tmp/aop-p7-diff-repo 2>/dev/null)
if [ -n "$P7_DIFF" ] && [ -d "$P7_DIFF/.git" ]; then
printf 'нуль\nодин\nдва\nтри\n' > "$P7_DIFF/f.txt"
echo '=== DEFAULT CONTEXT ==='
git -C "$P7_DIFF" --no-pager diff
echo '=== ZERO CONTEXT ==='
git -C "$P7_DIFF" --no-pager diff -U0
echo '=== FIVE CONTEXT LINES ==='
git -C "$P7_DIFF" --no-pager diff -U5
git -C "$P7_DIFF" add f.txt
git -C "$P7_DIFF" commit -qm 'друга версія'
git -C "$P7_DIFF" --no-pager log --oneline
echo '=== TWO COMMITS ==='
git -C "$P7_DIFF" --no-pager diff HEAD~1 HEAD
echo '=== OLD COMMIT VERSUS CLEAN WORKING TREE ==='
git -C "$P7_DIFF" --no-pager diff HEAD~1
printf 'інший файл\n' > "$P7_DIFF/other.txt"
git -C "$P7_DIFF" add other.txt
echo '=== ALL STAGED PATHS ==='
git -C "$P7_DIFF" --no-pager diff --staged
echo '=== ONLY F.TXT: EMPTY ==='
git -C "$P7_DIFF" --no-pager diff --staged -- f.txt
else
  echo 'STOP: temporary demo repository is missing. Do not use the coursework repository.'
fi
}
```

Для першого `git diff` тут очікується `@@ -1,4 +1,4 @@`:
зі старої версії з рядка 1 показано 4 рядки, з нової — також з рядка 1 показано 4.
Стара сторона — **index**, де вже є `чотири`, не перший коміт.
`-U0` показує окремі мінімальні фрагменти, `-U5` — ширший контекст.
Два порівняння `HEAD~1` збігаються саме тому, що working tree після коміту чистий.
Після staging `other.txt` загальний staged diff непорожній,
але обмежений `-- f.txt` порожній: цей шлях не змінено.

## Знімок 3. Масштаб, слова й огляд перед комітом — завдання 6–8

```bash
{
date
whoami
P7_DIFF=$(cat /tmp/aop-p7-diff-repo 2>/dev/null)
if [ -n "$P7_DIFF" ] && [ -d "$P7_DIFF/.git" ]; then
echo '=== CHANGE SCALE ==='
git -C "$P7_DIFF" --no-pager diff --stat HEAD~1
git -C "$P7_DIFF" --no-pager diff --shortstat HEAD~1
printf 'Алгоритм має бути скінченним.\n' > "$P7_DIFF/text.md"
git -C "$P7_DIFF" add text.md
git -C "$P7_DIFF" --no-pager diff --staged
git -C "$P7_DIFF" commit -qm 'текст'
printf 'Алгоритм має бути скінченним і детермінованим.\n' > "$P7_DIFF/text.md"
echo '=== WHOLE LINE ==='
git -C "$P7_DIFF" --no-pager diff
echo '=== CHANGED WORDS ==='
git -C "$P7_DIFF" --no-pager diff --word-diff
git -C "$P7_DIFF" add text.md
echo '=== REVIEW BEFORE COMMIT ==='
git -C "$P7_DIFF" --no-pager diff --staged
echo '=== UNSTAGE WITHOUT LOSING THE EDIT ==='
git -C "$P7_DIFF" restore --staged text.md
git -C "$P7_DIFF" status --short
echo '=== STAGE, REVIEW, THEN COMMIT ==='
git -C "$P7_DIFF" add text.md
git -C "$P7_DIFF" --no-pager diff --staged
git -C "$P7_DIFF" commit -qm 'уточнити властивості алгоритму'
git -C "$P7_DIFF" status --short
else
  echo 'STOP: temporary demo repository is missing. Do not use the coursework repository.'
fi
}
```

Коміт `текст`, як і в листку, включає вже підготовлений `other.txt`.
У `--word-diff` без змін `скінченним.` і `скінченним` не тотожні через крапку,
тому Git може позначити заміну цього слова разом із доданими словами.
`restore --staged` прибирає файл із index, але не стирає редагування.
Останній порожній `status --short` показує чистий стан демонстраційного репозиторію.

Знімки потрібно зберегти в `screenshots/h07/` з префіксом `git-`.
Якщо довгі виводи не вміщуються, дозволено більше трьох кадрів — важливе
підтвердження всіх восьми вправ, а не лише заголовків.

Перед комітом справжньої практичної в особистому репозиторії також переглядати
`git diff --staged`. Команди вправи з `/tmp/` не потрібно запускати в ньому.
