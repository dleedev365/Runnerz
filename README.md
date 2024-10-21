# Description
A fitness application that allows you to track runs through a REST API

### What I learned from this project
- What Spring is and what it can do
- How to build a web application with Spring Boot
- How to test a Spring Boot application
- How to use Spring Data to interact with a database


### Technologies used
- Docker
- PostgreSQL
- IntelliJ / Spring Boot

### How to Run
1. run "docker compose up" to start postgres database
2. Example API endpoints

```java
// Find ALl Runs
GET http://localhost:8080/api/runs

// Find Run By ID
GET http://localhost:8080/api/runs/<id>

// Create new Run
POST http://localhost:8080/api/runs
Content-Type: application/json

// Create new Run with invalid dates (completedOn is before startedOn)
POST http://localhost:8080/api/runs

// Update an existing Run
PUT http://localhost:8080/api/runs/<id>

// Delete a Run
DELETE http://localhost:8080/api/runs/<id>
```
