# Multi Data Sources Demo

This service stores code for an example of AbstractRoutingDataSource realisation

## Requirements:

* Java 21
* Maven
* Docker

## Summary

In this example 3 Postgres Data Bases configured for service and there is a one endpoint to collect data from all of them.
By default, you will get an empty list.
You can find a few sql scripts to insert data manually and check the API work.
Use any tool to view DB data (psql commands, pgAdmin).

## How to start the application:

1. Setup service's dependencies with docker-compose:
   - `cd ${DOCKER_COMPOSE_YML_LOCATION}`
   - `docker-compose up -d`
2. pgAdmin will be available on http://127.0.0.1:8888
![](../../Desktop/Screenshot 2024-07-02 at 01.25.04.png)

3. Change schemas owners to testuser and qa_users with GUI or script issues_db.sql
4. Enter the root project folder
5. Execute `mvn clean install -DskipTests`
6. Execute `mvn spring-boot:run "-Dspring-boot.run.profiles=local"` to start the app
7. Once app is running you can use http://locallhost:8081/demo/api/users to check the API
8. Execute `mvn clean test -Dspring.profiles.active=test`
