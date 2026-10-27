# DevOps: робота з файлами та редакторами

## Підготувати навчальну теку

Команди створюють окрему теку у домашній директорії, а не змінюють файли проєкту:

```bash
mkdir -p ~/dev/files-lab
cd ~/dev/files-lab
seq 1 200 > numbers.txt
printf 'перший\nдругий\nтретій\n' > notes.txt
ls -l
```

`seq` створює послідовність від 1 до 200. Оператор `>` записує її у файл і перезаписує
попередній вміст цього файлу.

## Переглянути короткий і довгий файл

```bash
cat notes.txt
cat numbers.txt
head -5 numbers.txt
tail -5 numbers.txt
less numbers.txt
```

`cat` зручний для коротких файлів. `head` і `tail` показують початок та кінець. У `less`
натисніть `/150`, потім `n` для наступного збігу й `q` для виходу.

## Стежити за логом у реальному часі

У першому терміналі:

```bash
cd ~/dev/files-lab
touch app.log
tail -f app.log
```

У другому терміналі:

```bash
cd ~/dev/files-lab
echo "запуск" >> app.log
echo "помилка" >> app.log
```

Нові рядки з'являться у першому вікні. Щоб зупинити `tail -f`, натисніть `Ctrl+C`.

## Копіювати, перейменовувати та переміщувати

```bash
cd ~/dev/files-lab
cp notes.txt notes-backup.txt
ls
mv notes-backup.txt notes-old.txt
ls
mkdir archive
mv notes-old.txt archive/
ls archive
```

`cp` створює копію. `mv` змінює шлях: та сама команда і перейменовує файл, і переміщує його.

## Вивчити безпечне видалення

Усі ці дії обмежені навчальною текою:

```bash
cd ~/dev/files-lab
touch to-delete.txt
ls
rm to-delete.txt
ls
mkdir -p danger/inner
touch danger/inner/file.txt
ls -R danger
rm -ri danger
```

`rm` видаляє файл без кошика. `rm -ri` перед видаленням кожного елемента просить підтвердження.
Під час навчання не запускайте `rm -rf` у теці проєкту або домашній теці.

## Вийти з vim і nano

Для `vim`:

```bash
cd ~/dev/files-lab
vim scratch.txt
```

Натисніть `i`, введіть текст, натисніть `Esc`, введіть `:wq` і натисніть Enter, щоб зберегти
та вийти. Перевірте файл командою `cat scratch.txt`. Щоб вийти без збереження: `Esc`, `:q!`,
Enter.

Для `nano`:

```bash
nano scratch.txt
```

Введіть ще один рядок, натисніть `Ctrl+O`, Enter для збереження, потім `Ctrl+X` для виходу.
Після вправи можна налаштувати nano як редактор Git:

```bash
git config --global core.editor "nano"
```

У мобільному Shell комбінації клавіш можуть бути незручними; якщо не вдається передати
`Ctrl`, не редагуйте системні файли — зупиніться й попросіть допомоги з клавіатурою.

## Що варто запам'ятати

- `cat` — короткий файл; `less` — довгий; `tail -f` — нові рядки лога.
- `mv` і перейменовує, і переміщує файл.
- `rm` не має скасування; `rm -i` або `rm -ri` допомагає перевіряти видалення.
- У `vim`: `i`, `Esc`, `:wq`, `:q!`.
