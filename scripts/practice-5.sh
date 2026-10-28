#!/usr/bin/env bash
# Безпечні, згруповані для смартфона DevOps і Git вправи практичної 5.
set -euo pipefail

run() {
    printf '\n$'
    printf ' %q' "$@"
    printf '\n'
    "$@"
}

pause() {
    printf '\n--- Зроби скриншот цієї частини, потім натисни Enter. ---\n'
    if [ -t 0 ]; then
        read -r _
    fi
}

mkdir -p "$HOME/dev"

case "${1:-}" in
    all)
        printf 'Спочатку DevOps, потім Git; кожна частина зупиняється для скриншота.\n'
        bash "$0" devops
        bash "$0" git
        ;;

    devops)
        LAB=$(mktemp -d "$HOME/dev/devops5.XXXXXX")
        cd "$LAB"

        printf '\n=== DEVOPS 1: змінні та лапки ===\n'
        printf '$ NAME=world\n'
        NAME=world
        printf '$ echo "hello $NAME"\n'
        echo "hello $NAME"
        printf '$ bash -c '\''NAME = world'\''\n'
        if bash -c 'NAME = world'; then
            printf 'Неочікувано: команда спрацювала.\n'
        else
            printf 'exit=%s (пробіл змусив Bash шукати команду NAME)\n' "$?"
        fi
        FILE="мій файл.txt"
        printf '\n$ echo "$FILE"\n'
        echo "$FILE"
        printf '$ echo '\''$FILE'\''\n'
        echo '$FILE'
        printf '$ touch $FILE  # без лапок: створяться два файли\n'
        touch $FILE
        run ls -l -- мій файл.txt
        rm -f -- мій файл.txt
        printf '$ touch "$FILE"  # із лапками: один файл\n'
        touch "$FILE"
        run ls -l -- "$FILE"
        rm -- "$FILE"
        pause

        printf '\n=== DEVOPS 2: shebang, аргументи та права ===\n'
        cat > greet.sh <<'EOF'
#!/bin/bash
set -euo pipefail
echo "Привіт, $1!"
echo "Аргументів: $#"
EOF
        run ls -l greet.sh
        printf '$ ./greet.sh "Іван В."  # спершу немає права на виконання\n'
        if ./greet.sh 'Іван В.'; then
            printf 'exit=0\n'
        else
            printf 'exit=%s (очікувано: немає права на виконання)\n' "$?"
        fi
        run chmod +x greet.sh
        run ls -l greet.sh
        run ./greet.sh 'Іван В.'
        pause

        printf '\n=== DEVOPS 3: ./script.sh та bash script.sh ===\n'
        run chmod -x greet.sh
        printf '$ ./greet.sh "Іван"  # без x — помилка\n'
        if ./greet.sh Іван; then
            printf 'exit=0\n'
        else
            printf 'exit=%s\n' "$?"
        fi
        run bash greet.sh Іван
        run chmod +x greet.sh
        pause

        printf '\n=== DEVOPS 4: set -euo pipefail та коди виходу ===\n'
        cat > unsafe.sh <<'EOF'
#!/bin/bash
cd /no/such/dir
echo "unsafe.sh продовжив після помилки cd"
EOF
        cat > safe.sh <<'EOF'
#!/bin/bash
set -euo pipefail
cd /no/such/dir
echo "цього рядка не буде"
EOF
        run chmod +x unsafe.sh safe.sh
        printf '$ ./unsafe.sh; echo "exit=$?"\n'
        if ./unsafe.sh; then
            printf 'exit=0\n'
        else
            printf 'exit=%s\n' "$?"
        fi
        printf '$ ./safe.sh\n'
        if ./safe.sh; then
            printf 'exit=0\n'
        else
            printf 'exit=%s (safe.sh зупинився на помилці)\n' "$?"
        fi
        pause

        printf '\n=== DEVOPS 5: set -u та скрипт з аргументами ===\n'
        cat > strict.sh <<'EOF'
#!/bin/bash
set -u
echo "значення: $UNDEFINED_VAR"
EOF
        run chmod +x strict.sh
        printf '$ ./strict.sh\n'
        if ./strict.sh; then
            printf 'exit=0\n'
        else
            printf 'exit=%s (set -u зупинив скрипт)\n' "$?"
        fi

        cat > count.sh <<'EOF'
#!/bin/bash
set -euo pipefail
if [ "$#" -ne 2 ]; then
    echo "Usage: $0 DIRECTORY EXTENSION" >&2
    exit 2
fi
DIR="$1"
EXT="$2"
COUNT=$(find "$DIR" -type f -name "*.$EXT" | wc -l)
echo "У $DIR файлів .$EXT: $COUNT"
EOF
        DATA="$LAB/count data"
        mkdir -p "$DATA/sub dir"
        touch "$DATA/one.txt" "$DATA/two.txt" "$DATA/sub dir/three.txt"
        touch "$DATA/readme.md"
        run chmod +x count.sh
        run ./count.sh "$DATA" txt
        run ./count.sh "$DATA" md
        pause
        printf '\nНавчальні файли залишено в %s; це тимчасова тека.\n' "$LAB"
        ;;

    git)
        LAB=$(mktemp -d "$HOME/dev/git5.XXXXXX")
        REPO="$LAB/repo"
        mkdir -p "$REPO"
        git init -q -b main "$REPO"
        cd "$REPO"
        git config user.name 'Practice 5 demo'
        git config user.email 'practice5@example.invalid'
        # Replit globally ignores .env; isolate this lesson so the staged-file example works.
        run git config core.excludesFile /dev/null

        printf '\n=== GIT 1: build, налаштування і .gitignore ===\n'
        mkdir -p target .idea
        printf 'class file\n' > target/Main.class
        printf 'local setting\n' > .idea/workspace.xml
        printf 'public class Main {}\n' > Main.java
        run git status --short --untracked-files=all
        printf '$ printf "target/\\n.idea/\\n" > .gitignore\n'
        printf 'target/\n.idea/\n' > .gitignore
        run git status --short --untracked-files=all
        run git add .
        run git commit -m 'додати код і правила ігнорування'
        run git status --short --ignored
        pause

        printf '\n=== GIT 2: відстежуваний .env і git rm --cached ===\n'
        printf 'DEMO_TOKEN=NOT_A_REAL_CREDENTIAL\n' > .env
        run git add .env
        run git commit -m 'додати навчальний env-файл'
        printf '$ echo ".env" >> .gitignore\n'
        printf '.env\n' >> .gitignore
        printf '$ git ls-files --error-unmatch .env  # правило ще не зняло стеження\n'
        run git ls-files --error-unmatch .env
        run git status --short
        run git rm --cached -- .env
        printf '$ test -f .env && echo "файл лишився на диску"\n'
        test -f .env && echo 'файл лишився на диску'
        run git add .gitignore
        run git commit -m 'припинити відстежувати env-файл'
        run git status --short --ignored
        pause

        printf '\n=== GIT 3: шаблони та винятки ===\n'
        printf '$ додати logs/, *.log, !keep.log та /build до .gitignore\n'
        printf 'logs/\n*.log\n!keep.log\n/build\n' >> .gitignore
        mkdir -p logs build src/build
        touch logs/a.log app.log keep.log build/output.txt src/deep.log
        touch src/build/example.txt
        run git status --short --untracked-files=all
        printf 'Видимі винятки: keep.log і src/build/example.txt.\n'
        pause

        printf '\n=== GIT 4: check-ignore і безпечний git clean ===\n'
        run git check-ignore -v target/Main.class
        run git check-ignore -v .env
        printf '$ git status --ignored --short | head -15\n'
        git status --ignored --short | head -15
        printf 'scratch\n' > scratch.txt
        run git clean -n
        run git clean -fd
        run git status --short --ignored
        printf 'Видалення обмежене тимчасовим репозиторієм %s.\n' "$REPO"
        pause

        printf '\n=== GIT 5: відстеження файла в окремих гілках ===\n'
        BRANCH_REPO="$LAB/branch-move"
        mkdir -p "$BRANCH_REPO"
        git init -q -b main "$BRANCH_REPO"
        git -C "$BRANCH_REPO" config user.name 'Practice 5 demo'
        git -C "$BRANCH_REPO" config user.email 'practice5@example.invalid'
        printf 'base\n' > "$BRANCH_REPO/README.md"
        git -C "$BRANCH_REPO" add README.md
        git -C "$BRANCH_REPO" commit -qm 'спільна основа'
        run git -C "$BRANCH_REPO" switch -c draft
        run git -C "$BRANCH_REPO" switch main
        printf 'public class Main {}\n' > "$BRANCH_REPO/Main.java"
        run git -C "$BRANCH_REPO" add Main.java
        run git -C "$BRANCH_REPO" commit -m 'додати Main.java на main'
        run git -C "$BRANCH_REPO" rm --cached -- Main.java
        run git -C "$BRANCH_REPO" status --short
        printf '$ test -f Main.java && echo "файл лишився на диску"\n'
        test -f "$BRANCH_REPO/Main.java" && echo 'файл лишився на диску'
        run git -C "$BRANCH_REPO" commit -m 'прибрати Main.java зі стеження на main'
        run git -C "$BRANCH_REPO" switch draft
        run git -C "$BRANCH_REPO" status --short
        run git -C "$BRANCH_REPO" add Main.java
        run git -C "$BRANCH_REPO" commit -m 'додати Main.java на draft'
        printf '$ git ls-tree -r --name-only main\n'
        git -C "$BRANCH_REPO" ls-tree -r --name-only main
        printf '$ git ls-tree -r --name-only draft\n'
        git -C "$BRANCH_REPO" ls-tree -r --name-only draft
        run git -C "$BRANCH_REPO" switch main
        printf 'Відновлюємо файл на main окремим комітом.\n'
        printf 'public class Main {}\n' > "$BRANCH_REPO/Main.java"
        run git -C "$BRANCH_REPO" add Main.java
        run git -C "$BRANCH_REPO" commit -m 'відновити Main.java на main'
        run git -C "$BRANCH_REPO" status --short --branch
        pause
        printf '\nНавчальні Git-репозиторії залишено в %s; це не GitHub.\n' "$LAB"
        ;;

    *)
        printf 'Використання: bash scripts/practice-5.sh all|devops|git\n' >&2
        exit 2
        ;;
esac
