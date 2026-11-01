# Практична 7. DevOps: порти й localhost

## 1–2. HTTP-сервер

Запустив Python HTTP-сервер на порту 8000 і знайшов його процес через `lsof`.
Запити до `localhost` та `127.0.0.1` повернули однаковий вміст.
У заголовках відповіді — `200 OK`.

Використані команди:

```bash
python3 -m http.server 8000 --bind 127.0.0.1 &
lsof -i :8000
curl http://localhost:8000
curl http://127.0.0.1:8000
curl -i http://localhost:8000
```

`localhost` — ім'я локальної машини, `127.0.0.1` — її IPv4-адреса loopback.

[Скриншот](../screenshots/h07/devops-01-listener-and-http.jpg)

## 3–4. Помилки та зайнятий порт

Для відсутнього файлу сервер повернув `404 File not found`.
На порту 9999 сервера не було, тому `curl` завершився з кодом 7:
з'єднання не встановлено і HTTP-відповіді немає.

```bash
curl -i http://localhost:8000/no-such-file
curl --max-time 3 http://localhost:9999
echo $?
```

Повторний запуск сервера на тій самій адресі й порту дав
`Address already in use`. Знайшов PID слухача, завершив його через `kill`
і запустив сервер повторно. Новий процес отримав інший PID і відповів `200 OK`.

```bash
lsof -i :8000
kill "$P7_HTTP"
```

`P7_HTTP` — PID запущеного навчального сервера.

[Помилки](../screenshots/h07/devops-02-http-errors-and-busy-port.jpg) ·
[Зупинка й повторний запуск](../screenshots/h07/devops-03-stop-and-restart.jpg)

## 5–7. Список портів, nc і завершення сервера

Переглянув слухачів через `lsof` і `netstat`:

```bash
lsof -nP -iTCP -sTCP:LISTEN
netstat -an | grep LISTEN
```

Перевірив доступність двох портів:

```bash
nc -z -w 2 localhost 8000
echo $?
nc -z -w 2 localhost 9999
echo $?
jobs -l
```

Для відкритого порту 8000 код завершення — **0**, для закритого 9999 — **1**.
`nc` перевіряє TCP-з'єднання, а не вміст HTTP-відповіді.
Після завершення сервера `lsof -i :8000` не показав слухачів і повернув код **1**.

[lsof](../screenshots/h07/devops-06-all-tcp-listeners.jpg) ·
[netstat](../screenshots/h07/devops-04-netstat-listeners.jpg) ·
[nc, jobs і завершення](../screenshots/h07/devops-05-nc-and-cleanup.jpg)
