# Самостійна 14. Оновлення гілки

Перевірив `git stash` і `git stash pop`. Оновив гілку через `git rebase`, розв’язав
конфлікт і переніс окремий коміт командою `git cherry-pick`.

Відкрив PR №3 для цієї роботи. Поки він був відкритий, оновив огляд README в PR №4.
Після злиття №4 перебазував гілку PR №3 на новий `master` і оновив її командою
`git push --force-with-lease`.

## Скріншоти

- [Схованка змін](../screenshots/h14/git-01-stash.jpg)
- [Оновлення гілки через rebase](../screenshots/h14/git-02-rebase.jpg)
- [Розв’язання конфлікту rebase](../screenshots/h14/git-03-rebase-conflict.jpg)
- [Перенесення коміту cherry-pick](../screenshots/h14/git-04-cherry-pick.jpg)
- [Оновлення PR після rebase](../screenshots/h14/git-05-pr-rebase.jpg)
