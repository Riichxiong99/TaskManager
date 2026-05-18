# Task Manager API

A REST API for creating and managing tasks, built with Spring Boot and PostgreSQL.

## Features

- Create, read, update, and delete tasks
- Track task completion status
- Automatic `createdAt` / `updatedAt` timestamp management

## Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 21 |
| Framework | Spring Boot 4.0.1 |
| ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL |
| Build | Maven (via wrapper) |

## Prerequisites

- Java 21+
- PostgreSQL running on `localhost:5432`

## Database Setup

Connect to PostgreSQL and run:

```sql
CREATE DATABASE taskdb;
CREATE USER taskuser WITH PASSWORD 'taskpass';
GRANT ALL PRIVILEGES ON DATABASE taskdb TO taskuser;
```

## Getting Started

```bash
# 1. Clone the repo
git clone https://github.com/Riichxiong99/TaskManager.git
cd TaskManager/taskmanager

# 2. Build
./mvnw clean package

# 3. Run
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

> **Windows:** use `mvnw.cmd` instead of `./mvnw`.

## API Reference

All endpoints are prefixed with `/api/tasks`.

| Method | Path | Description |
|--------|------|-------------|
| `GET` | `/api/tasks` | Get all tasks |
| `GET` | `/api/tasks/{id}` | Get a task by ID |
| `POST` | `/api/tasks` | Create a new task |
| `PUT` | `/api/tasks/{id}` | Update an existing task |
| `DELETE` | `/api/tasks/{id}` | Delete a task |

### Task JSON Shape

```json
{
  "id": 1,
  "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "completed": false,
  "createdAt": "2026-05-18T10:00:00",
  "updatedAt": "2026-05-18T10:00:00"
}
```

### Example Requests

**Create a task**
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title": "Buy groceries", "description": "Milk, eggs, bread"}'
```

**Update a task**
```bash
curl -X PUT http://localhost:8080/api/tasks/1 \
  -H "Content-Type: application/json" \
  -d '{"title": "Buy groceries", "completed": true}'
```

**Delete a task**
```bash
curl -X DELETE http://localhost:8080/api/tasks/1
```

## Project Structure

```
taskmanager/
├── src/main/java/com/example/taskmanager/
│   ├── TaskmanagerApplication.java   # Entry point
│   ├── controller/TaskController.java # REST endpoints
│   ├── service/TaskService.java       # Business logic
│   ├── repository/TaskRepository.java # Data access
│   └── model/Task.java               # Task entity
└── src/main/resources/
    └── application.properties         # DB and JPA config
```
