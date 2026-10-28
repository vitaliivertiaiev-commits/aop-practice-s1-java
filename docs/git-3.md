# Практична 3: Git — staging area та index

Виконуйте навчальну частину в окремому тимчасовому репозиторії, щоб не змішати її коміти
з історією персонального репозиторію.

## 1. Створіть репозиторій і початковий коміт

```bash
mkdir -p ~/dev
LAB=$(mktemp -d ~/dev/git-lab-p3.XXXXXX)
cd "$LAB"
git init
printf 'алгоритм\nмасив\nсловник\nдерево\nмножина\nчерга\nстек\nграфи\n' > terms.txt
echo "чернетка" > draft.txt
git add terms.txt draft.txt
git commit -m "початковий стан"
```

## 2. Підготуйте дві зміни, але застейджте одну

```bash
echo "рекурсія" >> terms.txt
echo "ще одна чернетка" >> draft.txt
git add terms.txt
git status -s
```

У `git status -s` лівий символ показує стан у staging area, правий — незастейджену зміну.
Тут `terms.txt` застейджений, а `draft.txt` — ні.

## 3. Перевірте, що коміт містить лише вибрану зміну

```bash
git commit -m "додати термін рекурсія"
git status -s
git show --stat HEAD
```

Коміт містить `terms.txt`; зміна `draft.txt` лишається у робочій теці.

## 4. Розділіть зміни в одному файлі

```bash
sed -i '1s/алгоритм/сортування/; 8s/графи/граф/' terms.txt
git add -p --unified=1 terms.txt
```

Git покаже два окремі шматки з одним рядком контексту. Натисніть `y` для заміни на
`сортування` та `n` для заміни на `граф`. Перевірте обидва стани:

```bash
git status -s
git diff --cached
git diff
```

## 5. Заберіть зміну зі staging area, не скасовуючи редагування

```bash
git restore --staged terms.txt
git status -s
```

`restore --staged` прибирає підготовку до коміту, але залишає текстові зміни у файлі.

## 6. Порівняйте повідомлення комітів

```bash
git add draft.txt
git commit -m "fix: зберегти чернетку"
git add terms.txt
git commit -m "додати терміни сортування і граф для словника"
git log --oneline
```

Коротке повідомлення має називати зміну; описове пояснює, що саме додано. Не залишайте
зміни випадково поза комітом: перевіряйте `git status`.

## 7. Подивіться на staging area як на `.git/index`

```bash
ls -l .git/index
git ls-files -s
echo "ще один термін" >> terms.txt
git ls-files -s
git add terms.txt
git ls-files -s
git status -s
```

Після редагування без `git add` індекс не змінюється; після `git add` у ньому з'являється
нова версія файла. `git ls-files -s` показує режим, хеш blob, номер stage і шлях.

## 8. Персональний репозиторій

Практичну 3 комітьте й надсилайте до вже створеного персонального репозиторію — новий
репозиторій GitHub не створюйте:

```bash
git status
git add .
git commit -m "Complete practice 3"
git push
```

Навчальні коміти з `~/dev/git-lab-p3.*` залишаються локальними та не потрапляють у цей push.
