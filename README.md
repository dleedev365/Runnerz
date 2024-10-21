# Description
A fitness application that allows you to track runs through a REST API

## What I learned from this project
- What Spring is and what it can do
- How to build a web application with Spring Boot
- How to test a Spring Boot application
- How to use Spring Data to interact with a database


## Technologies used
- Docker
- PostgreSQL
- IntelliJ / Spring Boot

## How to Run
1. run "docker compose up" to start postgres database
2. Example API endpoints

```java
// Find ALl Runs
GET http://localhost:8080/api/runs

// Find Run By ID
GET http://localhost:8080/api/runs/<id>

// Create new Run
POST http://localhost:8080/api/runs

// Create new Run with invalid dates (completedOn is before startedOn)
POST http://localhost:8080/api/runs

// Update an existing Run
PUT http://localhost:8080/api/runs/<id>

// Delete a Run
DELETE http://localhost:8080/api/runs/<id>
```

## Personal Notes for new Concepts Learned
### TL;DR
- A Spring Bean is an object managed by the Spring IoC container, typically used for services, components, and dependency injection.
- A Java Record is a new type in Java for immutable data objects, minimizing boilerplate code for simple data holders.

#### What is "Bean" in Spring Boot?
A bean is an object that is managed by the Spring IoC (Inversion of Control) container. Beans are central to the Spring Framework, as they enable dependency injection, configuration, and life cycle management of objects.

Key features of beans:
- Beans are created, configured, and managed by Spring.
- They are typically annotated with @Component, @Service, @Repository, or @Controller, which tells Spring to detect and register them automatically.
- Beans can be manually defined in a configuration class using the @Bean annotation.

- Example:

```java
@Service
public class UserService {
    public void processUser() {
        System.out.println("Processing user...");
    }
}
```
This UserService is a Spring-managed bean because it is annotated with @Service, and Spring automatically instantiates and injects it wherever required.

Manual Bean Configuration:
You can also define beans in a configuration class like this:

```java
@Configuration
public class AppConfig {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
```

#### What is "Record" in Java (introduced in Java 14)?
A record in Java is a special kind of class designed to be a simple and concise way of creating immutable data carriers (data classes) with minimal boilerplate code. Records are ideal when the primary purpose of the class is to store data.

Key features of records:
- Records are immutable: once created, their fields cannot be changed.
- Records automatically generate boilerplate code like constructors, equals(), hashCode(), and toString() methods.
- They are defined using the record keyword.

- Example:

```java
public record User(String name, int age) {
}
```

This User record automatically generates:
- A constructor: new User(String name, int age)
- Getters: user.name() and user.age()
- equals(), hashCode(), and toString() methods.
- Records are not a Spring Boot concept specifically but a core Java feature that can be used within Spring applications.
