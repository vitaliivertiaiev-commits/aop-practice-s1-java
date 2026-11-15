# Самостійна 13. Репозиторії пакетів

Переглянув каталог `commons-lang3` у Maven Central і знайшов у ньому різні версії
та файли артефакту `3.14.0`. Завантажив бібліотеку до локального Maven-кешу й
звірив SHA-1 з опублікованою контрольною сумою — значення збіглися.

Командою `mvn dependency:get` завантажив `gson:2.10.1` і перевірив файли в
`~/.m2/repository`. У налаштуваннях Maven використовується Maven Central за
замовчуванням; локального `settings.xml` немає.

Переглянув адреси реєстрів npm і Python, отримав метадані `lodash` з npm registry
та встановив `lodash:4.18.1` у тимчасовий проєкт. У `package-lock.json`
зафіксовано версію `4.18.1`. Залежності цього проєкту завантажуються з Maven
Central.

## Скріншоти

- [Maven Central і збіг контрольної суми](../screenshots/h13/devops-01-maven-central.jpg)
- [Maven-кеш і налаштування](../screenshots/h13/devops-02-maven-cache-settings.jpg)
- [Реєстри npm і Python, lock-файл](../screenshots/h13/devops-03-registries-lock.jpg)
- [Залежності проєкту й Maven Central за замовчуванням](../screenshots/h13/devops-04-public-dependencies.jpg)
