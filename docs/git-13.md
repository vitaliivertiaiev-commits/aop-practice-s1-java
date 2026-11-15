# Самостійна 13. Pull request

Переглянув відкритий PR у `djnzx/java-template`: виконав `gh pr list`,
`gh pr checkout 1`, подивився останні коміти й змінені файли командами
`git log --oneline -3` та `git diff --stat master...HEAD`, потім повернувся
до `master` командою `git switch -`.

У своєму репозиторії створив гілку `fix/readme`, додав до README спосіб
запуску тестів і зміни Самостійної 13, виконав коміт і push. Створив PR №1
з `fix/readme` у `master`.

- [Перегляд PR і перемикання гілок](../screenshots/h13/git-01-review-other-pr.jpg)
- [Гілка й відкритий PR](../screenshots/h13/git-02-own-pr.jpg)
