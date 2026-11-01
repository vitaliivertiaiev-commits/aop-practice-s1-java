# Практична 7. DevOps: порти й localhost

За завданням із `aop-practice-devops-7.docx`. Новий GitHub-репозиторій не потрібен.
Це не Java-код і не Shell-файл у репозиторії. PID та каталог сервера зберігаються
в тимчасових файлах: повернення браузера до нового Shell не зберігає його змінні.

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
python3 -m http.server 8000 --bind 127.0.0.1 --directory "$P7_WEB" > /tmp/aop-p7-http.log 2>&1 &
P7_HTTP=$!
printf '%s\n' "$P7_HTTP" > /tmp/aop-p7-http.pid
printf '%s\n' "$P7_WEB" > /tmp/aop-p7-http-root
for P7_WAIT in {1..30}; do
  if curl -fsS --max-time 1 http://127.0.0.1:8000 > /dev/null 2>&1; then break; fi
  sleep 1
done
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
Готовність перевіряється HTTP-запитом, а не фіксованою секундною затримкою:
поява PID ще не означає, що Python уже почав слухати порт.

## Знімок 2. Різні помилки й звільнення зайнятого порту — завдання 3–4

Сервер із першого блоку має працювати. Якщо він зник разом зі старим Shell,
не продовжувати вправу з порожнім PID: блок зупиниться з повідомленням.

```bash
{
date
whoami
P7_HTTP=$(cat /tmp/aop-p7-http.pid 2>/dev/null)
P7_WEB=$(cat /tmp/aop-p7-http-root 2>/dev/null)
if [ -n "$P7_HTTP" ] && [ -d "$P7_WEB" ] && \
   [ "$(lsof -t -nP -iTCP:8000 -sTCP:LISTEN)" = "$P7_HTTP" ] && \
   [ "$(ps -ww -p "$P7_HTTP" -o args=)" = "python3 -m http.server 8000 --bind 127.0.0.1 --directory $P7_WEB" ]; then
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
wait "$P7_HTTP" 2>/dev/null || true
echo '=== RESTART AFTER RELEASING THE PORT ==='
python3 -m http.server 8000 --bind 127.0.0.1 --directory "$P7_WEB" > /tmp/aop-p7-http.log 2>&1 &
P7_HTTP=$!
printf '%s\n' "$P7_HTTP" > /tmp/aop-p7-http.pid
for P7_WAIT in {1..30}; do
  if curl -fsS --max-time 1 http://127.0.0.1:8000 > /dev/null 2>&1; then break; fi
  sleep 1
done
lsof -i :8000
else
  echo 'STOP: demo server is missing or changed. Do not kill an unknown process.'
fi
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
P7_HTTP=$(cat /tmp/aop-p7-http.pid 2>/dev/null)
P7_WEB=$(cat /tmp/aop-p7-http-root 2>/dev/null)
if [ -n "$P7_HTTP" ] && \
   [ "$(lsof -t -nP -iTCP:8000 -sTCP:LISTEN)" = "$P7_HTTP" ] && \
   [ "$(ps -ww -p "$P7_HTTP" -o args=)" = "python3 -m http.server 8000 --bind 127.0.0.1 --directory $P7_WEB" ]; then
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
wait "$P7_HTTP" 2>/dev/null || true
echo '=== PORT 8000 AFTER CLEANUP ==='
lsof -i :8000
echo "lsof exit code: $?"
else
  echo 'STOP: demo server is missing or changed. Do not kill an unknown process.'
fi
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
