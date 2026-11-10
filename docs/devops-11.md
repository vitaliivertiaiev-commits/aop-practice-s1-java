# Практична 11. Залежності Maven

Для цієї вправи створив окремий Maven-проєкт `demo`, щоб не змінювати
`pom.xml` основного репозиторію.

Спочатку запустив `mvn dependency:tree`: у дереві була лише сама програма.
Потім додав у `pom.xml` залежність
`org.apache.commons:commons-lang3:3.14.0`. Команди
`mvn dependency:resolve` та `mvn dependency:tree` показали її в дереві.

У `Main.java` використав `StringUtils.reverse` і `StringUtils.isBlank`.
`mvn compile` та `mvn package` завершилися успішно. Запуск програми вивів
перевернуте слово `алгоритм` і значення `true`.

Знайшов JAR у каталозі `org/apache/commons/commons-lang3/3.14.0/`.
Для перевірки повторного завантаження використав окремий тимчасовий кеш Maven:
видалив звідти копію `commons-lang3`, запустив `mvn dependency:resolve`,
а потім перевірив розв'язання залежності в офлайн-режимі.

Окремо виконав `mvn dependency:get -Dartifact=com.google.code.gson:gson:2.10.1`
і знайшов завантажений Gson у локальному Maven-кеші. До `pom.xml` цю бібліотеку
не додавав.

Для порівняння створив окремий проєкт командою `gradle init`, додав ту саму
залежність до `app/build.gradle` і виконав
`./gradlew :app:dependencies --configuration runtimeClasspath`. У дереві Gradle
також відобразився `commons-lang3:3.14.0`.
