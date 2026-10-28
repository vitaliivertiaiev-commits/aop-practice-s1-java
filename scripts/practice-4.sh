#!/usr/bin/env bash
# Безпечні, згруповані для смартфона DevOps та Git вправи практичної 4.
set -u

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
    devops)
        LAB=$(mktemp -d "$HOME/dev/devops4.XXXXXX")
        cd "$LAB"
        printf '\n=== DEVOPS 1: перезапис і дописування ===\n'
        printf '$ echo "перший рядок" > out.txt\n'
        echo "перший рядок" > out.txt
        run cat out.txt
        printf '$ echo "другий рядок" > out.txt\n'
        echo "другий рядок" > out.txt
        run cat out.txt
        printf '$ echo "третій рядок" >> out.txt\n'
        echo "третій рядок" >> out.txt
        run cat out.txt
        pause

        printf '\n=== DEVOPS 2: конвеєри, grep, sort та uniq ===\n'
        printf '$ seq 1 200 > numbers.txt\n'
        seq 1 200 > numbers.txt
        printf '$ cat numbers.txt | grep 5 | head\n'
        cat numbers.txt | grep 5 | head
        printf '$ cat numbers.txt | grep 5 | wc -l\n'
        cat numbers.txt | grep 5 | wc -l
        run grep -c 5 numbers.txt
        printf '$ printf "Іван\\nОлена\\nІван\\nПетро\\nОлена\\nІван\\n" > names.txt\n'
        printf 'Іван\nОлена\nІван\nПетро\nОлена\nІван\n' > names.txt
        run sort names.txt
        printf '$ sort names.txt | uniq -c | sort -rn\n'
        sort names.txt | uniq -c | sort -rn
        pause

        printf '\n=== DEVOPS 3: stdout окремо від stderr ===\n'
        printf '$ ls . /no/such/dir\n'
        ls . /no/such/dir || true
        printf '$ ls . /no/such/dir > out.txt\n'
        ls . /no/such/dir > out.txt || true
        printf '$ cat out.txt\n'
        cat out.txt
        printf '$ ls . /no/such/dir 2> err.txt\n'
        ls . /no/such/dir 2> err.txt || true
        run cat err.txt
        pause

        printf '\n=== DEVOPS 4: обʼєднання потоків та конвеєр ===\n'
        printf '$ ls . /no/such/dir > all.txt 2>&1\n'
        ls . /no/such/dir > all.txt 2>&1 || true
        run cat all.txt
        printf '$ ls . /no/such/dir 2>/dev/null\n'
        ls . /no/such/dir 2>/dev/null || true
        printf '$ ls . /no/such/dir | grep -c ""\n'
        ls . /no/such/dir | grep -c "" || true
        printf '$ ls . /no/such/dir 2>&1 | grep -c ""\n'
        ls . /no/such/dir 2>&1 | grep -c "" || true
        pause

        printf '\n=== DEVOPS 5: пошук файлів та тексту ===\n'
        run find . -name '*.txt'
        printf '$ find . -name "*.txt" | wc -l\n'
        find . -name '*.txt' | wc -l
        printf '$ grep -rn "Іван" . | head\n'
        grep -rn 'Іван' . | head
        printf '$ grep -rn "Іван" . | wc -l\n'
        grep -rn 'Іван' . | wc -l
        pause
        printf '\nНавчальні файли залишено в %s\n' "$LAB"
        ;;
    git)
        LAB=$(mktemp -d "$HOME/dev/git-remotes4.XXXXXX")
        REMOTE="$LAB/github.git"
        LOCAL="$LAB/local"
        WEB="$LAB/web"

        printf '\n=== GIT 1: origin, адреси й tracking ===\n'
        run git init --bare --initial-branch=main "$REMOTE"
        run git init --initial-branch=main "$LOCAL"
        cd "$LOCAL"
        git config user.name 'Practice 4 demo'
        git config user.email 'practice4@example.invalid'
        printf 'основний рядок\nконтекст\n' > notes.txt
        run git add notes.txt
        run git commit -m 'початковий коміт'
        run git remote add origin "$REMOTE"
        run git push -u origin main
        run git remote -v
        run git remote show origin
        run git branch -vv
        pause

        printf '\n=== GIT 2: дві копії та відхилений push ===\n'
        git clone -q "$REMOTE" "$WEB"
        git -C "$WEB" config user.name 'Web copy'
        git -C "$WEB" config user.email 'web@example.invalid'
        sed -i '1s/основний рядок/рядок з вебкопії/' "$WEB/notes.txt"
        run git -C "$WEB" add notes.txt
        run git -C "$WEB" commit -m 'зміна з вебкопії'
        run git -C "$WEB" push
        printf '$ echo "локальний рядок" >> notes.txt\n'
        echo "локальний рядок" >> notes.txt
        run git add notes.txt
        run git commit -m 'локальна зміна'
        printf '\nОчікуване відхилення push: у remote є ще один коміт.\n'
        git push 2>&1 || true
        pause

        printf '\n=== GIT 3: fetch, історія розходження та pull ===\n'
        run git fetch
        run git status
        run git --no-pager log --oneline origin/main..HEAD
        run git --no-pager log --oneline HEAD..origin/main
        run git -c core.editor=true pull --no-rebase
        run git --no-pager log --oneline --graph -5
        run git push
        pause

        printf '\n=== GIT 4: ще один fetch та інші remote-імена ===\n'
        run git -C "$WEB" pull --ff-only
        sed -i '2s/контекст/ще одна вебзміна/' "$WEB/notes.txt"
        run git -C "$WEB" commit -am 'ще одна зміна з вебкопії'
        run git -C "$WEB" push
        run git fetch
        run git status
        run git --no-pager log --oneline HEAD..origin/main
        run git pull --ff-only
        run git remote rename origin github
        run git remote -v
        run git branch -vv
        run git config --get branch.main.remote
        run git push github main
        run git remote rename github origin
        run git remote add upstream "$REMOTE"
        run git fetch upstream
        run git remote -v
        run git remote remove upstream
        printf '\n$ cat .git/config\n'
        cat .git/config
        pause
        printf '\nНавчальний remote і копії залишено в %s; це не GitHub.\n' "$LAB"
        ;;
    *)
        printf 'Використання: bash scripts/practice-4.sh devops|git\n' >&2
        exit 2
        ;;
esac
