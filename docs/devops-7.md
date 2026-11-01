# Практична 7. DevOps: порти й localhost

За завданням із `aop-practice-devops-7.docx`. Новий GitHub-репозиторій не потрібен.
Усі команди вводяться в одному вікні Shell. Це не Java-код і не Shell-файл у репозиторії.

Потрібні `python3`, `curl`, `lsof`, `nc`, `netstat`; додатково можна використати `ss`.
Спочатку виконати `lsof -nP -iTCP:8000 -sTCP:LISTEN` та
`lsof -nP -iTCP:9999 -sTCP:LISTEN`. Очікується порожній вивід.
Якщо якийсь порт зайнятий, не завершувати невідомий процес — спочатку з'ясувати, що це.

## Знімок 1. Слухач і три HTTP-запити — завдання 1–2

Вставити весь блок, натиснути Enter після `}`. Дочекатися нового запрошення Shell.

```bash
{
date
whoami
mkdir -p "$HOME/dev/files-lab"
P7_WEB=$(mktemp -d "$HOME/dev/files-lab/practice-7.XXXXXX")
cd "$P7_WEB"
printf 'Practice 7: localhost\n' > index.html
python3 -m http.server 8000 --bind 127.0.0.1 > /tmp/aop-p7-http.log 2>&1 &
P7_HTTP=$!
sleep 1
echo '=== WHO LISTENS ON 8000 ==='
lsof -i :8000
echo '=== LOCALHOST ==='
curl --max-time 3 http://localhost:8000
echo '=== LOOPBACK IP ==='
curl --max-time 3 http://127.0.0.1:8000
echo '=== HEADERS ==='
curl -i --max-time 3 http://localhost:8000
}
```

Зняти кадр із датою/ім'ям, PID слухача, відповідями та `HTTP/1.0 200 OK`.
Перші два запити повертають однаковий текст.

Мобільні адаптації: окрема свіжа папка всередині `~/dev/files-lab/` з коротким
`index.html` замість довгого списку файлів; прив'язка до `127.0.0.1`, щоб не
відкривати навчальний сервер назовні; лог у тимчасовому файлі, щоб його рядки
не перемішувалися з відповідями. Це той самий HTTP-сервер на порту 8000.

## Знімок 2. Різні помилки й звільнення зайнятого порту — завдання 3–4

Залишатися в тому самому Shell, сервер із першого блоку має працювати.

```bash
{
date
whoami
echo '=== HTTP ERROR: SERVER ANSWERED ==='
curl -i --max-time 3 http://localhost:8000/no-such-file
echo '=== CONNECTION ERROR: NO SERVER ==='
curl -i --max-time 3 http://localhost:9999
echo "curl exit code: $?"
echo '=== TRY TO USE THE SAME PORT ==='
timeout 3s python3 -m http.server 8000 --bind 127.0.0.1
echo '=== OWNER OF THE BUSY PORT ==='
lsof -i :8000
echo "Stopping only our demo server: $P7_HTTP"
kill "$P7_HTTP"
wait "$P7_HTTP"
echo '=== RESTART AFTER RELEASING THE PORT ==='
python3 -m http.server 8000 --bind 127.0.0.1 > /tmp/aop-p7-http.log 2>&1 &
P7_HTTP=$!
sleep 1
lsof -i :8000
}
```

Зняти кадр із `404`, помилкою з'єднання на 9999, `Address already in use`,
PID старого та нового серверів. Якщо все не вміщується, зробити два кадри.
`timeout` — страховка від зависання, а не причина очікуваної помилки зайнятого порту.
Завершуємо лише сервер, запущений нами, а не всі процеси `python3`.

## Знімок 3. Усі порти, nc і прибирання — завдання 5–7

```bash
{
date
whoami
echo '=== ALL TCP LISTENERS ==='
lsof -nP -iTCP -sTCP:LISTEN
echo '=== NETSTAT LISTENERS ==='
netstat -an | grep LISTEN
echo '=== NC: OPEN PORT ==='
nc -z -w 2 localhost 8000
echo "exit code: $?"
echo '=== NC: CLOSED PORT ==='
nc -z -w 2 localhost 9999
echo "exit code: $?"
echo '=== OUR SHELL JOBS ==='
jobs -l
echo "Stopping our server: $P7_HTTP"
kill "$P7_HTTP"
wait "$P7_HTTP"
echo '=== PORT 8000 AFTER CLEANUP ==='
lsof -i :8000
echo "lsof exit code: $?"
}
```

`nc` для 8000 має повернути **0**, для 9999 — **1**. Після завершення сервера
`lsof` не виводить слухача; exit code **1** тут означає відсутність збігів.
Для прибирання використано PID замість `%1`: номер завдання в чужому Shell
може бути іншим. `jobs -l` показує зв'язок номера job із PID.

Якщо список усіх портів довгий, зняти його окремо, а потім зняти `nc` і прибирання.
Додатковий Linux-варіант зі списку завдання: `ss -tlnp`.

## Що потрібно розуміти

- `localhost` — ім'я локальної машини; `127.0.0.1` — її IPv4 loopback-адреса.
  Ім'я також може резолвитися в IPv6 `::1`; клієнти можуть спробувати обидва варіанти.
- `lsof -i :8000` знаходить процеси, пов'язані з портом, включно з клієнтами;
  `lsof -nP -iTCP:8000 -sTCP:LISTEN` звужує результат до TCP-слухачів.
- 404 — HTTP-відповідь від доступного сервера; помилка з'єднання — HTTP-відповіді немає.
- У звичайному сценарії без спеціального спільного використання сокетів
  другий слухач на тій самій адресі й TCP-порту отримує `Address already in use`.
- Номер порту сам по собі не визначає протокол: HTTP на 8000 — вибір цього запуску.
- `nc -z` перевіряє встановлення TCP-з'єднання, а не правильність HTTP-відповіді.

Знімки потрібно зберегти в `screenshots/h07/` з префіксом `devops-`.
До отримання справжніх знімків ця частина не позначається як здана.
