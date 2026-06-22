# User Service

The User Service is the central identity and profile management microservice of the **FitPeeps** platform. It manages user accounts, profile information, authentication-related data, and serves as the source of truth for user information across all microservices.

## Features

* User registration
* User profile management
* Retrieve user information
* Update user details
* Delete user accounts
* Store user fitness-related information
* PostgreSQL data persistence
* REST APIs for inter-service communication

## Technology Stack

* Java 25
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* REST APIs

## Service Responsibilities

The User Service handles:

* User account management
* User profile storage
* User data validation
* User information retrieval
* Communication with other services
* User-related business rules

## Project Structure

```text
src
├── main
│   ├── java
│   │   ├── controllers
│   │   ├── services
│   │   ├── repos
│   │   ├── models
│   │   ├── dtos
│   │   └── utils
│   └── resources
│       └── application.properties
└── test
```

## Database Schema

### User

| Field       | Type          | Description           |
| ----------- | ------------- | --------------------- |
| userId          | Long          | User Identifier       |
| name   | String        | User First Name       |
| email       | String        | User Email Address    |
| createdAt   | LocalDateTime | Account Creation Time |

## API Endpoints

### Create User

```http
POST /api/users
```

### Get User By Id

```http
GET /api/users/{userId}
```

### Get All Users

```http
GET /api/users
```

### Update User

```http
PUT /api/users/{userId}
```

### Delete User

```http
DELETE /api/users/{userId}
```

## Example Request

```json
{
  "name": "Praveen",
  "email": "praveen@example.com"
}
```

## Configuration

```properties
spring.application.name=user-service

server.port=8081

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

spring.jpa.hibernate.ddl-auto=update
```

## Running the Service

```bash
mvn clean install
mvn spring-boot:run
```

Service URL:

```text
http://localhost:8081
```

## Future Enhancements

* JWT Authentication
* OAuth2 Integration
* Role-Based Access Control (RBAC)
* Profile Picture Upload
* Password Encryption
* User Preferences Management

## Part of FitPeeps

The User Service acts as the primary source of user information and integrates with Activity, Meal, and Recommendation services to provide personalized fitness experiences.
