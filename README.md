# FSAD Experiment 7 - Course Management REST API

Spring Boot REST API for Course CRUD operations with search functionality.

## Features
- Full CRUD operations for Course entity
- Search courses by title
- ResponseEntity with proper HTTP status codes
- In-memory data storage

## Course Entity
- courseId (Long)
- title (String)
- duration (Integer)
- fee (Double)

## REST Endpoints

### 1. Create Course
**POST** `/courses`
```json
{
  "title": "Java Programming",
  "duration": 40,
  "fee": 5000.0
}
```
Response: 201 CREATED

### 2. Get All Courses
**GET** `/courses`
Response: 200 OK

### 3. Get Course by ID
**GET** `/courses/{id}`
Response: 200 OK or 404 NOT_FOUND

### 4. Update Course
**PUT** `/courses/{id}`
```json
{
  "title": "Advanced Java",
  "duration": 50,
  "fee": 6000.0
}
```
Response: 200 OK or 404 NOT_FOUND

### 5. Delete Course
**DELETE** `/courses/{id}`
Response: 200 OK or 404 NOT_FOUND

### 6. Search by Title
**GET** `/courses/search/{title}`
Response: 200 OK or 404 NOT_FOUND

## Running the Application
```bash
mvn spring-boot:run
```
Server runs on: http://localhost:8080

## Postman Test Cases

### Valid Cases:
1. Create course with all fields
2. Get all courses
3. Get existing course by ID
4. Update existing course
5. Search with matching title
6. Delete existing course

### Invalid Cases:
1. Create course with missing fields (400 BAD_REQUEST)
2. Get non-existent course (404 NOT_FOUND)
3. Update non-existent course (404 NOT_FOUND)
4. Delete non-existent course (404 NOT_FOUND)
5. Search with no matches (404 NOT_FOUND)

## Author
KL University - 2400032183
