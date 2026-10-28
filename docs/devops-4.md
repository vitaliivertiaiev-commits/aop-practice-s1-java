# Практична 4: DevOps — перенаправлення, конвеєри та потоки

`stdin` — стандартний ввід, `stdout` — стандартний вивід, `stderr` — потік помилок.
Оператор `>` перенаправляє stdout у файл і перезаписує його; `>>` дописує. Конвеєр `|`
передає stdout наступній програмі. Помилки йдуть через stderr і не потрапляють у файл або
конвеєр, якщо їх явно не перенаправити.

Виконуйте команди в окремій навчальній теці, щоб не змішати створені файли з проєктом:

```bash
mkdir -p ~/dev/devops4
cd ~/dev/devops4
```

## 1. Перевірте `>` та `>>`

```bash
echo "перший рядок" > out.txt
cat out.txt
echo "другий рядок" > out.txt
cat out.txt
echo "третій рядок" >> out.txt
cat out.txt
```

Другий `>` замінює перший рядок, а `>>` додає третій рядок унизу.

## 2. Побудуйте конвеєр і порівняйте з прапорцем

```bash
seq 1 200 > numbers.txt
cat numbers.txt | grep 5
cat numbers.txt | grep 5 | wc -l
grep -c 5 numbers.txt
```

Дві останні команди мають порахувати однакову кількість рядків, що містять `5`.

## 3. Відсортуйте й порахуйте повтори

```bash
printf 'Іван\nОлена\nІван\nПетро\nОлена\nІван\n' > names.txt
sort names.txt
sort names.txt | uniq
sort names.txt | uniq -c
sort names.txt | uniq -c | sort -rn
```

`uniq` зливає лише сусідні однакові рядки, тому перед ним потрібен `sort`.

## 4. Відокремте stdout і stderr

```bash
ls . /no/such/dir
ls . /no/such/dir > out.txt
cat out.txt
ls . /no/such/dir 2> err.txt
cat err.txt
```

`>` перенаправляє лише stdout, тому помилка лишається на екрані. `2>` перенаправляє
stderr; у `out.txt` помилки немає, а в `err.txt` вона є.

## 5. Об'єднайте потоки або приховайте помилку

```bash
ls . /no/such/dir > all.txt 2>&1
cat all.txt
ls . /no/such/dir 2>/dev/null
```

Спочатку stdout спрямовується в `all.txt`, потім stderr прив'язується до stdout через
`2>&1`. `/dev/null` відкидає помилки.

## 6. Перевірте, що конвеєр не отримує stderr

```bash
ls . /no/such/dir | grep -c ""
ls . /no/such/dir 2>&1 | grep -c ""
```

Перша команда рахує лише рядки stdout, друга рахує також рядок помилки після злиття потоків.

## 7. Знайдіть файли та текст

```bash
find . -name "*.txt"
find . -name "*.txt" | wc -l
grep -rn "Іван" . | head
grep -rn "Іван" . | wc -l
```

Усі пошуки виконуються тільки в теці вправи, аби не сканувати інші файли проєкту.
