# spring-keycloak-oauth
1. Скачать и запутить keycloak
2. Импортировать realm-export.json с заменой в keycloak
3. Скачать проект
```
git clone https://github.com/danijar2000/spring-keycloak-oauth.git
cd spring-keycloak-oauth
```
4. Запустить
```
./mvnw clean spring-boot:run
```
5. Открыть в браузере проект.
http://localhost:8082/

6. Перейти по ссылке "My page" и авторизоваться используюя логни:test пароль:test