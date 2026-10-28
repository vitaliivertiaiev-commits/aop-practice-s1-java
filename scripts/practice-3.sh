#!/usr/bin/env bash
# Реальні навчальні команди, згруповані для запуску зі смартфона.
set -eu

run() {
    printf '\n$'
    printf ' %q' "$@"
    printf '\n'
    "$@"
}

pause() {
    printf '\n--- Зроби скриншот цієї частини. Потім натисни Enter. ---\n'
    if [ -t 0 ]; then
        read -r _
    fi
}

mkdir -p "$HOME/dev"

case "${1:-}" in
    devops)
        LAB=$(mktemp -d "$HOME/dev/commands-p3.XXXXXX")
        cd "$LAB"
        printf 'Приклад файла для перевірки команд.\n' > example.txt
        printf '\n=== DEVOPS 1: прапорці та довідка ===\n'
        run ls -l -a .
        run ls -la .
        run ls -l --all .
        printf '\n$ ls --help | head -15\n'
        ls --help | head -15
        printf '\n$ man -P cat ls | grep -i -A 2 human\n'
        if man -P cat ls > manual.txt 2> manual-error.txt; then
            grep -i -A 2 human manual.txt | head -12 || true
        else
            cat manual-error.txt
            printf 'Локальна сторінка відсутня. Завантажуємо справжню сторінку GNU coreutils із Debian manpages.\n'
            run curl --fail --location --silent --show-error --max-time 30 \
                https://manpages.debian.org/trixie/coreutils/ls.1.en.gz -o ls.1
            printf '\n$ man -P cat -l ls.1 | grep -i -A 2 human\n'
            man -P cat -l ls.1 > manual.txt
            grep -i -A 2 human manual.txt | head -12
        fi
        run ls -lh .
        pause

        printf '\n=== DEVOPS 2: помилки та коди завершення ===\n'
        run cat no-such-file.txt || printf 'exit=%s\n' "$?"
        run bash -c 'cd /no/such/dir' || printf 'exit=%s\n' "$?"
        run ls --definitely-unknown-option || printf 'exit=%s\n' "$?"
        printf '\n$ ls -Z .  # у GNU ls це відомий прапорець\n'
        ls -Z .
        printf '\n$ ls . >/dev/null; echo $?\n'
        ls . >/dev/null; echo "$?"
        printf '\n$ ls /no/such/dir; echo $?\n'
        if ls /no/such/dir; then echo 0; else echo "$?"; fi
        printf '\n$ true; echo $?\n'; true; echo "$?"
        printf '\n$ false; echo $?\n'
        if false; then echo 0; else echo "$?"; fi
        pause

        printf '\n=== DEVOPS 3: && та пошук програм ===\n'
        printf '\n$ mkdir -p ok-dir && cd ok-dir && echo "успіх"\n'
        mkdir -p ok-dir && cd ok-dir && echo "успіх"
        printf '\n$ cd /no/such/dir && echo "цього не буде надруковано"\n'
        (cd /no/such/dir && echo "цього не буде надруковано") || true
        run type ls
        run type cd
        run command -v java
        run which git
        pause
        ;;
    git)
        LAB=$(mktemp -d "$HOME/dev/staging-p3.XXXXXX")
        cd "$LAB"
        printf '\n=== GIT 1: один файл в індексі, другий лише на диску ===\n'
        run git init
        printf 'алгоритм\nмасив\nсловник\nдерево\nмножина\nчерга\nстек\nграфи\n' > terms.txt
        printf 'чернетка\n' > draft.txt
        run git add terms.txt draft.txt
        run git commit -m 'початковий стан'
        printf 'рекурсія\n' >> terms.txt
        printf 'ще одна чернетка\n' >> draft.txt
        run git add terms.txt
        run git status -s
        run git commit -m 'додати термін рекурсія'
        run git status -s
        run git --no-pager show --stat --oneline HEAD
        pause

        printf '\n=== GIT 2: часткове додавання та скасування staging ===\n'
        run sed -i '1s/алгоритм/сортування/; 8s/графи/граф/' terms.txt
        printf '\n$ printf "y\\nn\\n" | git add -p --unified=1 terms.txt\n'
        printf 'y\nn\n' | git add -p --unified=1 terms.txt
        run git status -s
        run git --no-pager diff --cached
        run git --no-pager diff -- terms.txt
        run git restore --staged terms.txt
        run git status -s
        pause

        printf '\n=== GIT 3: повідомлення та вміст індексу ===\n'
        run git add draft.txt
        run git commit -m fix
        run git add terms.txt
        run git commit -m 'додати терміни, щоб словник охоплював сортування та графи'
        run git --no-pager log --oneline
        run ls -l .git/index
        run git ls-files -s
        printf '\n$ echo "ще один термін" >> terms.txt\n'
        printf 'ще один термін\n' >> terms.txt
        printf '\nІндекс після редагування без add:\n'
        run git ls-files -s
        run git add terms.txt
        printf '\nІндекс після add:\n'
        run git ls-files -s
        run git status -s
        pause
        printf '\nНавчальний репозиторій: %s\nЖодні файли не видалено. Це не новий репозиторій GitHub.\n' "$LAB"
        ;;
    *)
        printf 'Використання: bash scripts/practice-3.sh devops|git\n' >&2
        exit 2
        ;;
esac
