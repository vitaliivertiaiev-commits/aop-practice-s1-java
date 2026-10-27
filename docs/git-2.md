# Git: перший репозиторій і його історія

## Створити тестовий репозиторій

Працюйте лише в `/tmp/first-repo`, а не в репозиторії домашніх завдань:

```bash
mkdir -p /tmp/first-repo
cd /tmp/first-repo
git init
ls -a
ls .git
```

Репозиторій — це тека з файлами та прихованою текою `.git`, де Git зберігає історію,
налаштування й посилання на поточну гілку.

## Побачити три стани `git status`

```bash
cd /tmp/first-repo
echo "перший рядок" > notes.txt
git status
git add notes.txt
git status
git commit -m "first commit"
git status
```

Спочатку файл не відстежується (`untracked`), після `git add` він підготовлений до коміту,
після `git commit` робоча тека чиста.

## Переглянути коміт і його вміст

```bash
git log
git show HEAD
```

`git log` показує історію комітів. `git show HEAD` показує поточний коміт та його зміни.
`HEAD` позначає поточне положення в історії.

## Порівняти повні знімки двох комітів

```bash
echo "текст" > second.txt
git add second.txt
git commit -m "add second file"
git ls-tree HEAD
git ls-tree HEAD~1
```

`git ls-tree HEAD` показує файли в поточному коміті; `HEAD~1` — у попередньому. Коміт містить
повний знімок стану проєкту, а не лише змінений файл.

## Порівняти `init` і `clone`

```bash
cd /tmp/first-repo
git remote -v
```

У репозиторії після `git init` немає віддаленої адреси. У клоні навчального репозиторію
перевірте `git remote -v`: там має бути `origin`.

> Для Практичної 2 використовуйте вже наявний публічний репозиторій
> `vitaliivertiaiev-commits/aop-practice-s1-java`. Новий репозиторій на GitHub не створюйте.

Якщо потрібна окрема локальна копія для вправи, її можна отримати так:

```bash
git clone https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java.git \
  ~/dev/aop-practice-2-log
cd ~/dev/aop-practice-2-log
git remote -v
```

## Переконатися, що історія зберігається в `.git`

Наступна небезпечна команда застосовується лише до тимчасової копії:

```bash
cd /tmp
cp -r first-repo repo-copy
cd repo-copy
git log --oneline
rm -rf .git
ls
git log --oneline
```

Після видалення `.git` звичайні файли залишаються, але історія зникає. **Не запускайте
`rm -rf .git` у робочому репозиторії практичної.** У цій вправі вона видаляє `.git` лише
з копії `/tmp/repo-copy`.

## Прочитати файли Git

У корені репозиторію:

```bash
cat .git/HEAD
cat .git/config
```

`HEAD` посилається на поточну гілку. `.git/config` містить локальні параметри репозиторію,
зокрема адресу `origin`, якщо це клон.
