# Самостійна 14. Публікація Maven-артефакту

Створив бібліотеку `edu.course:demo`. Команди `mvn package` і `mvn install`
показали різницю між JAR у `target/` та артефактом у локальному Maven-репозиторії.
Підключив бібліотеку до `consumer` і побачив її у `mvn dependency:tree`.

Змінив реалізацію, перевстановивши ту саму версію `1.0.0`: споживач без повторної
збірки вивів змінений результат. Потім випустив нову версію `1.1.0`; обидві версії
є в локальному репозиторії. Переглянув effective POM, зібрав JAR `1.1.0` і
опублікував [GitHub-реліз `v1.1.0`](https://github.com/vitaliivertiaiev-commits/aop-practice-s1-java/releases/tag/v1.1.0)
з файлом `demo-1.1.0.jar`. Контрольна сума завантаженого JAR збігається зі зібраним.

## Скріншоти

- [Збірка й локальна інсталяція](../screenshots/h14/devops-01-package-install.jpg)
- [Підключення бібліотеки до consumer](../screenshots/h14/devops-02-consumer.jpg)
- [Та сама версія та перехід на 1.1.0](../screenshots/h14/devops-03-versioning.jpg)
- [Effective POM і JAR 1.1.0](../screenshots/h14/devops-04-effective-pom.jpg)
- [Опублікований реліз із JAR](../screenshots/h14/devops-05-release.jpg)
