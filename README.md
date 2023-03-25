# Sprint Mock Server

This repository contains an example of the mock server implementation, using Spring Boot.


## Dependency management

The project dependencies were created using Spring Initializer:

1. Navigate to https://start.spring.io
2. Choose either Gradle or Maven and the language you want to use
3. Click Dependencies and select Spring Web, Spring Data JPA, H2 Database, Lombok
4. Click Generate


## Run application

```shell
mvn spring-boot:run
```


## Endpoints

* Create session (returns session_id)
```
GET http://localhost:8083/session/create 
```
* POST data (saves request to a DB)
```
POST http://localhost:8083/data/post?session_id=<session_id> 
```
* GET data (saves request to a DB)
```
GET http://localhost:8083/data/get?session_id=<session_id> 
```
* DELETE data (saves request to a DB)
```
DELETE http://localhost:8083/data/delete?session_id=<session_id> 
```
* PATCH data (saves request to a DB)
```
PATCH http://localhost:8083/data/patch?session_id=<session_id> 
```
* Get results data (returns the list of requests made on mock)
```
GET http://localhost:8083/<session_id>/results/data 
```
