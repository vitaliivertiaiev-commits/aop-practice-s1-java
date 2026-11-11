# Самостійна 12. Залежності глибше

В окремому Maven-проєкті додав `httpclient5:5.3` і переглянув
транзитивні залежності командами `mvn dependency:tree`,
`mvn dependency:tree -Dverbose` та `mvn dependency:tree -Dincludes=...`.
У дереві видно `httpcore5`, `httpcore5-h2` і `slf4j-api`; команда підрахунку
показала 7 рядків залежностей.

`mvn dependency:analyze` позначив `httpclient5` як оголошену, але невикористану
залежність. Для перевірки конфлікту додав `commons-text:1.9`, який потребує
`commons-lang3:3.11`, тоді як проєкт напряму використовував `3.14.0`.
Maven залишив `3.14.0` і показав `3.11` як відкинуту версію. Після вилучення
`commons-text` дерево містило лише `commons-lang3:3.14.0`.

`mvn versions:display-dependency-updates` показав доступні оновлення.
Окремо встановив `lodash` у тимчасовому npm-проєкті й переглянув
`package-lock.json`, де записана точна версія `4.18.1`.

Спочатку SHA-256 двох JAR відрізнялися. Після фіксації
`project.build.outputTimestamp` дві чисті збірки дали однакову суму:
`b0c233f97f9a770f7ec226e0bbcb5438bb7f607286cde2e94419c2bff90b141e`.
