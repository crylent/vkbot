## Что это?
Бот, который цитирует присланный ему текст

![image](https://github.com/crylent/vkbot/assets/35966912/8b7f157a-7b7d-44ca-a7ce-8d004c51e72d)


## Как запустить?
1) Скачать и распаковать [ZIP-файл](https://github.com/crylent/vkbot/releases/download/v0.1/vkbot.zip) из раздела Releases
2) Открыть файл `config/vk.properties` и вставить необходимые данные:
    - `vk.access_key` — ключ доступа
    - `vk.confirmation_key` — строка для подтверждения адреса сервера
    - `vk.secret_key` — секретный ключ

![image](https://github.com/crylent/vkbot/assets/35966912/1cc9701d-db0f-4e43-8474-9ebcc10aff64)
![image](https://github.com/crylent/vkbot/assets/35966912/13f7c9c3-42b2-46ac-8848-781bf62ae93f)
![image](https://github.com/crylent/vkbot/assets/35966912/f343325d-4fe5-4ee1-918f-8a1a85bb53ef)

3) (Опционально) Открыть файл `config/message-template.txt` и изменить шаблон ответного сообщения
4) В командной строке из директории с файлом `vkbot.jar` выполнить команду `java -jar vkbot.jar` (должна быть установлена Java 17)
5) В настройках Callback API в ВК выбрать версию API 5.199 и вставить адрес сервера, затем нажать подтвердить

![image](https://github.com/crylent/vkbot/assets/35966912/2b05cc18-6860-443e-a2d9-99825ae8f445)

6) Если всё сделано правильно, ВК сообщит, что адрес подтверждён; с этого момента бот работает

### Альтернативный способ
Клонировать репозиторий и запустить программу либо из IntelliJ IDEA, либо из командной строки с помощью команды `gradlew bootRun`, находясь в корневой директории проекта. В этом случае, задать вышеперечисленные параметры необходимо в файле `src/main/resources/vk.properties`
